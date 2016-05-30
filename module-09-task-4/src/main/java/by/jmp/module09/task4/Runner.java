package by.jmp.module09.task4;

import java.lang.management.ManagementFactory;

/**
 * Created by Kiryl_Parfiankou on 2/15/2016.
 */
public class Runner {

    public static Object object = new Object();


    public static void main(String args[]) {

        System.out.println("PID:" + ManagementFactory.getRuntimeMXBean().getName());

        for(int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(500);
                new Thread(new RunnableClass()).start();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    static public void bottleneckMethod() throws Exception{

        System.out.println("Start method");

        synchronized (object) {
            Thread.sleep(1000);
        }

    }

}
