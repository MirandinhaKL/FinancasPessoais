/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Main;
import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import model.Categoria;
import model.Movimentacao;
import model.TipoDeMovimentacao;
import model.dao.MovimentacaoDAO;

public class TelaPrincipalController implements Initializable {

    private Main main;
    private Stage palco;
    private ObservableList<Movimentacao> movimentacaoObservable;
    private MovimentacaoDAO movimentacaoDAO;
    private List<Movimentacao> listaDeMovimentacoes;

    @FXML
    private Label labelSaldoAtual;

    @FXML
    private Label labelSaldoPrevisto;

    @FXML
    private Label labelTipo;

    @FXML
    private Label labelUltimaMovimentacao;

    @FXML
    private ComboBox<String> comboBoxMes;

    @FXML
    private TableView<Movimentacao> tabelaMovimentacao;

    @FXML
    private TableColumn<Movimentacao, LocalDate> colunaData;

    @FXML
    private TableColumn<TipoDeMovimentacao, String> colunaTipo;

    @FXML
    private TableColumn<Categoria, String> colunaCategoria;

    @FXML
    private TableColumn<Movimentacao, Double> colunaValor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencheComboBoxMes();
        criaTabela();
        carregarTabelaComDadosDoBanco();
//        exibeUltimaMovimentacao();
//        configuraLabelDoSaldoAtual();
//        configuraLabelDoSaldoPrevisto();
    }

    @FXML
    void handleButtonExcluirMovimentacao(ActionEvent event) {
        Movimentacao movimentacao = tabelaMovimentacao.getSelectionModel().getSelectedItem();
        if (movimentacao != null) {
            movimentacaoDAO = new MovimentacaoDAO();
            movimentacaoDAO.removeMovimentacao(movimentacao);
            carregarTabelaComDadosDoBanco();
        } else {
            String titulo = "Falha na exclusão!";
            String cabecalho = "Item não excluído!";
            String mensagem = "Por favor, selecione uma movimentação"
                    + " financeira na tabela ao lado.";
            main.mostraAlerta(Alert.AlertType.WARNING, titulo, cabecalho, mensagem);
        }
        System.out.println("Excluir movimentação");
    }
    
    public void exibeUltimaMovimentacao() {
        int tamanho = movimentacaoObservable.size();
        labelTipo.setText(movimentacaoObservable.get(tamanho - 1).exibeTipoDeMovimentacao());
        labelUltimaMovimentacao.setText(movimentacaoObservable.get(tamanho - 1).exibeValorDaMovimentacao());
    }
    
    /**
     * @param tipo - Informa se a movimentação é uma receita ou despesa.
     * @param ehNofuturo boolean = 0, se já aconteceu. 1, se a operação foi
     * agendada.
     * @return somatório de todas as movimentações especificas realizadas.
     */
    public double calculaMovimentacao(String tipo, boolean ehNofuturo) {
        String tipoDeMovimentacao;
        boolean statusDaMovimentacao;
        double somatorioMovimentacoes = 0;
        for (int i = 0; i < movimentacaoObservable.size(); i++) {
            tipoDeMovimentacao = movimentacaoObservable.get(i).getTipo().getDescricao();
            statusDaMovimentacao = movimentacaoObservable.get(i).getParaOfuturo(); //alterada
            if (tipoDeMovimentacao.equalsIgnoreCase(tipo) && (statusDaMovimentacao == ehNofuturo)) {
                somatorioMovimentacoes = somatorioMovimentacoes + movimentacaoObservable.get(i).getValor();
            }
        }
        return somatorioMovimentacoes;
    }
    
    /**
     * @return Somatório das desepesas efetuadas.
     */
    public double calculoDaDespesaAtual() {
        return calculaMovimentacao("Despesa", false);
    }

    /**
     * @return Somatório das desepesas efetuadas + as planejadas.
     */
    public double calculaDaDespesaFutura() {
        return calculaMovimentacao("Despesa", true) + calculoDaDespesaAtual();
    }

    /**
     * @return Somatório das receitas efetuadas.
     */
    public double calculaDaReceitaAtual() {
        return calculaMovimentacao("Receita", false);
    }

    /**
     * @return Somatório das receitas efetuadas + as planejadas.
     */
    public double calculoDaReceitaFutura() {
        return calculaMovimentacao("Receita", true) + calculaDaReceitaAtual();
    }

    /**
     * @return Retorna o saldo atual das movimentações financeiras efetuadas.
     */
    public double calculaSaldoAtual() {
        return calculaDaReceitaAtual() - calculoDaDespesaAtual();
    }

    /**
     * @return Retorna o saldo atual das movimentações financeiras efetuadas +
     * as previstas.
     */
    public double calculaSaldoPrevisto() {
        return calculoDaReceitaFutura() + calculaDaReceitaAtual() - calculaDaDespesaFutura() - calculoDaDespesaAtual();
    }
    
    public void configuraLabelDoSaldoPrevisto() {
        labelSaldoPrevisto.setText("R$ " + String.format("%.2f", calculaSaldoPrevisto()));
        if (calculaSaldoPrevisto() < 0) {
            labelSaldoPrevisto.setStyle("-fx-text-fill: red");
        } else {
            labelSaldoPrevisto.setStyle("-fx-text-fill: green");
        }
    }
    
    /**
     * Configura na tela principal a cor do saldo atual exibido.
     */
    public void configuraLabelDoSaldoAtual() {
        labelSaldoAtual.setText("R$ " + String.format("%.2f", calculaSaldoAtual()));
        if (calculaSaldoAtual() < 0) {
            labelSaldoAtual.setStyle("-fx-text-fill: red");
        } else {
            labelSaldoAtual.setStyle("-fx-text-fill: green");
        }
    }
    
    @FXML
    void handleButtonInserirMovimentacao(ActionEvent event) {
        main.exibeTelaInsereMovimentacao();
        System.out.println("Inserir movimentação");
    }

    @FXML
    void handleComboBoxMes(ActionEvent event) {
        System.out.println("Handle Combo Box");
    }

    @FXML
    void handleDespesaPorCategoria(ActionEvent event) {
        System.out.println("Abre tela de gráfico despesa x categoria");
    }

    @FXML
    void handleReceitaXdespesa(ActionEvent event) {
        System.out.println("Abre tela gráfico receita x despesa");
    }

    public void preencheComboBoxMes() {
        comboBoxMes.getItems().removeAll(comboBoxMes.getItems());
        comboBoxMes.getItems().addAll("Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho",
                "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro");
    }

    private void criaTabela() {
        tabelaMovimentacao.setItems(movimentacaoObservable);
        colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
    }

    public void carregarTabelaComDadosDoBanco() {
        movimentacaoDAO = new MovimentacaoDAO();
        listaDeMovimentacoes = movimentacaoDAO.retornaListaDeMovimentacoes();
        movimentacaoObservable = FXCollections.observableArrayList(listaDeMovimentacoes);
        tabelaMovimentacao.setItems(movimentacaoObservable);
        colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colunaTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));
        colunaCategoria.setCellValueFactory(new PropertyValueFactory<>("categoria"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stageLogin) {
        this.palco = stageLogin;
    }
}
