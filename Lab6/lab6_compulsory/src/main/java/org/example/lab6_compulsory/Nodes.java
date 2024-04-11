package org.example.lab6_compulsory;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.ArrayList;
import java.util.List;

public class Nodes {
    private List<Circle> circles;

    public Nodes() {
        this.circles = new ArrayList<>();
    }

    public void drawNodes(Sticks sticks, GraphicsContext gc, double cellWidth, double cellHeight, double padding) {
        circles.clear();

        for (ThickStick thickStick : sticks.getThickSticks()) {
            double x1 = thickStick.getX1() * cellWidth + padding;
            double y1 = thickStick.getY1() * cellHeight + padding;
            double x2 = thickStick.getX2() * cellWidth + padding;
            double y2 = thickStick.getY2() * cellHeight + padding;

            drawCircle(gc, x1, y1, cellWidth, cellHeight);
            drawCircle(gc, x2, y2, cellWidth, cellHeight);
        }
    }

    private void drawCircle(GraphicsContext gc, double x, double y, double cellWidth, double cellHeight) {
        boolean circleExists = false;
        for (Circle circle : circles) {
            if (Math.abs(circle.getCenterX() - x) < 1 && Math.abs(circle.getCenterY() - y) < 1) {
                circleExists = true;
                break;
            }
        }
        if (!circleExists) {
            double radius = Math.min(cellWidth, cellHeight) / 5;
            gc.setLineWidth(1);
            gc.strokeOval(x - radius, y - radius, radius * 2, radius * 2);
            circles.add(new Circle(x, y, radius));
        }
    }

    public void changeCircleColor(double x, double y, Color color) {
        for (Circle circle : circles) {
            if (Math.abs(circle.getCenterX() - x) < 1 && Math.abs(circle.getCenterY() - y) < 1) {
                circle.setFill(color);
                break;
            }
        }
    }
}


