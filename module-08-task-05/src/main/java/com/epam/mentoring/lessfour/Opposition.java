package com.epam.mentoring.lessfour;

/**
 * Created by Kiryl Parfiankou on 08.02.2016.
 */
import java.util.Random;

public class Opposition {

    public class Counter {

        private int count = 10;

        public void increment() {
            synchronized(this) {
                this.notifyAll();
                count++;
            }
        }

        public void decrement() {
            synchronized(this) {
                count--;
            }
        }

        public int get() {
            synchronized(this) {
                return count;
            }
        }

    }

    public class Wrestler implements Runnable {

        private Counter counter;

        private boolean increment;

        private Random rand;

        public Wrestler(Counter counter, boolean increment) {
            this.counter = counter;
            this.increment = increment;
            rand = new Random();
        }


        public void run() {
            while (true) {
                if (increment) {
                    counter.increment();
                } else {
                    synchronized (counter) {
                        while (counter.get() <= 0) {
                            try {
                                counter.wait();
                            } catch (InterruptedException e) {
                                // do nothing
                            }
                        }
                        counter.decrement();
                    }
                }

                int x = counter.get();
                if (x < 0) {
                    t1.interrupt();
                    t2.interrupt();
                    throw new IllegalStateException("We have below zero!");
                }

                System.out.println("Wrestler" + Thread.currentThread().getName() + " " + x);
                try {
                    Thread.sleep(rand.nextInt(100));
                } catch (InterruptedException e) {
                    break;
                }
            }
        }

    }

    private Thread t1, t2;

    public static void main(String[] args) {
        new Opposition().start();
    }

    private void start() {
        Counter counter = new Counter();
        t1 = new Thread(new Wrestler(counter, true));
        t2 = new Thread(new Wrestler(counter, false));
        t1.start();
        t2.start();
        try {
            while (true) {
                Thread.sleep(100);
                if (!(t1.isAlive() && t2.isAlive())) {
                    break;
                }
            }
        } catch (InterruptedException e) {
        }
        System.out.println("Finished");
    }
}