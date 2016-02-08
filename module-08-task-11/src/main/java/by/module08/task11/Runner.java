package by.module08.task11;

import by.module08.task11.bean.Adder;
import by.module08.task11.bean.SquareRooter;
import by.module08.task11.bean.Summer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by Kiryl_Parfiankou on 2/8/2016.
 */
public class Runner {
    public static void main(String args[]) {

        List<Integer> list = Collections.synchronizedList(new ArrayList<Integer>());

        new Thread(new Adder(list)).start();
        new Thread(new Summer(list)).start();
        new Thread(new SquareRooter(list)).start();

    }
}
