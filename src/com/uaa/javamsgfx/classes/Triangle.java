package com.uaa.javamsgfx.classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Triangle extends Figure {
    private double storona;

    public Triangle(double lineWidth, double area, double x, double y, double red, double green, double blue) {
        super(lineWidth, area, x, y, red, green, blue);
    }

    public Triangle(double lineWidth, double area, double x, double y, double red, double green, double blue, double storona) {
        super(lineWidth, area, x, y, red, green, blue);
        this.storona = storona;
    }

    @Override
    public String getInfo() {
        final StringBuffer sb = new StringBuffer("Triangle{");
        sb.append("\t").append(super.getInfo()).append("\t");
        sb.append("storona=").append(storona);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void draw(GraphicsContext g) {
        g.setStroke(super.getColor());
        g.setLineWidth(2);
        g.strokePolygon(new double[]{super.getX(), super.getX() + this.storona / 2, super.getX() - this.storona / 2},
                new double[]{super.getY() - this.storona / 2, super.getY() + this.storona / 2, super.getY() + this.storona / 2}, 3);
    }
    public double getArea(double param){
        param = this.storona;
        double p = (param*3/2);
        return Math.sqrt(p*(p-param)*(p-param)*(p-param));
    }

    public double getStorona() {
        return storona;
    }

    public void setStorona(double storona) {
        this.storona = storona;
    }
}
