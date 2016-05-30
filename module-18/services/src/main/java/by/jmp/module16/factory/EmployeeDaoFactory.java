package by.jmp.module16.factory;

import by.jmp.module16.dao.EmployeeDao;
import by.jmp.module16.dao.hibernate.EmploeeDaoImpl;

/**
 * Created by Kiryl_Parfiankou on 4/4/2016.
 */
public class EmployeeDaoFactory {

    private static EmployeeDao instance;

    private EmployeeDaoFactory(){
    }

    public static synchronized EmployeeDao createInstance() {

        return new EmploeeDaoImpl();
    }
}
