package org.example.playground.playground;

import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Label;
import javafx.scene.paint.Paint;

import static java.lang.Math.*;

public class PlaygroundController {
    @FXML
    private Label startText;
    @FXML
    private Canvas canvas;

    @FXML
    protected void onStartClick() {
        startText.setText("Starting something ...");
        GraphicsContext gc = canvas.getGraphicsContext2D();
        gc.clearRect(0, 0, canvas.getWidth(), canvas.getHeight());
        gc.setLineWidth(1.0);
        drawPattern(gc, Paint.valueOf("GOLD"),false);
        gc.setLineWidth(2.0);
        drawPattern(gc, Paint.valueOf("CYAN"), true);
    }

    private void drawPattern(GraphicsContext gc, Paint paint, boolean border) {
        gc.setStroke(paint);
        double xm = canvas.getWidth() / 2;
        double ym = canvas.getHeight() / 2;
        double x1 = xm;
        double y1 = ym;
        for (double i = 0; i < 2 * PI; i+=0.001) {
            double f = abs(sin(2 * i));
            double x2 = xm + (350 * f * sin(i));
            double y2 = ym + (350 * f * cos(i));
            gc.strokeLine(x1, y1, x2, y2);
            if (border) {
                x1 = x2;
                y1 = y2;
            }
        }
    }
}