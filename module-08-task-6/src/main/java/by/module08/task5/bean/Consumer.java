package by.module08.task5.bean;

import java.util.Random;

/**
 * Created by Kiryl_Parfiankou on 2/8/2016.
 */
public class Consumer implements Runnable {

    private Random rand;
    private Queue<String> queue;
    private String name;

    public Consumer(String name, Queue<String> queue) {
        this.queue = queue;
        this.name = name;
        rand = new Random();
    }

    public void run() {
        while (true) {

            String message = queue.take();
            System.out.println(message + "[" + name + "] - " + queue.size());

            try {
                Thread.sleep(rand.nextInt(500));
            } catch (InterruptedException e)  {
                break;
            }
        }
    }
}
