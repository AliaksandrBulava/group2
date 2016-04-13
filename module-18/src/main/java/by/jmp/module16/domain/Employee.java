package by.jmp.module16.domain;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 4/3/2016.
 */
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Embedded
    private Address address;
    @OneToOne
    @JoinColumn(referencedColumnName="id")
    private Personal personal;
    @ManyToOne
    @JoinColumn(name="unit_id")
    private Unit unit;
    @ManyToMany
    @JoinTable(
            name="employee_projects",
            joinColumns = @JoinColumn(name="employee_id"),
            inverseJoinColumns = @JoinColumn(name="project_id")
    )
    private List<Project> projects;

    @Enumerated(EnumType.STRING)
    private EmployeeStatus status;

    public Employee() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Personal getPersonal() {
        return personal;
    }

    public void setPersonal(Personal personal) {
        this.personal = personal;
    }

    public Unit getUnit() {
        return unit;
    }

    public void setUnit(Unit unit) {
        this.unit = unit;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }
}
