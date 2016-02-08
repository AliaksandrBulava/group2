package by.module08.task5.bean;

import java.util.Random;

/**
 * Created by Kiryl_Parfiankou on 2/8/2016.
 */
public class Producer implements Runnable{

    private String name;
    private Random rand;
    private Queue<String> queue;

    public Producer(String name, Queue<String> queue) {
        this.name = name;
        rand = new Random();
        this.queue = queue;
    }

    public void run() {

        while (true) {

            queue.put("Message from " + name);

            try {
                Thread.sleep(rand.nextInt(500));
            } catch (InterruptedException e)  {
                break;
            }
        }
    }
}
