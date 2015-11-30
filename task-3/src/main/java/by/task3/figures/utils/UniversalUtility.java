package by.task3.figures.utils;

import by.task3.figures.Circle;
import by.task3.figures.Figure;
import by.task3.figures.Rectangle;
import by.task3.figures.Square;

/**
 * Created by Julia on 01.12.2015.
 */
public class UniversalUtility {

    public double calculationArea(Figure figure) {

        if (figure instanceof Circle) {

            Circle circle = (Circle) figure;
            double radius = circle.getRadius();
            return Math.PI*radius*radius;

        } else if (figure instanceof Rectangle) {

            Rectangle rectangle = (Rectangle) figure;
            return rectangle.getHeight() * rectangle.getLength();

        } else if (figure instanceof Square) {

            Square square = (Square) figure;
            return square.getSide() * square.getSide();
        }
        return 0;
    }

    public void print(String msg) {
        System.out.println(msg);
    }

}
