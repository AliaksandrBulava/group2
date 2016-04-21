package by.jmp.module16.factory;

import by.jmp.module16.dao.PersonalDao;
import by.jmp.module16.dao.hibernate.PersonalDaoImpl;

/**
 * Created by Kiryl_Parfiankou on 4/4/2016.
 */
public class PersonalDaoFactory {

    private static PersonalDao instance;

    private PersonalDaoFactory(){
    }


    public static synchronized PersonalDao createInstance() {

        return new PersonalDaoImpl();
    }
}
