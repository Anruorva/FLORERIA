package sample.Controllers;

import com.jfoenix.controls.JFXRadioButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ToggleGroup;

import java.net.URL;
import java.util.ResourceBundle;

public class ControlerBajoDerecho implements Initializable{
    @FXML
    JFXRadioButton radioButtonEfectivo;
    @FXML
    JFXRadioButton radioButtonTarjeta;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        ToggleGroup group = new ToggleGroup();
        radioButtonEfectivo.setToggleGroup(group);
        radioButtonTarjeta.setToggleGroup(group);
    }
}
