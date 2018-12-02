/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import aplicacao.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;


public class TelaInsereMovimentacaoController implements Initializable {
    
    private Main main;
    private Stage palco;
    @FXML
    private TextField labelValor;

    @FXML
    private ComboBox<?> comboBoxStatusMovimentacao;

    @FXML
    private ComboBox<?> comboBoxCategoria;

    @FXML
    private DatePicker dataPicker;

    @FXML
    private RadioButton buttonRadioReceita;

    @FXML
    private ToggleGroup toggleGroupTipo;

    @FXML
    private RadioButton buttonRadioDespesa;

    @FXML
    private TextField labelDescricao;

    @FXML
    void handleButtonAdicionar(ActionEvent event) {
        System.out.println("Adicionar evento clicado.");
    }

    @FXML
    void handleButtonCancelar(ActionEvent event) {
        System.out.println("Voltar para tela principal.");
    }

    @FXML
    void handleComboBoxCategoria(ActionEvent event) {
        System.out.println("Selecionar Categoria");
    }

    @FXML
    void handleComboBoxStatusMovimentacao(ActionEvent event) {
        System.out.println("Status da movimentação");
    }

    @FXML
    void handleDataPicker(ActionEvent event) {
        System.out.println("Data selecionada");
    }

    @FXML
    void handleRadioGroupTipo(ActionEvent event) {
        System.out.println("Botoes radio.");
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stage) {
        this.palco = stage;
    }
    
}
