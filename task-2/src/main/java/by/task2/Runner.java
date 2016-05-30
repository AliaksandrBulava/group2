package by.task2;

import by.task2.figures.Circle;
import by.task2.figures.Rectangle;
import by.task2.figures.Square;

import javax.annotation.Resource;

/**
 * Created by Kiryl_Parfiankou on 11/30/2015.
 */
public class Runner {
    public static void main(String[] args) {
        System.out.println("Task 2");

        Circle circle = new Circle(2);
        Rectangle rectangle = new Rectangle(4,5);
        Square square = new Square(3);

        System.out.println("Circle Area: " + circle.getArea());
        System.out.println("Rectangle Area: " + rectangle.getArea());
        System.out.println("Square Area: " + square.getArea());

    }
}
