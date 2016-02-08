package by.module08.task5.bean;

import java.util.ArrayDeque;

/**
 * Created by Kiryl_Parfiankou on 2/8/2016.
 */
public class Queue<T> {

    private int maxSize = 10;
    private java.util.Queue<T> items;

    public Queue() {
        items = new ArrayDeque<T>();
    }

    public Queue(int maxSize) {
        this.maxSize = maxSize;
        items = new ArrayDeque<T>();
    }

    public synchronized void put(T t) {
        while (items.size() >= maxSize) {
            try {
                wait();
            } catch (InterruptedException e) {
                // Do Nothing
            }
        }
        items.add(t);
    }

    public synchronized T take() {
        while (items.size() <= 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                // Do Nothing
            }
        }
        notifyAll();
        return  items.poll();
    }

    public int size() {
        return items.size();
    }
}
