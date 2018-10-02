package com.uaa.javamsgfx.controller;

import com.uaa.javamsgfx.classes.*;
import com.uaa.javamsgfx.comparators.FigureAreaComparator;
import com.uaa.javamsgfx.interfaces.Drawable;
import com.uaa.javamsgfx.interfaces.Printable;
import javafx.application.Platform;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.*;

import javafx.scene.image.WritableImage;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.input.ScrollEvent;
import javafx.scene.paint.Color;


import javax.imageio.ImageIO;
import java.awt.image.RenderedImage;
import java.io.*;
import java.net.URL;

import java.util.*;

public class MainScreenController implements Initializable {
    @FXML
    private Label lblGrad;
    @FXML
    private Slider gradSlider;
    @FXML
    private Label lblSize;
    @FXML
    private Slider sizeSlider;
    @FXML
    private Button btnClear;

    @FXML
    private ToggleGroup grpFigur;
    @FXML
    private RadioButton rbOval;
    @FXML
    private RadioButton rbTriangle;
    @FXML
    private RadioButton rbSquare;
    @FXML
    private Canvas drawCanvas;
    @FXML
    private ColorPicker clrPicker;

    //-------------------------**********

    //-------------------------**************************************строка ниже
    private Logger logger;

    public ColorPicker getClrPicker() {
        return clrPicker;
    }

