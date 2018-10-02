package com.uaa.javamsgfx.comparators;

import com.uaa.javamsgfx.classes.Figure;

import java.util.Comparator;

public class FigureAreaComparator implements Comparator <Figure> {

    @Override
    public int compare(Figure o1, Figure o2) {
        return (int) (o1.getArea() - o2.getArea());
    }
}
