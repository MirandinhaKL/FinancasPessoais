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
    private TableColumn<Movimentacao, Long> colunaValor;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencheComboBoxMes();
        criaTabela();
        carregarTabelaComDadosDoBanco();
    }

    @FXML
    void handleButtonExcluirMovimentacao(ActionEvent event) {
        System.out.println("Excluir movimentação");
    }

    @FXML
    void handleButtonInserirMovimentacao(ActionEvent event) {
        System.out.println("Inserir movimentação");
    }

    @FXML
    void handleComboBox(ActionEvent event) {
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
