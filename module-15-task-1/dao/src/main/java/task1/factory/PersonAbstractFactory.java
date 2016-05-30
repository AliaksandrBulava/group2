package task1.factory;

import task1.dao.PersonDao;
import task1.dao.db.DbPersonDao;

import java.io.InputStream;
import java.util.Properties;

/**
 * Created by Kiryl_Parfiankou on 12/14/2015.
 */
public class PersonAbstractFactory {

    private final static String CONFIG_FILE = "config.properties";

    private final static String DB_DERBY ="derby";

    private final static String DAO_PROPERTY ="dao";

    private static PersonDao instance;

    private PersonAbstractFactory() {

    }

    public static synchronized PersonDao getInstance() {

        Properties prop = new Properties();
        InputStream input = null;

        if (instance == null) {
            instance = new DbPersonDao();
        }
        return instance;
    }

}
