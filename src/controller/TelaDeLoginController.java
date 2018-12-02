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
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Mirandinha
 */
public class TelaDeLoginController implements Initializable {

    private Main main;
    private Stage palco;

    @FXML
    private PasswordField lblSenha;

    @FXML
    private Button btnOK;

    @FXML
    private TextField lblLogin;

    @FXML
    void handleButtonOK(ActionEvent event) {
        main.exibeTelaPrincipal();
        System.out.println("A página principal deve ser carregada.");
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

    public void setStage(Stage stageLogin) {
        this.palco = stageLogin;
    }
}