    private String param = "my_save.dat";
    FigureAreaComparator fac = new FigureAreaComparator();
    List<Figure> drwList = new LinkedList<>();
    GraphicsContext gc, gc2;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        clrPicker.setValue(Color.BLACK);
        //-------------------------**************************************строка ниже
        logger = new Logger();
        if (new File(param).exists()) {
            drwList = (List<Figure>) logger.deserialize(param);
            gc = drawCanvas.getGraphicsContext2D();
            repaint();
        } else {
            gc = drawCanvas.getGraphicsContext2D();
            return;
        }
       /* Thread thread = new Thread(() -> {
            try {
                Thread.sleep(3000L);
                System.out.println("lkashjdflajkshdf");
                Platform.runLater(() -> {
                    drawCanvas.getGraphicsContext2D().setLineWidth(2.0);
                    drawCanvas.getGraphicsContext2D().setStroke(Color.RED);
                    drawCanvas.getGraphicsContext2D().strokeOval(100.0, 100.0, 100.0, 100.0);
                });

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        thread.start();*/

    }

    double red = 0;
    double green = 0;
    double blue = 0;


    public void clickListener(MouseEvent e) {
        double x = e.getX();
        double y = e.getY();
        double sizeValue = Math.round(sizeSlider.getValue());

        red = clrPicker.getValue().getRed();
        green = clrPicker.getValue().getGreen();
        blue = clrPicker.getValue().getBlue();

        if (rbOval.isSelected()) {

        // public Oval(double lineWidth, double area, double x, double y, double red, double green, double blue, double radius) {
            Oval oval = new Oval(2.0, getAreaOval(sizeValue), x, y, red, green, blue, sizeValue);
            drwList.add(oval);
            //-------------------------**************************************строка ниже
            logger.log2(oval);
        }
        //public Triangle(double lineWidth, double area, double x, double y, double red, double green, double blue, double storona) {
        else if (rbTriangle.isSelected()) {
            Triangle triangle = new Triangle(2.0, getAreaTriangle(sizeValue), x, y, red, green, blue, sizeValue);
            drwList.add(triangle);
            //-------------------------**************************************строка ниже
            logger.log2(triangle);
        } else {
            // public SquareFromLine(double lineWidth, double area, double x, double y, double red, double green, double blue, double storona, double rotate) {
            SquareFromLine squareFromLine = new SquareFromLine(2.0, getAreaSquare(sizeValue), x, y, red, green, blue, sizeValue, Math.round(gradSlider.getValue()));
            drwList.add(squareFromLine);
            //-------------------------**************************************строка ниже
            logger.log2(squareFromLine);
        }


        gc.clearRect(0, 0, 1014, 550);
        repaint();
        print();
        //log();
        // new Logger().log(drwList);


    }


    private void saveToPNG() {
        File f = new File("image.png");
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            WritableImage wi = new WritableImage((int) drawCanvas.getWidth(), (int) drawCanvas.getHeight());
            drawCanvas.snapshot(null, wi);
            RenderedImage ri = SwingFXUtils.fromFXImage(wi, null);
            ImageIO.write(ri, "png", f);
            System.out.println("сохранено успешно");

        } catch (IOException e) {
            e.printStackTrace();
            f.delete();
            return;
        }
    }

    private double getAreaTriangle(double param) {
        double p = (param * 3 / 2);
        return Math.round(Math.sqrt(p * (p - param) * (p - param) * (p - param)));
    }

    private double getAreaSquare(double param) {
        return Math.round(param * param);
    }

    private double getAreaOval(double param) {
        return Math.round(Math.PI * (param / 2 * param / 2));
    }

    private void repaint() {
        for (Drawable drw : drwList) {
            drw.draw(gc);
        }
    }

    private void print() {
        List<Figure> sortList = drwList;
        sortList.sort(fac);
        for (Printable drw : sortList) {
            System.out.println(drw.getInfo());
        }
    }

    public void clearAction(ActionEvent actionEvent) {
        gc.clearRect(0, 0, 1014, 550);
        drwList.clear();
    }


    public void viewFigureFromMouse(MouseEvent mouseEvent) {

        double x = mouseEvent.getX();
        double y = mouseEvent.getY();
        double param = Math.round(sizeSlider.getValue());
        gc2 = drawCanvas.getGraphicsContext2D();
        double sizeValue = Math.round(sizeSlider.getValue());

        if (mouseEvent.isAltDown()) {

            gc2.clearRect(0, 0, 1014, 550);

            if (rbOval.isSelected()) {
                // (new Oval(2.0, clrPicker.getValue(), x, y, param, getAreaOval(param))).draw(gc2);
                      new Oval(2.0, getAreaOval(sizeValue), x, y, red, green, blue, sizeValue).draw(gc2);
            }

           else if (rbTriangle.isSelected()) {
                new Triangle(2.0, getAreaTriangle(sizeValue), x, y, red, green, blue, sizeValue).draw(gc2);
            } else {
                new SquareFromLine(2.0, getAreaSquare(sizeValue), x, y, red, green, blue, sizeValue, Math.round(gradSlider.getValue())).draw(gc2);
            }


            repaint();

        }
        if (!mouseEvent.isAltDown()) {

            gc2.clearRect(0, 0, 1014, 550);
            repaint();
        }
    }

    public void altKeyPress(KeyEvent keyEvent) {

        if (keyEvent.isAltDown()) {

        }

    }

    public void scrollSizeChange(ScrollEvent scrollEvent) {
        if (scrollEvent.isControlDown()) {
            sizeSlider.setValue(sizeSlider.getValue() + Math.round(scrollEvent.getDeltaY() / 8));
            lblSize.setText("" + Math.round(sizeSlider.getValue()));
        }
        if (scrollEvent.isAltDown()) {
            gradSlider.setValue(gradSlider.getValue() + Math.round(scrollEvent.getDeltaY() / 8));
            lblGrad.setText("" + Math.round(gradSlider.getValue()));
        }
    }

    public void lblGradChange(MouseEvent mouseEvent) {
        lblGrad.setText("" + Math.round(gradSlider.getValue()));

    }

    public void lblSizeChange(MouseEvent mouseEvent) {
        lblSize.setText("" + Math.round(sizeSlider.getValue()));

    }

    @FXML
    private void keyListenerCtrlZ(KeyEvent keyEvent) {
        if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.Z) {
            if (drwList.size() - 1 >= 0) {
                drwList.remove(drwList.size() - 1);
                gc2.clearRect(0, 0, 1014, 550);
                repaint();
                System.out.println("удалено: " + drwList.size() + " - ");
            }
        }
        if (keyEvent.isControlDown() && keyEvent.getCode() == KeyCode.S) {
            saveToPNG();

        }

    }

    public void saveListener(ActionEvent actionEvent) {
        logger.serialize(drwList, param);

    }
}
