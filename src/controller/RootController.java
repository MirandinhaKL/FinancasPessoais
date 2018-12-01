package controller;

import aplicacao.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import javafx.stage.Stage;

public class RootController implements Initializable {

    private Main main;
    private Stage palco;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setStage(Stage stageLogin) {
        this.palco = stageLogin;
    }

}
