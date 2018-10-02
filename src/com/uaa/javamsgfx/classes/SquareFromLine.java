package com.uaa.javamsgfx.classes;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;


public class SquareFromLine extends Figure {

    private double storona;
    private double rotate;
    private double x1, x2, x3, x4;
    private double y1, y2, y3, y4;


    public SquareFromLine(double lineWidth, double area, double x, double y, double red, double green, double blue) {
        super(lineWidth, area, x, y, red, green, blue);
    }

    public SquareFromLine(double lineWidth, double area, double x, double y, double red, double green, double blue, double storona, double rotate) {
        super(lineWidth, area, x, y, red, green, blue);
        this.storona = storona;
        this.rotate = rotate;
    }

    @Override
    public void draw(GraphicsContext g) {
        g.setStroke(super.getColor());
        g.setLineWidth(2);
        rotate = this.rotate;
        x1 = super.getX() + this.storona * Math.cos((45 + rotate) * Math.PI / 180) / Math.sqrt(2);
        x2 = super.getX() + this.storona * Math.cos((135 + rotate) * Math.PI / 180) / Math.sqrt(2);
        x3 = super.getX() + this.storona * Math.cos((225 + rotate) * Math.PI / 180) / Math.sqrt(2);
        x4 = super.getX() + this.storona * Math.cos((315 + rotate) * Math.PI / 180) / Math.sqrt(2);

        y1 = super.getY() + this.storona * Math.sin((45 + rotate) * Math.PI / 180) / Math.sqrt(2);
        y2 = super.getY() + this.storona * Math.sin((135 + rotate) * Math.PI / 180) / Math.sqrt(2);
        y3 = super.getY() + this.storona * Math.sin((225 + rotate) * Math.PI / 180) / Math.sqrt(2);
        y4 = super.getY() + this.storona * Math.sin((315 + rotate) * Math.PI / 180) / Math.sqrt(2);


        // g.strokeRect(this.myX - this.storona / 2, this.myY - this.storona / 2, this.storona, this.storona);
        g.strokePolygon(
                new double[]{x1, x2, x3, x4}, new double[]{y1, y2, y3, y4}, 4);
    }

    @Override
    public String getInfo() {
        final StringBuffer sb = new StringBuffer("SquareFromLine{");
        sb.append("\t").append(super.getInfo()).append("\t");
        sb.append("storona=").append(storona);
        sb.append(", rotate=").append(rotate);
        sb.append('}');
        return sb.toString();
    }

    public double getArea(double param) {
        param = this.storona;
        return param * param;
    }

    public double getStorona() {
        return storona;
    }

    public void setStorona(double storona) {
        this.storona = storona;
    }

    public double getRotate() {
        return rotate;
    }

    public void setRotate(double rotate) {
        this.rotate = rotate;
    }
}
