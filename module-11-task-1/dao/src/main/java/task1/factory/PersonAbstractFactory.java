package task1.factory;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import task1.dao.PersonDao;
import task1.dao.db.DbPersonDao;
import task1.dao.file.FilePersonDao;

/**
 * Created by Kiryl_Parfiankou on 12/14/2015.
 */
public class PersonAbstractFactory {

    private final static String CONFIG_FILE = "config.properties";

    private final static String DB_DAO ="db";
    private final static String FILE_DAO ="file";

    private final static String DAO_PROPERTY ="dao";
    private final static String FILE_NAME_PROPERTY = "file.name";

    private static PersonDao instance;

    private PersonAbstractFactory() {

    }

    public static synchronized PersonDao getInstance() {

        Properties prop = new Properties();
        InputStream input = null;

        if (instance == null) {

            input = PersonAbstractFactory.class.getClassLoader().getResourceAsStream(CONFIG_FILE);
            if(input==null){
                System.out.println("Sorry, unable to find " + CONFIG_FILE);
                return null;
            }
            try {
                prop.load(input);
                String daoType = prop.getProperty(DAO_PROPERTY);
                String fileName = prop.getProperty(FILE_NAME_PROPERTY);

                if (DB_DAO.equals(daoType)) {
                    instance = new DbPersonDao();
                } else if(FILE_DAO.equals(daoType)) {
                    instance = new FilePersonDao(fileName);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return instance;
    }

}
