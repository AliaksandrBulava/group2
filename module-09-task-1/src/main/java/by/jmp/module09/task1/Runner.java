package by.jmp.module09.task1;

/**
 * Created by Kiryl_Parfiankou on 2/15/2016.
 */
public class Runner {

    public static Object object1 = new Object();
    public static Object object2 = new Object();

    public static void main(String [] args) {

        new Thread(new Runnable1()).start();
        new Thread(new Runnable2()).start();


    }

    static public void method1() throws Exception{

        System.out.println("Start method1");

        synchronized (object1) {

            Thread.sleep(300);

            synchronized (object2) {
                System.out.println("Finish method1");
            }
        }

    }

    static public void  method2() throws Exception{

        System.out.println("Start method2");

        synchronized (object2) {

            Thread.sleep(300);

            synchronized (object1) {
                System.out.println("Finish method2");
            }
        }
    }
}
