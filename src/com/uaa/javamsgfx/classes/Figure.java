package com.uaa.javamsgfx.classes;


import com.uaa.javamsgfx.interfaces.Drawable;
import com.uaa.javamsgfx.interfaces.Printable;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

import java.io.Serializable;

public class Figure implements Drawable, Printable,Serializable {
    private double lineWidth;
  //  private transient Color color;
    private double area;
    private double x;
    private double y;
   // private ColorStruct cs;
    public double red;
    public double green;
    public double blue;


    public Figure(double lineWidth,  double area, double x, double y,double red, double green, double blue) {
        this.lineWidth = lineWidth;
      //  this.color = initColor(red, green, blue);
        this.area = area;
        this.x = x;
        this.y = y;
        this.red = red;
        this.green = green;
        this.blue = blue;


    }


    /*public Figure(double lineWidth, Color color, double area, double x, double y) {
        this.lineWidth = lineWidth;
        this.color = color;
        this.area = area;
        this.x = x;
        this.y = y;
    }*/
    public Color initColor(double red, double green, double blue){
        return Color.color( red,  green,  blue);
    }

/*
    @Override
    public String getInfo() {
        final StringBuffer sb = new StringBuffer("Figure{");
        sb.append("lineWidth=").append(lineWidth);
        sb.append(", color=").append(color);
        sb.append(", area=").append(area);
        sb.append(", x=").append(x);
        sb.append(", y=").append(y);
        sb.append('}');
        return sb.toString();
    }*/

    @Override
    public String getInfo() {
        final StringBuffer sb = new StringBuffer("Figure{");
        sb.append("lineWidth=").append(lineWidth);

        sb.append(", area=").append(area);
        sb.append(", x=").append(x);
        sb.append(", y=").append(y);

        sb.append(", red=").append(red);
        sb.append(", green=").append(green);
        sb.append(", blue=").append(blue);
        sb.append('}');
        return sb.toString();
    }

    public double getLineWidth() {
        return lineWidth;
    }

    public void setLineWidth(double lineWidth) {
        this.lineWidth = lineWidth;
    }

    public Color getColor() {
        return Color.color(red,green, blue);
    }



    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public void draw(GraphicsContext g) {

    }

}
