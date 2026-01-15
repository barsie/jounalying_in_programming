package com.example;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.collections.*;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;

public class App extends Application {

    // FXCollections
    private ObservableList<StudentProfile> studentList = FXCollections.observableArrayList();
    private TableView<StudentProfile> studentTable = new TableView<>();
    private Image logo = new Image("https://my.uopeople.edu/pluginfile.php/1/core_admin/logocompact/300x300/1746179523/logo-1-e1656937640591.png");
    
    @Override // Polimorphism 
    public void start(Stage stage) {
        
        stage.setTitle("Student Management System");

        // Display the logo at the top
        javafx.scene.image.ImageView logoView = new javafx.scene.image.ImageView(logo);
        logoView.setFitHeight(60);
        logoView.setPreserveRatio(true);

        // Try to center the logo
        HBox HlogBox = new HBox(logoView); // Create a horizontal box to hold the logo
        HlogBox.setAlignment(Pos.CENTER);

        TabPane tabPane = new TabPane(); // Create a TabPane to hold the tabs
        tabPane.getTabs().add(createAddStudentTab());
        tabPane.getTabs().add(createViewStudentTab());

        VBox root = new VBox(logoView, tabPane); // Use VBox to stack the logo and tab pane vertically


        Scene scene = new Scene(root, 600, 400); // Create a 600x400 scene with the root node
        scene.setFill(Color.BLACK);
        stage.setScene(scene);
        stage.show();
    }

    private Tab createAddStudentTab() {
        Tab tab = new Tab("Create a new Student Profile");
        tab.setClosable(false);

        // Create a form for adding a student
        GridPane form = new GridPane(); // Using GridPane for layout
        form.setHgap(15);
        form.setVgap(15);
        form.setPadding(new Insets(20));

        // Create form fields
        TextField idField = new TextField();
        TextField nameField = new TextField();
        Button addButton = new Button("Register Student");

        form.add(new Label("ID:"), 0, 0);
        form.add(idField, 1, 0);
        form.add(new Label("Name:"), 0, 1);
        form.add(nameField, 1, 1);
        form.add(addButton, 1, 3);

        // Add action to the button: Register Student
        addButton.setOnAction(e -> {
            if (idField.getText().isEmpty() || nameField.getText().isEmpty()) {
                showAlert("You did not add all the Fields. Try again!");
            } else {
                studentList.add(new StudentProfile(idField.getText(), nameField.getText()));
                idField.clear(); 
                nameField.clear();
                showAlert("Student Enrolled successfully!");
            }
        });

        tab.setContent(form);
        return tab;
    }

    private Tab createViewStudentTab() {
        Tab tab = new Tab("View Students"); // Create a new tab for viewing students
        // Set up the table to display students
        tab.setClosable(false);

        // Create a table to display students
        TableColumn<StudentProfile, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStudentId()));

        // Create a column for student names
        TableColumn<StudentProfile, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(data -> new javafx.beans.property.SimpleStringProperty(data.getValue().getStudentName()));

        // Set up the table view
        studentTable.getColumns().addAll(idCol, nameCol);
        studentTable.setItems(studentList);

        tab.setContent(new VBox(studentTable));
        return tab;
    }

    // Method to show an alert dialog when an action is performed
    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Info");
        alert.setContentText(message);
        alert.showAndWait();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
