package by.task3.figures.utils;

import by.task3.figures.Figure;

/**
 * Created by Julia on 01.12.2015.
 */
public class UniversalUtility {

    public double calculationArea(Figure figure) {
        return figure.getArea();
    }

    public void print(String msg) {
        System.out.println(msg);
    }

}
