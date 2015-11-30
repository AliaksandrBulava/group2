package by.task3.figures;

/**
 * Created by Kiryl_Parfiankou on 11/30/2015.
 */
public class Square implements Figure{

    private double side;

    public Square(double side) {
        this.side = side;
    }

    public double getArea() {
        return side*side;
    }
}
