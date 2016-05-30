package by.module08.task11.bean;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Kiryl_Parfiankou on 2/8/2016.
 */
public class Adder implements Runnable {

    private Random random;
    private List<Integer> list;

    public Adder(List<Integer> list) {
        random = new Random();
        this.list = list;
    }

    public void run() {
        while (true) {
            int item = random.nextInt(10);
            list.add(item);
            System.out.println("Added: " + item);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                break;
            }
        }
    }
}
