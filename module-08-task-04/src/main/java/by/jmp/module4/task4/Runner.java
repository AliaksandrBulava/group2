package by.jmp.module4.task4;

import by.jmp.module4.task4.beans.Car;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.*;

/**
 * Created by Kiryl Parfiankou on 07.02.2016.
 */
public class Runner {

    static private Logger log = LogManager.getLogger(Runner.class);

    public static void main(String[] args) {

        List<Thread> finishList = Collections.synchronizedList(new ArrayList<Thread>());
        List<Thread> disqualifiedList = Collections.synchronizedList(new ArrayList<Thread>());
        List<Thread> startList = Collections.synchronizedList(new ArrayList<Thread>());
        Map<String,Car> carMap = Collections.synchronizedMap(new HashMap<String, Car>());

        for(int i = 0; i < 10; i++) {
            String carName = "Car " + i;
            Car car = new Car(carName, 100);
            carMap.put(carName,car);
            startList.add(new Thread(car,carName));
        }

        String disqualifiedCatName = "Disqualifiable";
        Car disqualified = new Car(disqualifiedCatName, 100);
        carMap.put(disqualifiedCatName,disqualified);
        startList.add(new Thread(disqualified,disqualifiedCatName));

        try {
            for(Thread car: startList) {
                car.start();
            }

            Set<String> finishSet = new HashSet<String>();
            Set<Thread> disqualifiedSet = new HashSet<Thread>();

            long timer = 0;
            int step = 10;

            while (true) {

                Thread.sleep(step);
                timer += step;

                for(Thread thread: startList) {
                    if (Thread.State.TERMINATED.equals(thread.getState()) && !finishSet.contains(thread.getName())) {
                        if (carMap.get(thread.getName()).isDisqualified()) {
                            if (!disqualifiedSet.contains(thread)) {
                                disqualifiedList.add(thread);
                                finishSet.add(thread.getName());
                            }
                        } else {
                            finishList.add(thread);
                            finishSet.add(thread.getName());
                        }
                    }
                }

                if(startList.size() == finishSet.size()) {
                    break;
                }

                if (timer >= 5000) {
                    disqualified.setDisqualified(true);
                }
            }

            log.info("Winner is " + finishList.get(0).getName());

        } catch (InterruptedException e) {
            log.error(e);
        }
    }
}
