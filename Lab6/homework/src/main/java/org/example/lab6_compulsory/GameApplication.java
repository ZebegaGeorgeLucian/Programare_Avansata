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
    private Sticks sticks;
    private Nodes nodes;


    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Game Application");

        sticks = new Sticks();
        nodes = new Nodes();

        VBox root = new VBox();
        root.setAlignment(Pos.CENTER);

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

        canvas = new Canvas(400, 400);
        gc = canvas.getGraphicsContext2D();

        VBox.setMargin(canvas, new Insets(10));

        HBox controlPanel = new HBox(10);
        controlPanel.setPadding(new Insets(10));
        controlPanel.setAlignment(Pos.CENTER);
        Button loadButton = new Button("Load");
        Button saveButton = new Button("Save");
        Button exitButton = new Button("Exit");
        controlPanel.getChildren().addAll(loadButton, saveButton, exitButton);

        createGameButton.setOnAction(e -> {
            int width = widthSpinner.getValue();
            int height = heightSpinner.getValue();
            drawGrid(width, height);
        });
        exitButton.setOnAction(e -> primaryStage.close());

        root.getChildren().addAll(configPanel, canvas, controlPanel);

        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
    }

    private void drawGrid(int width, int height) {
        double padding = 20;
        double canvasWidth = width * 50 + padding * 2;
        double canvasHeight = height * 50 + padding * 2;
        canvas.setWidth(canvasWidth);
        canvas.setHeight(canvasHeight);

        gc.clearRect(0, 0, canvasWidth, canvasHeight);
        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);

        double cellWidth = (canvasWidth - padding * 2) / width;
        double cellHeight = (canvasHeight - padding * 2) / height;

        sticks.makeThickSides(width, height);

        for (ThickStick thickStick : sticks.getThickSticks()) {
            gc.setStroke(Color.BLACK);
            gc.setLineWidth(3);
            gc.strokeLine(thickStick.getX1() * cellWidth + padding, thickStick.getY1() * cellHeight + padding,
                    thickStick.getX2() * cellWidth + padding, thickStick.getY2() * cellHeight + padding);
        }

        nodes.drawNodes(sticks, gc, cellWidth, cellHeight, padding);

        gc.setStroke(Color.BLACK);
        gc.setLineWidth(1);
        for (int i = 0; i <= width; i++) {
            double x = i * cellWidth + padding;
            gc.strokeLine(x, padding, x, canvasHeight - padding);
        }

        for (int i = 0; i <= height; i++) {
            double y = i * cellHeight + padding;
            gc.strokeLine(padding, y, canvasWidth - padding, y);
        }
    }


    public static void main(String[] args) {
        launch(args);
    }
}
