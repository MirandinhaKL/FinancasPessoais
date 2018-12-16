package aplicacao;

import controller.RootController;
import controller.TelaDeLoginController;
import controller.TelaGraficoDespesaPorCategoriaController;
import controller.TelaGraficoReceitaXdespesaController;
import controller.TelaInsereMovimentacaoController;
import controller.TelaPrincipalController;
import java.awt.Panel;
import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 *
 * @author Mirandinha
 */
public class Main extends Application {

    private BorderPane root;
    private Stage primeiraCena;
    private TelaPrincipalController principalController;

    @Override
    public void start(Stage primaryStage) {
        this.primeiraCena = primaryStage;
        this.primeiraCena.setTitle("Gerenciador de Finanças Pessoais");
        iniciaRootLayout();
        exibeTelaDeLogin();
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

    public void exibeTelaDeLogin() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/TelaDeLogin.fxml"));
            AnchorPane telaLogin = (AnchorPane) loader.load();
            root.setCenter(telaLogin);
            TelaDeLoginController controller = loader.getController();
            controller.setMain(this);
        } catch (IOException excecao) {
            System.out.println(excecao.getMessage());
            excecao.printStackTrace();
        }
    }

    public void exibeTelaPrincipal() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/TelaPrincipal.fxml"));
            AnchorPane telaPrincipal = (AnchorPane) loader.load();
            root.setCenter(telaPrincipal);
            principalController = loader.getController();
            principalController.setMain(this);
        } catch (IOException excecao) {
            System.out.println(excecao.getMessage());
            excecao.printStackTrace();
        }
    }

    public void exibeTelaInsereMovimentacao() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/TelaInsereMovimentacao.fxml"));
            AnchorPane telaInsereMovimentacao = (AnchorPane) loader.load();
            root.setCenter(telaInsereMovimentacao);
            TelaInsereMovimentacaoController controlador = loader.getController();
            controlador.setMain(this);
        } catch (IOException excecao) {
            System.out.println(excecao.getMessage());
            excecao.printStackTrace();
        }
    }

    public void exibeTelaGraficoReceitaXdespesa() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/TelaGraficoReceitaXdespesa.fxml"));
            AnchorPane telaReceitaDespesa = (AnchorPane) loader.load();
            root.setCenter(telaReceitaDespesa);
            TelaGraficoReceitaXdespesaController controlador = loader.getController();
            controlador.setMain(this);
        } catch (IOException excecao) {
            System.out.println(excecao.getMessage());
            excecao.printStackTrace();
        }
    }

    public void exibeTelaGraficoDespesaPorCategoria() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/view/TelaGraficoDespesaPorCategoria.fxml"));
            AnchorPane telaDespesa = (AnchorPane) loader.load();
            root.setCenter(telaDespesa);
            TelaGraficoDespesaPorCategoriaController controlador = loader.getController();
            controlador.setMain(this);
        } catch (IOException excecao) {
            System.out.println(excecao.getMessage());
            excecao.printStackTrace();
        }
    }

    public void mostraAlerta(Alert.AlertType tipoDeAlerta, String titulo, String cabecalho, String mensagem) {
        Alert alerta = new Alert(tipoDeAlerta);
        alerta.initOwner(this.getPrimeiraCena());
        alerta.setTitle(titulo);
        alerta.setHeaderText(cabecalho);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }

    public Stage getPrimeiraCena() {
        return this.primeiraCena;
    }
    
    public TelaPrincipalController getTelaPrincipal(){
        return this.principalController;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
