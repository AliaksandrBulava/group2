package by.task3;

import by.task3.figures.Circle;
import by.task3.figures.Rectangle;
import by.task3.figures.Square;
import by.task3.figures.utils.UniversalUtility;

import javax.annotation.Resource;

/**
 * Created by Kiryl_Parfiankou on 11/30/2015.
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("Task 3");

        Circle circle = new Circle(2);
        Rectangle rectangle = new Rectangle(4,5);
        Square square = new Square(3);

        UniversalUtility uu = new UniversalUtility();
        double circleArea = uu.calculationArea(circle);
        uu.print("Circle Area: " + circleArea);
    }
}
