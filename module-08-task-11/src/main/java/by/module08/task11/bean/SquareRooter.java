package by.module08.task11.bean;

import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 2/8/2016.
 */
public class SquareRooter implements Runnable {

    private int squareSum;
    private List<Integer> list;

    public SquareRooter(List<Integer> list) {
        this.list = list;
        squareSum = 0;
    }

    public void run() {

        int size = list.size();
        int index = 0;
        int addItem = 0;

        while (true) {
            size = list.size();
            while (index < size) {
                addItem = list.get(index);
                squareSum += addItem * addItem;
                index++;
            }
            System.out.println("Square root sum: " + squareSum);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
