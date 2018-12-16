package controller;

import aplicacao.Main;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import model.dao.professor.MovimentacaoDAO;
import model.property.Categoria;

/**
 * FXML Controller class
 *
 * @author kmiranda
 */
public class TelaGraficoReceitaXdespesaController implements Initializable {

    public Main main;
    public Stage palco;
    private ObservableList<String> nomesDosMeses = FXCollections.observableArrayList();
    private MovimentacaoDAO movimentacaoDAO;

    @FXML
    private BarChart<String, Double> graficoDeBarras;

    @FXML
    private CategoryAxis eixoX;

    @FXML
    private NumberAxis eixoY;

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
    void handleComboBoxAno(ActionEvent event) {
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
        configurandoEixoX();
    }

    public void configurandoEixoX() {
        String[] months = DateFormatSymbols.getInstance(Locale.getDefault()).getMonths();
        nomesDosMeses.addAll(Arrays.asList(months));
        eixoX.setCategories(nomesDosMeses);
        movimentacaoDAO = new MovimentacaoDAO();
        Map<Integer, ArrayList> dados = movimentacaoDAO.listarTiposPorMes();
        for (Map.Entry<Integer, ArrayList> dadosItem : dados.entrySet()) {
            XYChart.Series<String, Double> series = new XYChart.Series<>();
            series.setName(dadosItem.getKey().toString());
            for (int i = 1; i < dadosItem.getValue().size(); i++) {
                String mes;
                Double quantidade;
                mes = retornaNomeMes((int) dadosItem.getValue().get(i));
                quantidade = (Double) dadosItem.getValue().get(i);
                series.getData().add(new XYChart.Data<>(mes, quantidade));
            }
            graficoDeBarras.getData().add(series);
        }
    }

    public String retornaNomeMes(int mes) {
        switch (mes) {
            case 1:
                return "Jan";
            case 2:
                return "Fev";
            case 3:
                return "Mar";
            case 4:
                return "Abr";
            case 5:
                return "Mai";
            case 6:
                return "Jun";
            case 7:
                return "Jul";
            case 8:
                return "Ago";
            case 9:
                return "Set";
            case 10:
                return "Out";
            case 11:
                return "Nov";
            case 12:
                return "Dez";
            default:
                return "";
        }
    }

    public void configurandoEixoY() {
        eixoY.setLabel("Valor em R$");

    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stageLogin) {
        this.palco = stageLogin;
    }
}
