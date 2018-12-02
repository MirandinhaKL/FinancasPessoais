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
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.stage.Stage;

public class TelaPrincipalController implements Initializable {

    private Main main;
    private Stage palco;
    
    
    @FXML
    private Label labelSaldoAtual;

    @FXML
    private Label labelSaldoPrevisto;

    @FXML
    private Label labelTipo;

    @FXML
    private Label labelUltimaMovimentacao;

    @FXML
    private ComboBox<?> comboBoxMes;

    @FXML
    private TableColumn<?, ?> colunaData;

    @FXML
    private TableColumn<?, ?> colunaTipo;

    @FXML
    private TableColumn<?, ?> colunaCategoria;

    @FXML
    private TableColumn<?, ?> colunaValor;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
     public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stageLogin) {
        this.palco = stageLogin;
    }
}
