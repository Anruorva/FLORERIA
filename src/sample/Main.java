package sample;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("FXMLs/sample.fxml"));
        primaryStage.setTitle("FLORERIA");
        primaryStage.setScene(new Scene(root, 1000, 600));
        primaryStage.show();
        primaryStage.setFullScreen(true);


    }


    public static void main(String[] args) {
        launch(args);

    }
}
