package com.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContadorFXApp extends Application {

    private int contador = 0;

    @Override
    public void start(Stage primaryStage) {
        Button botaoClique = new Button("Clique em mim!");
        Label labelContador = new Label("Contador: " + contador);

        botaoClique.setOnAction(event -> {
            contador++;
            labelContador.setText("Contador: " + contador);
        });

        VBox root = new VBox(20);
        root.getStyleClass().add("root");
        root.setAlignment(Pos.CENTER);
        root.getChildren().addAll(labelContador, botaoClique);

        Scene scene = new Scene(root, 350, 200);
        scene.getStylesheets().add(getClass().getResource("/com/example/styles.css").toExternalForm());

        primaryStage.setTitle("Contador Moderno");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}