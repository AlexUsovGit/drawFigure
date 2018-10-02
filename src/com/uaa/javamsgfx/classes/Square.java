package com.uaa.javamsgfx.classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Square extends Figure {

    private double storona;

    public Square(double lineWidth, double area, double x, double y, double red, double green, double blue) {
        super(lineWidth, area, x, y, red, green, blue);
    }

    public Square(double lineWidth, double area, double x, double y, double red, double green, double blue, double storona) {
        super(lineWidth, area, x, y, red, green, blue);
        this.storona = storona;
    }

    @Override
    public String getInfo() {
        final StringBuffer sb = new StringBuffer("Square{");
        sb.append("\t").append(super.getInfo()).append("\t");
        sb.append("storona=").append(storona);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void draw(GraphicsContext g) {
        g.setStroke(super.getColor());
        g.setLineWidth(2);
        g.strokeRect(super.getX() - this.storona / 2, super.getY() - this.storona / 2, this.storona, this.storona);
    }
    public double getArea(double param){
        param = this.storona;
        return param*param;
    }

     public double getStorona() {
        return storona;
    }

    public void setStorona(double storona) {
        this.storona = storona;
    }



}
