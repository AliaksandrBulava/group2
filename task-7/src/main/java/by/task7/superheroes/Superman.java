package by.task7.superheroes;

import java.util.UUID;

/**
 * Created by Kiryl_Parfiankou on 12/14/2015.
 */
public class Superman {

    private String id;

    private Superman() {
        this.id = UUID.randomUUID().toString();
    }

    private static class SupermanHolder {
        private final static Superman instance = new Superman();
    }

    public static Superman getInstance() {
        //return new Superman();
        return SupermanHolder.instance;
    }

    public String getId() {
        return id;
    }

    public void say() {
        System.out.println(id + ": I'm Superman");
    }
}
