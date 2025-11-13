package com.example;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class ContadorFXApp extends Application {

    private int contador;
    private Button botaoClique;
    private Label labelContador;

    @Override
    public void start(Stage primaryStage) {

        contador = 0;
        botaoClique = new Button("Clique em mim!");
        labelContador = new Label("Contador: " + contador);

        botaoClique.setOnAction(event -> {
            contador++;
            labelContador.setText("Contador: " + contador);
        });

        VBox root = new VBox(20); // Aumentado o espaçamento
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