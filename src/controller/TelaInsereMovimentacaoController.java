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
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;
import model.property.Categoria;
import model.property.Movimentacao;
import model.property.TipoDeMovimentacao;
import model.dao.professor.CategoriaDAO;
import model.dao.professor.MovimentacaoDAO;
import model.dao.professor.TipoDeMovimentacaoDAO;

public class TelaInsereMovimentacaoController implements Initializable {

    private Main main;
    private Stage palco;
    private String radioBtnStatus;
    private Categoria categoria;
    private CategoriaDAO categoriaDAO;
    private TipoDeMovimentacao tipoMovimentacao;
    private TipoDeMovimentacaoDAO tipoDeMovimentacaoDAO;
    private Movimentacao movimentacao;
    private MovimentacaoDAO movimentacaoDAO;
    private List<Categoria> listaCategorias;
    private List<TipoDeMovimentacao> listaTipos;
    private ObservableList<Categoria> listaCategoriasObservable;
    private ObservableList<TipoDeMovimentacao> listaTiposObservable;
    private String categoriaRetornada;
    public LocalDate dataSelecionada;
    private String statusRetornado;

    @FXML
    private TextField labelValor;

    @FXML
    private ComboBox comboBoxTipo;

    @FXML
    private ComboBox comboBoxCategoria;

    @FXML
    private DatePicker dataPicker;

    @FXML
    private RadioButton buttonRadioReceita;

    @FXML
    private ToggleGroup toggleGroupStatus;

    @FXML
    private RadioButton buttonRadioDespesa;

    @FXML
    private TextField labelDescricao;

    private TelaPrincipalController telaPrincipal;

    @FXML
    void handleButtonAdicionar(ActionEvent event) {
        categoria = (Categoria) comboBoxCategoria.getSelectionModel().getSelectedItem();
        System.out.println(categoria);
        tipoMovimentacao = (TipoDeMovimentacao) comboBoxTipo.getSelectionModel().getSelectedItem();
        System.out.println(tipoMovimentacao);
        
        categoria.exibeDadosCategoria();
        movimentacao = new Movimentacao();
        movimentacao.setIdMovimentacao(0);
        movimentacao.setValor(Double.parseDouble(labelValor.getText()));
        movimentacao.setParaOfuturo(converteComboBoxStatus());
        movimentacao.setData(dataSelecionada);
        movimentacao.setDescricao(labelDescricao.getText());
        movimentacao.setTipo(tipoMovimentacao);
        movimentacao.setCategoria(categoria);

        movimentacaoDAO = new MovimentacaoDAO();
        movimentacaoDAO.adicionaMovimentacao(movimentacao);
        main.exibeTelaPrincipal();
    }

    @FXML
    void handleButtonCancelar(ActionEvent event) {
        main.exibeTelaPrincipal();
        System.out.println("Voltar para tela principal.");
    }

    @FXML
    void handleComboBoxCategoria(ActionEvent event) {
//        categoriaDAO = new CategoriaDAO();
//        categoria = (Categoria) comboBoxCategoria.getSelectionModel().getSelectedItem();
//        categoriaDAO.adicionaCategoria(categoria);
//        System.out.println(categoria.getDescricao());
    }

    @FXML
    void handleComboBoxTipo(ActionEvent event) {
//        tipoDeMovimentacaoDAO = new TipoDeMovimentacaoDAO();
//        tipoMovimentacao = (TipoDeMovimentacao) comboBoxTipo.getSelectionModel().getSelectedItem();
//        tipoDeMovimentacaoDAO.adicionaTipoDeMovimentacao(tipoMovimentacao);
//        System.out.println(tipoMovimentacao.getDescricao());
    }

    public boolean converteComboBoxStatus() {
        if (radioBtnStatus.equalsIgnoreCase("Efetuada")) {
            return false;
        } else if (radioBtnStatus.equalsIgnoreCase("Agendada")) {
            return true;
        }
        return false;
    }

    @FXML
    void handleDataPicker(ActionEvent event) {
        dataSelecionada = dataPicker.getValue();
        System.out.println("Data selecionada =" + dataSelecionada);
    }

    @FXML
    void handleRadioGroupStatus(ActionEvent event) {
        RadioButton radioSelecionado = (RadioButton) event.getSource();
        radioBtnStatus = radioSelecionado.getText();
        System.out.println("Verificando radioButton " + radioBtnStatus);
    }

    public void preencheComboBoxCategoria() {
        comboBoxCategoria.getItems().removeAll(comboBoxCategoria.getItems());
        categoriaDAO = new CategoriaDAO();
        listaCategorias = categoriaDAO.retornaListaDeCategoriasObservable();
        listaCategoriasObservable = FXCollections.observableArrayList(listaCategorias);
        comboBoxCategoria.setItems(listaCategoriasObservable);
    }

    public void preencheComboBoxTipo() {
        comboBoxTipo.getItems().removeAll(comboBoxTipo.getValue());
        tipoDeMovimentacaoDAO = new TipoDeMovimentacaoDAO();
        listaTipos = tipoDeMovimentacaoDAO.retornaListaDosTiposDeMovimentaoesObservable();
        listaTiposObservable = FXCollections.observableArrayList(listaTipos);
        comboBoxTipo.setItems(listaTiposObservable);
    }

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        toggleGroupStatus = new ToggleGroup();
        preencheComboBoxCategoria();
        preencheComboBoxTipo();
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stage) {
        this.palco = stage;
    }

}
