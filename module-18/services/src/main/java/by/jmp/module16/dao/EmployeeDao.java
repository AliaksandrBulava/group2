package by.jmp.module16.dao;

import by.jmp.module16.domain.Employee;

/**
 * Created by Kiryl_Parfiankou on 4/4/2016.
 */
public interface EmployeeDao {
    Employee create(Employee employee);
    Employee get(Long id);
    void delete(Long id);
    Employee update(Employee employee);
    void close();
}
