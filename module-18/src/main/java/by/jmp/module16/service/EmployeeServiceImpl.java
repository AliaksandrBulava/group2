package by.jmp.module16.service;

import by.jmp.module16.dao.EmployeeDao;
import by.jmp.module16.dao.PersonalDao;
import by.jmp.module16.domain.Employee;
import by.jmp.module16.domain.Personal;
import by.jmp.module16.factory.EmployeeDaoFactory;
import by.jmp.module16.factory.PersonalDaoFactory;

/**
 * Created by Kiryl_Parfiankou on 4/4/2016.
 */
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;
    private PersonalDao personalDao;

    public EmployeeServiceImpl() {
        employeeDao = EmployeeDaoFactory.createInstance();
        personalDao = PersonalDaoFactory.createInstance();

    }

    public Employee create(Employee employee) {
        return employeeDao.create(employee);
    }

    public Employee get(Long id) {
        return employeeDao.get(id);
    }

    public void delete(Long id) {
        employeeDao.delete(id);
    }

    public Employee update(Employee employee) {
        return employeeDao.update(employee);
    }

    public void addPersonal(Long employeeId, Personal personal) {
        Employee employee = employeeDao.get(employeeId);

        personalDao.create(personal);
        employee.setPersonal(personal);
        employeeDao.update(employee);
    }

    public void close() {
        employeeDao.close();
        personalDao.close();
    }
}
