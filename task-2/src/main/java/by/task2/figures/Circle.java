package by.task2.figures;


/**
 * Created by Kiryl_Parfiankou on 11/30/2015.
 */
public class Circle implements Figure{

    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI*radius*radius;
    }
}
