package org.example.lab6_compulsory;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class GameApplication extends Application {

    private Canvas canvas;
    private GraphicsContext gc;
    private Spinner<Integer> widthSpinner;
    private Spinner<Integer> heightSpinner;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Game Application");

        // Main frame
        BorderPane root = new BorderPane();

        // Configuration panel
        VBox configPanel = new VBox();
        configPanel.setPadding(new Insets(10));
        configPanel.setAlignment(Pos.CENTER);
        Label widthLabel = new Label("Width:");
        widthSpinner = new Spinner<>(1, 10, 6);
        widthSpinner.setEditable(false);
        Label heightLabel = new Label("Height:");
        heightSpinner = new Spinner<>(1, 10, 6);
        heightSpinner.setEditable(false);
        Button createGameButton = new Button("Create Game");
        configPanel.getChildren().addAll(widthLabel, widthSpinner, heightLabel, heightSpinner, createGameButton);
        root.setTop(configPanel);

        canvas = new Canvas(400, 400);
        gc = canvas.getGraphicsContext2D();
        root.setCenter(canvas);

        // Control panel
        HBox controlPanel = new HBox(10);
        controlPanel.setPadding(new Insets(10));
        controlPanel.setAlignment(Pos.CENTER);
        Button loadButton = new Button("Load");
        Button saveButton = new Button("Save");
        Button exitButton = new Button("Exit");
        controlPanel.getChildren().addAll(loadButton, saveButton, exitButton);
        root.setBottom(controlPanel);

        createGameButton.setOnAction(e -> {
            int width = widthSpinner.getValue();
            int height = heightSpinner.getValue();
            drawGrid(width, height);
        });
        exitButton.setOnAction(e -> primaryStage.close());

        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }

    private void drawGrid(int width, int height) {
        double canvasWidth = width * 50;
        double canvasHeight = height * 50;
        canvas.setWidth(canvasWidth);
        canvas.setHeight(canvasHeight);

        gc.clearRect(0, 0, canvasWidth, canvasHeight);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);

        double cellWidth = canvasWidth / width;
        double cellHeight = canvasHeight / height;

        for (int i = 0; i <= width; i++) {
            double x = i * cellWidth;
            gc.strokeLine(x, 0, x, canvasHeight);
        }

        for (int i = 0; i <= height ; i++) {
            double y = i * cellHeight;
            gc.strokeLine(0, y, canvasWidth, y);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
