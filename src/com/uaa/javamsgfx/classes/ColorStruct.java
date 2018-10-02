package com.uaa.javamsgfx.classes;

import java.awt.*;
import java.io.Serializable;

public class ColorStruct implements Serializable {
    public double red;
    public double blue;
    public double green;

    public ColorStruct(Color c) {
        red = c.getRed();
        blue = c.getBlue();
        green = c.getGreen();
    }
}
