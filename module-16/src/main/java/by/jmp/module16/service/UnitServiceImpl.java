package by.jmp.module16.service;

import by.jmp.module16.dao.EmployeeDao;
import by.jmp.module16.dao.UnitDao;
import by.jmp.module16.domain.Employee;
import by.jmp.module16.domain.Unit;
import by.jmp.module16.factory.EmployeeDaoFactory;
import by.jmp.module16.factory.UnitDaoFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 4/4/2016.
 */
public class UnitServiceImpl implements UnitService{

    private EmployeeDao employeeDao;
    private UnitDao unitDao;

    public UnitServiceImpl() {
        unitDao = UnitDaoFactory.createInstance();
        employeeDao = EmployeeDaoFactory.createInstance();
    }

    public Unit create(Unit unit) {
        return unitDao.create(unit);
    }

    public Unit get(Long id) {
        return unitDao.get(id);
    }

    public void delete(Long id) {
        unitDao.delete(id);
    }

    public Unit update(Unit unit) {
        return unitDao.update(unit);
    }

    public void addEmployee(Long employeeId, Long unitId) {
        Employee employee = employeeDao.get(employeeId);
        Unit unit = unitDao.get(unitId);
        employee.setUnit(unit);

        List<Employee> employees = unit.getEmployees();
        if (employees == null) {
            employees = new ArrayList<Employee>();
        }
        employees.add(employee);
        unit.setEmployees(employees);

        employeeDao.update(employee);
        unitDao.update(unit);
    }

    public void close() {
        unitDao.close();
        employeeDao.close();
    }
}
