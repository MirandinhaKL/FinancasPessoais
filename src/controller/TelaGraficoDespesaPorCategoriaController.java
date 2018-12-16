package controller;

import aplicacao.Main;
import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import model.dao.professor.MovimentacaoDAO;
import model.property.Movimentacao;
import model.property.ResultadoCategoriaMes;

public class TelaGraficoDespesaPorCategoriaController implements Initializable {

    private Main main;
    private Stage palco;
    private TelaPrincipalController telaPrincipal;
    private MovimentacaoDAO movimentacaoDAO;
    private List<Movimentacao> listaDeAno = new ArrayList<>();
    private ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
    private ObservableList<ResultadoCategoriaMes> listaDeCategoriasPorMes;
    private ObservableList<Movimentacao> listaDeMovimentacao;
    private int mesSelecionado;
    private double somatorio;

    @FXML
    private PieChart pieChart;

    @FXML
    private ComboBox<LocalDate> comboBoxMes;

    @FXML
    private ComboBox comboBoxAno;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        preencheComboBoxMes();
//        preencheComboBoxAno();
    }

    @FXML
    void handleButtonGerarGrafico(ActionEvent event) {
        MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
        pieChart.getData().addAll(movimentacaoDAO.retornaDespesaMensalPorCategoria(mesSelecionado));
        pieChart.setVisible(true);
    }

    @FXML
    void handleButtonVoltar(ActionEvent event) {
        main.exibeTelaPrincipal();
    }

    @FXML
    void handleComboBoxAno(ActionEvent event) {
        System.out.println("teste");
    }

    @FXML
    void handleComboBoxMes(ActionEvent event
    ) {
        MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
        listaDeMovimentacao = movimentacaoDAO.filtroMes(LocalDate.now().getMonthValue());
        mesSelecionado = comboBoxMes.getValue().getMonthValue();
        System.out.println(comboBoxMes.getValue().getMonthValue());
    }

    public void preencheComboBoxMes() {
        // this.main.getTelaPrincipal().preencheComboBoxMes();
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

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stageLogin) {
        this.palco = stageLogin;
    }
}
