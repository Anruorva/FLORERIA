package sample.Controllers;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerDerecho implements Initializable{
    @FXML
    JFXButton btnEliminar;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        colocarImagenesBotones();
        btnEliminar.setDisable(false);

    }
    private void colocarImagenesBotones(){
       /* Image image = new Image("C:\\Users\\Inspiron 11\\IdeaProjects\\FLORERIA\\out\\production\\FLORERIA\\images\\eliminar.png");
        btnEliminar.setGraphic(new ImageView(image));*/
        URL link = getClass().getResource("/images/eliminar.png");
        Image image = new Image(link.toString(),35,20,false,true);
        btnEliminar.setGraphic(new ImageView(image));

    }
}
