package by.jmp.module16;

import by.jmp.module16.domain.*;
import by.jmp.module16.dao.ProjectDao;
import by.jmp.module16.factory.ProjectDaoFactory;
import by.jmp.module16.service.*;

/**
 * Created by Kiryl_Parfiankou on 4/4/2016.
 */
public class Runner {

    public static void main(String[] args) {
        System.out.println("Module 16");

        ProjectService projectService = new ProjectServiceImpl();
        EmployeeService employeeService = new EmployeeServiceImpl();
        UnitService unitService = new UnitServiceImpl();


        Employee employee = new Employee();
        Address address = new Address();
        address.setCity("City");
        address.setCountry("Country");
        address.setNumber("123");
        address.setStreet("Street");
        address.setPostcode(123456);
        employee.setAddress(address);
        employeeService.create(employee);

        Personal personal = new Personal();
        personal.setFirstName("First Name");
        personal.setLastName("Last Name");
        personal.setAge(25);

        employeeService.addPersonal(employee.getId(), personal);


        Unit unit = new Unit();
        unit.setName("Unit 1");
        unitService.create(unit);
        unitService.addEmployee(employee.getId(), unit.getId());


        Project project0 = new Project();
        project0.setName("Test Project 0");
        projectService.create(project0);
        projectService.addEmployee(employee.getId(), project0.getId());

        Project project = new Project();
        project.setName("Test Project 1");

        projectService.create(project);
        System.out.println("Project id: " + project.getId());
        projectService.delete(project.getId());

        projectService.close();
        employeeService.close();
        unitService.close();

    }
}
