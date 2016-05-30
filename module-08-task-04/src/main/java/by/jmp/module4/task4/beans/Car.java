package by.jmp.module4.task4.beans;


import by.jmp.module4.task4.exeption.DisqualifyExeption;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by Kiryl Parfiankou on 07.02.2016.
 */
public class Car implements Runnable {

    private static final long MAX_DISTANCE = 10000;

    Logger log = LogManager.getLogger(getClass());

    private long friction;
    private long distance;
    private boolean disqualified;

    private String name;

    public Car(String name, long friction) {
        this.name = name;
        this.friction = friction;
    }

    public void run(){
        try {
            while (distance < MAX_DISTANCE) {
                if (disqualified) {
                    break;
                }
                Thread.sleep(friction);
                distance += 100;
                log.info(name + " " + distance);
            }
        } catch (InterruptedException e) {
            log.error(e);
        }
    }

    public boolean isDisqualified() {
        return disqualified;
    }

    public void setDisqualified(boolean disqualified) {
        this.disqualified = disqualified;
    }
}
