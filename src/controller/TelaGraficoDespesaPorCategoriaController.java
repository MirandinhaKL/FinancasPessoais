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
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import model.dao.professor.MovimentacaoDAO;
import model.property.Movimentacao;

public class TelaGraficoDespesaPorCategoriaController implements Initializable {

    private Main main;
    private Stage palco;
    private TelaPrincipalController telaPrincipal;
    private MovimentacaoDAO movimentacaoDAO;
    private List<Movimentacao> listaDeAno = new ArrayList<>();
    private ObservableList<Movimentacao> listaDeMovimentacao;
    private ObservableList<Movimentacao> listaDeCategoriasPorMes;
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

//    @FXML
//    void handleButtonGerarGrafico(ActionEvent event) {
//        MovimentacaoDAO movimentacaoDAO = new MovimentacaoDAO();
//        movimentacaoDAO.retornaDespesaMensalPorCategoria(mesSelecionado);
//        System.out.println( this.movimentacaoDAO.retornaDespesaMensalPorCategoria(mesSelecionado));
////        listaDeCategoriasPorMes = movimentacaoDAO.retornaDespesaMensalPorCategoria(mesSelecionado);
//    }

    @FXML
    void handleButtonVoltar(ActionEvent event) {
        main.exibeTelaPrincipal();
    }

    @FXML
    void handleComboBoxAno(ActionEvent event) {

    }

    @FXML
    void handleComboBoxMes(ActionEvent event) {
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

//    public void preencheComboBoxAno() {
//        comboBoxAno.getItems().removeAll(comboBoxAno.getItems());
//        movimentacaoDAO = new MovimentacaoDAO();
//        listaDeAno = movimentacaoDAO.retornaListaDeAnos();
//        listaDeAnoObservable = FXCollections.observableArrayList(listaDeAno);
//        comboBoxAno.setItems(listaDeAnoObservable);
//    }
    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stageLogin) {
        this.palco = stageLogin;
    }
}
