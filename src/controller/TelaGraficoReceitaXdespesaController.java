package controller;

import aplicacao.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author kmiranda
 */
public class TelaGraficoReceitaXdespesaController implements Initializable {

    public Main main;
    public Stage palco;

    @FXML
    private BarChart<?, ?> graficoDeBarras;

    @FXML
    private ComboBox<?> coboBoxMes;

    @FXML
    private ComboBox<?> comboBoxAno;

    @FXML
    void handleButtonGerarGrafico(ActionEvent event) {
        System.out.println("Gera o grafico");
    }

    @FXML
    void handleButtonVoltar(ActionEvent event) {
        main.exibeTelaPrincipal();
    }

    @FXML
    void handlecoboBoxAno(ActionEvent event) {
        System.out.println("carrega ano");
    }

    @FXML
    void handlecoboBoxMes(ActionEvent event) {
        System.out.println("carrega mes");
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
