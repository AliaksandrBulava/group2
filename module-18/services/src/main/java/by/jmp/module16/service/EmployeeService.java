package by.jmp.module16.service;

import by.jmp.module16.domain.Employee;
import by.jmp.module16.domain.Personal;

/**
 * Created by Kiryl_Parfiankou on 4/4/2016.
 */
public interface EmployeeService {
    Employee create(Employee employee);
    Employee get(Long id);
    void delete(Long id);
    Employee update(Employee employee);
    void addPersonal(Long employeeId, Personal personal);
    void close();
}