package task1.factory;

/**
 * Created by Kiryl_Parfiankou on 12/14/2015.
 */
public class PersonAbstractFactory {

    private final static String DEFAULT_FILE_NAME = "./person.txt";

    private static PersonDao instance;

    private PersonAbstractFactory() {

    }

    public static synchronized PersonDao getInstance() {
        if (instance == null) {
            instance = new FilePersonDao(DEFAULT_FILE_NAME);
        }
        return instance;
    }

}
