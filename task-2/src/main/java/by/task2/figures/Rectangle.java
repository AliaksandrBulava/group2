package by.task2.figures;

/**
 * Created by Kiryl_Parfiankou on 11/30/2015.
 */
public class Rectangle implements Figure {

    private double height;
    private double length;

    public Rectangle(double height, double length) {
        this.height = height;
        this.length = length;
    }

    public double getArea() {
        return height * length;
    }
}
