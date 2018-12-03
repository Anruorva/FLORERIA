package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import java.net.URL;
import java.util.ResourceBundle;

//import static sample.Controllers.ControllerMedio.tbl;

public class ControllerBajo implements Initializable {
    @FXML
    JFXButton btnAgregarCarrito;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        btnAgregarCarrito.setOnAction(handler);
    }
    EventHandler<ActionEvent> handler = new EventHandler<ActionEvent>() {
        @Override
        public void handle(ActionEvent event) {
            if(event.getSource() == btnAgregarCarrito){
                //tbl.setItems(null);
            }
        }
    };
}
