package com.example;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Pair;
import javafx.util.StringConverter;

public class AdminPanel {

    private final static ChoiceBox <Pair<String, String>> option = new ChoiceBox<>();
    private final static Pair<String, String> EMPTY_PAIR = new Pair<>("", "");

    public static void start (Stage stage){
        Label label = new Label("Select Option: ");
        option.setPrefWidth(200);
        
        // Create a save Button
        Button button = new Button("Continue");
        
        HBox hbox = new HBox(
            label,
            option,
            button
        );
        hbox.setSpacing(10.0d);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(40));

        Scene scene = new Scene(hbox);

        initChoice();

        button.setOnAction( (evt) -> System.out.println("Procesing" + option.getValue()));

        stage.setTitle("Choice Module");
        stage.setScene(scene);
        stage.show();

    }

    public static void initChoice(){
        List<Pair <String, String>> list = new ArrayList<>();
        list.add(new Pair<String,String>("1", "Add Student"));
        list.add(new Pair<String,String>("2", "Update Student Record"));
        list.add(new Pair<String,String>("3", "All Available Students"));
        list.add(new Pair<String,String>("4", "Exit"));

        option.setConverter(new StringConverter<Pair<String,String>>() {

            @Override
            public String toString(Pair<String, String> pair){
                return pair.getValue();
            }

            @Override
            public Pair<String, String> fromString(String arg0) {
                return null;
            }
        });

        option.getItems().add(EMPTY_PAIR);
        option.getItems().addAll(list);
        // option.getKey(EMPTY_PAIR);

    }

    // public static void main(String[] args) {
    //     launch(args);
    // }
    
}
