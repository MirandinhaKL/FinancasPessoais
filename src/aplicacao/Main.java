/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacao;

import controller.RootController;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Mirandinha
 */
public class Main extends Application {
    
    private BorderPane root;
    private Stage primeiraCena;
    //private PrincipalController principalController;
    
    @Override
    public void start(Stage primaryStage) {
        this.primeiraCena = primaryStage;
        this.primeiraCena.setTitle("Gerenciador de Finanças Pessoais");
        iniciaRootLayout();
    }
    
    public void iniciaRootLayout() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/Root.fxml"));
            root = (BorderPane) loader.load();
            RootController controlador = loader.getController();
            controlador.setMain(this);
            Scene scene = new Scene(root);
            primeiraCena.setScene(scene);
            primeiraCena.setResizable(false);
            primeiraCena.show();
        } catch (IOException excecao) {
            System.out.println(excecao.getMessage());
            excecao.printStackTrace();
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
