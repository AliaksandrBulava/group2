package by.jmp.module09.task1;

/**
 * Created by Kiryl_Parfiankou on 2/15/2016.
 */
public class Runnable1 implements Runnable{

    public void run() {
        try {
            Runner.method1();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
