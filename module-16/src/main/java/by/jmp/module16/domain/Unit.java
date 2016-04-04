package by.jmp.module16.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 4/3/2016.
 */
@Entity
public class Unit {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    @OneToMany(targetEntity = Employee.class, mappedBy = "unit")
    private List<Employee> employees;

    public Unit() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }
}