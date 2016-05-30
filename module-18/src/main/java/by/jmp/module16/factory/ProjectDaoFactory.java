package by.jmp.module16.factory;

import by.jmp.module16.dao.ProjectDao;
import by.jmp.module16.dao.hibernate.ProjectDaoImpl;

/**
 * Created by Kiryl_Parfiankou on 4/4/2016.
 */
public class ProjectDaoFactory {

    private static ProjectDao instance;

    private ProjectDaoFactory(){
    }


    public static synchronized ProjectDao createInstance() {

        return new ProjectDaoImpl();
    }
}
