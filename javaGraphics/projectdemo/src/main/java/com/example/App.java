package com.example;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    
    public void start (Stage stage){

        StackPane root = new StackPane();

        Text text = new Text("WoSchool: Student Management System");
        text.setFont(Font.font("Poppins", 32));
        text.setTranslateX(text.getTranslateX());
        text.setStyle(text.getStyle());

        Text logoText = new Text("WoSchool:");
        logoText.setFont(Font.font("Montserrat, 24"));

        root.getChildren().add(text);

        Scene scene = new Scene(root, 1440, 620);
        stage.setScene(scene);
        stage.setTitle("Good Mood!");
        stage.show();


    }
    public static void main(String[] args) {
        launch(args);
    }
}

