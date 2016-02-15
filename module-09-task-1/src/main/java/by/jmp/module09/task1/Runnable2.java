package by.jmp.module09.task1;

/**
 * Created by Kiryl_Parfiankou on 2/15/2016.
 */
public class Runnable2 implements Runnable{

    public void run() {
        try {
            Runner.method2();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
