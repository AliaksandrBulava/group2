package by.jmp.module16.service;

import by.jmp.module16.dao.EmployeeDao;
import by.jmp.module16.dao.ProjectDao;
import by.jmp.module16.domain.Employee;
import by.jmp.module16.domain.Project;
import by.jmp.module16.factory.EmployeeDaoFactory;
import by.jmp.module16.factory.ProjectDaoFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 4/4/2016.
 */
public class ProjectServiceImpl implements ProjectService{

    private ProjectDao projectDao;
    private EmployeeDao employeeDao;

    public ProjectServiceImpl() {
        projectDao = ProjectDaoFactory.createInstance();
        employeeDao = EmployeeDaoFactory.createInstance();

    }

    public Project create(Project project) {
        Project projectWithId = projectDao.create(project);
        return projectWithId;
    }

    public Project get(Long id) {
        Project project = projectDao.get(id);
        return project;
    }

    public void delete(Long id) {
        projectDao.delete(id);
    }

    public Project update(Project project) {
        projectDao.update(project);
        return projectDao.update(project);
    }

    public void addEmployee(Long employeeId, Long projectId) {
        Employee employee = employeeDao.get(employeeId);
        Project project = projectDao.get(projectId);
        List<Project> projects = employee.getProjects();
        if(projects == null) {
            projects = new ArrayList<Project>();
        }
        projects.add(project);
        employee.setProjects(projects);
        employeeDao.update(employee);
    }

    public void close() {
        projectDao.close();
        employeeDao.close();
    }
}
