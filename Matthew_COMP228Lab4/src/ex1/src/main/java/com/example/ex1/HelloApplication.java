package com.example.ex1;
// Matthew Elliott - 301424215
// November 12, 2025
// COMP228 Lab 4

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.scene.image.Image;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        // Setting up the scene
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        GridPane root = fxmlLoader.load();
        Scene scene = new Scene(root, 960, 600);

        stage.setTitle("Matthew Elliott - Lab 4");
        stage.setScene(scene);
        stage.show();

        // Adding the JavaFX Logo image
        Image icon = new Image("https://upload.wikimedia.org/wikipedia/en/c/cc/JavaFX_Logo.png");
        stage.getIcons().add(icon);

    }

    public static void main(String[] args) {
        launch();
    }

}
