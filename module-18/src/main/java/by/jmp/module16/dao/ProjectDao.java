package by.jmp.module16.dao;

import by.jmp.module16.domain.Project;

/**
 * Created by Kiryl_Parfiankou on 4/4/2016.
 */
public interface ProjectDao {
    Project create(Project project);
    Project get(Long id);
    void delete(Long id);
    Project update(Project project);
    void close();
}
