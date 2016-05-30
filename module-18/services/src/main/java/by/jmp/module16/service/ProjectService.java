package by.jmp.module16.service;

import by.jmp.module16.domain.Project;

/**
 * Created by Kiryl_Parfiankou on 4/4/2016.
 */
public interface ProjectService {
    Project create(Project employee);
    Project get(Long id);
    void delete(Long id);
    Project update(Project employee);
    void addEmployee(Long employeeId, Long projectId);
    void close();
}
