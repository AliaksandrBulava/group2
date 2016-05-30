package by.task7;

import by.task7.superheroes.Superman;

/**
 * Created by Kiryl_Parfiankou on 12/14/2015.
 */
public class Runner implements Runnable{

    public void run() {
        Superman.getInstance().say();
    }

    public static void main(String [] args) {
        System.out.println("Task 7: Singleton");

        for(int i = 0; i < 100; i++) {
            new Thread(new Runner()).start();
        }
    }
}
