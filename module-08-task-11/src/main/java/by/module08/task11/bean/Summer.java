package by.module08.task11.bean;

import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 2/8/2016.
 */
public class Summer implements Runnable {

    private List<Integer> list;
    private int sum;

    public Summer(List<Integer> list) {
        this.list = list;
        sum = 0;
    }

    public void run() {

        int size = list.size();
        int index = 0;

        while (true) {
            size = list.size();
            while (index < size) {
                sum += list.get(index);
                index++;
            }
            System.out.println("Sum: " + sum);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
