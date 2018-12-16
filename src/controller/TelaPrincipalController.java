package controller;

import aplicacao.Main;
import java.net.URL;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.value.ObservableValue;
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
import javafx.util.StringConverter;
import model.property.Movimentacao;
import model.dao.professor.MovimentacaoDAO;
import model.property.TipoDeMovimentacao;

public class TelaPrincipalController implements Initializable {

    private Main main;
    private Stage palco;
    private ObservableList<Movimentacao> movimentacaoObservable;
    private ObservableList<Movimentacao> listaDeMovimentacoes;
    private MovimentacaoDAO movimentacaoDAO;

    @FXML
    private Label labelSaldoAtual;

    @FXML
    private Label labelSaldoPrevisto;

    @FXML
    private Label labelTipo;

    @FXML
    private Label labelUltimaMovimentacao;

    @FXML
    private ComboBox<LocalDate> comboBoxMes;

    @FXML
    private TableView<Movimentacao> tabelaMovimentacao;

    @FXML
    private TableColumn<Movimentacao, LocalDate> colunaData;

    @FXML
    private TableColumn<Movimentacao, String> colunaTipo;

    @FXML
    private TableColumn<Movimentacao, String> colunaCategoria;

    @FXML
    private TableColumn<Movimentacao, Double> colunaValor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencheComboBoxMes();
        carregarTabelaComDadosDoBanco(LocalDate.now().getMonthValue());
        exibeUltimaMovimentacao();
        configuraLabelDoSaldoAtual();
        configuraLabelDoSaldoPrevisto();
    }

    private void inicializaColunas() {

        colunaData.setCellValueFactory(cellData -> cellData.getValue().getDataProperty());
        colunaTipo.setCellValueFactory(cellData -> cellData.getValue().getTipo().getDescricaoProperty());
        colunaCategoria.setCellValueFactory(cellData -> cellData.getValue().getCategoria().getDescricaoProperty());
        colunaValor.setCellValueFactory(cellData -> cellData.getValue().getValorProperty().asObject());
    }

    public void carregarTabelaComDadosDoBanco(int mes) {
        movimentacaoDAO = new MovimentacaoDAO();
        listaDeMovimentacoes = movimentacaoDAO.filtroMes(mes);
        movimentacaoObservable = FXCollections.observableArrayList(listaDeMovimentacoes);
        tabelaMovimentacao.setItems(movimentacaoObservable);
        inicializaColunas();
    }

    @FXML
    void handleButtonExcluirMovimentacao(ActionEvent event) {
        Movimentacao movimentacao = tabelaMovimentacao.getSelectionModel().getSelectedItem();
        if (movimentacao != null) {
            movimentacaoDAO = new MovimentacaoDAO();
            movimentacaoDAO.removeMovimentacao(movimentacao);
            carregarTabelaComDadosDoBanco(LocalDate.now().getMonthValue());
            atualizaValores();
        } else {
            String titulo = "Falha na exclusão!";
            String cabecalho = "Item não excluído!";
            String mensagem = "Por favor, selecione uma movimentação"
                    + " financeira na tabela ao lado.";
            main.mostraAlerta(Alert.AlertType.WARNING, titulo, cabecalho, mensagem);
        }
        System.out.println("Excluir movimentação");
    }

    /**
     * Método evita um erro que acontece se o usuário remover uma movimentação,
     * no mês atua, sem ter clicado sobre nenhum mês no comboBoxMes.
     */
//    public void testaComboBox() {
//        if (comboBoxMes.getValue().getMonthValue() <= 11) {
//            carregarTabelaComDadosDoBanco(comboBoxMes.getValue().getMonthValue());
//        } else {
//            carregarTabelaComDadosDoBanco(LocalDate.now().getMonthValue());
//        }
//    }

    public void exibeUltimaMovimentacao() {
        int tamanho = movimentacaoObservable.size();
        labelTipo.setText(movimentacaoObservable.get(tamanho - 1).getTipo().getDescricaoTipo());
        labelUltimaMovimentacao.setText("R$= " + movimentacaoObservable.get(tamanho - 1).exibeValor());
    }

    @FXML
    void handleButtonInserirMovimentacao(ActionEvent event) {
        main.exibeTelaInsereMovimentacao();
        atualizaValores();
    }

    @FXML
    void handleComboBoxMes(ActionEvent event) {
        MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
        listaDeMovimentacoes = movimentacaoDAO.filtroMes(LocalDate.now().getMonthValue());
        carregarTabelaComDadosDoBanco(comboBoxMes.getValue().getMonthValue());

    }

    @FXML
    void handleDespesaPorCategoria(ActionEvent event) {
        main.exibeTelaGraficoDespesaPorCategoria();
        System.out.println("Abre tela de gráfico despesa x categoria");
    }

    @FXML
    void handleReceitaXdespesa(ActionEvent event) {
        main.exibeTelaGraficoReceitaXdespesa();
        System.out.println("Abre tela gráfico receita x despesa");
    }

    public void preencheComboBoxMes() {
        comboBoxMes.getItems().removeAll(comboBoxMes.getItems());
        List<LocalDate> meses = new ArrayList<LocalDate>();
        for (int mes = 1; mes <= 12; mes++) {
            meses.add(LocalDate.of(1900, mes, 1));
        }
        ObservableList<LocalDate> mesesObservable = FXCollections.observableArrayList();
        mesesObservable.addAll(meses);

        comboBoxMes.setItems(mesesObservable);
        comboBoxMes.setConverter(new StringConverter<LocalDate>() {
            @Override
            public String toString(LocalDate data) {
                return data.format(DateTimeFormatter.ofPattern("MMMM"));
            }

            @Override
            public LocalDate fromString(String numeroMes) {
                return mesesObservable.stream()
                        .filter(meses -> meses.getMonthValue() == Integer.valueOf(numeroMes))
                        .collect(Collectors.toList()).get(0);
            }
        });
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
            tipoDeMovimentacao = movimentacaoObservable.get(i).getTipo().getDescricaoTipo();
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

    public void atualizaValores() {
        calculaSaldoPrevisto();
        calculaSaldoAtual();
        exibeUltimaMovimentacao();
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stageLogin) {
        this.palco = stageLogin;
    }
    
}
