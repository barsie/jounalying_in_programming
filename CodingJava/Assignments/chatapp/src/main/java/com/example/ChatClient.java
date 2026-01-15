package com.example;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

import java.io.*;
import java.net.Socket;

public class ChatClient extends Application {

    private TextArea messageArea;
    private TextField inputField;
    private PrintWriter out;
    private Socket socket;

    @Override
    public void start(Stage primaryStage) {
        // UI Components
        messageArea = new TextArea();
        messageArea.setEditable(false);

        inputField = new TextField();
        inputField.setPromptText("Enter your message...");
        inputField.setOnAction(e -> sendMessage());

        Button sendButton = new Button(" Send ");
        sendButton.setOnAction(e -> sendMessage());

        HBox inputBox = new HBox(10, inputField, sendButton);
        inputBox.setHgrow(inputField, Priority.ALWAYS);

        VBox root = new VBox(10, messageArea, inputBox);
        Scene scene = new Scene(root, 500, 400);

        primaryStage.setTitle("UoPeople ChatApp");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Connect to the server
        new Thread(this::connectToServer).start();
    }

    private void connectToServer() {
        try {
            socket = new Socket("localhost", 12345); // Connect to server
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(), true);

            // Read from server in background
            String message;
            while ((message = in.readLine()) != null) {
                String finalMessage = message;
                Platform.runLater(() -> messageArea.appendText(finalMessage + "\n"));
            }
        } catch (IOException e) {
            Platform.runLater(() -> messageArea.appendText("Connection lost.\n"));
        }
    }

    private void sendMessage() {
        String message = inputField.getText().trim();
        if (!message.isEmpty()) {
            out.println(message);
            inputField.clear();
        }
    }

    @Override
    public void stop() throws Exception {
        super.stop();
        if (socket != null && !socket.isClosed()) {
            socket.close();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

