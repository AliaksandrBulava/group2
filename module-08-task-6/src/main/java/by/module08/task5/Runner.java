package by.module08.task5;

import by.module08.task5.bean.Consumer;
import by.module08.task5.bean.Producer;
import by.module08.task5.bean.Queue;

/**
 * Created by Kiryl_Parfiankou on 2/8/2016.
 */
public class Runner {

    public static void main(String[] args) {

        Queue<String> queue = new Queue<String>(3);
       (new Thread (new Producer("Producer 1", queue))).start();
        (new Thread (new Producer("Producer 2", queue))).start();
        (new Thread (new Producer("Producer 3", queue))).start();
        (new Thread (new Producer("Producer 4", queue))).start();
        (new Thread (new Producer("Producer 5", queue))).start();

        (new Thread (new Consumer("Consumer 1", queue))).start();
        (new Thread (new Consumer("Consumer 2", queue))).start();
        (new Thread (new Consumer("Consumer 3", queue))).start();
        (new Thread (new Consumer("Consumer 4", queue))).start();
        (new Thread (new Consumer("Consumer 5", queue))).start();
    }
}
