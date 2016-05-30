package by.jmp.module09.task4;

/**
 * Created by Kiryl_Parfiankou on 2/15/2016.
 */
public class RunnableClass implements java.lang.Runnable {

    public void run() {
        try {
            Runner.bottleneckMethod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
