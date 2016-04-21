package by.jmp.module16.domain;

import javax.persistence.*;

/**
 * Created by Kiryl_Parfiankou on 4/3/2016.
 */
@Entity
public class Project {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    private String name;

    public Project() {
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
}
