package by.jmp.module16.factory;

import by.jmp.module16.dao.UnitDao;
import by.jmp.module16.dao.hibernate.UnitDaoImpl;

/**
 * Created by Kiryl_Parfiankou on 4/4/2016.
 */
public class UnitDaoFactory {

    private static UnitDao instance;

    private UnitDaoFactory(){
    }

    public static synchronized UnitDao createInstance() {

        return new UnitDaoImpl();
    }
}
