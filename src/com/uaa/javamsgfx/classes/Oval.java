package com.uaa.javamsgfx.classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class Oval extends Figure {

    private double radius;

  /*  public Oval(double lineWidth, Color color, double area, double x, double y) {
        super(lineWidth, color, area, x, y);
    }

    //      Oval oval = new Oval(2.0, clrPicker.getValue(), x, y, param, getAreaOval(param));
    public Oval(double lineWidth, Color color, double x, double y, double radius, double area) {
        super(lineWidth, color, area, x,y);
        this.radius = radius;
    }*/

    public Oval(double lineWidth, double area, double x, double y, double red, double green, double blue) {
        super(lineWidth, area, x, y, red, green, blue);
    }

    public Oval(double lineWidth, double area, double x, double y, double red, double green, double blue, double radius) {
        super(lineWidth, area, x, y, red, green, blue);
        this.radius = radius;
    }

/*    @Override
    public String getInfo() {
        final StringBuffer sb = new StringBuffer("Oval{");
        sb.append("\t").append(super.getInfo()).append("\t");
        sb.append(", radius=").append(radius);
        sb.append('}');
        return sb.toString();
    }*/

    @Override
    public String getInfo() {
        final StringBuffer sb = new StringBuffer("Oval{");
        sb.append("\t").append(super.getInfo()).append("\t");
        sb.append("radius=").append(radius);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public void draw(GraphicsContext g) {
        g.setStroke(super.getColor());
        g.setLineWidth(2);
        g.strokeOval(super.getX() - this.radius / 2, super.getY() - this.radius / 2, this.radius, this.radius);
    }
    public double getArea(double param){
        param = this.radius;
        return Math.PI*(param*param);
    }



    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }


}
