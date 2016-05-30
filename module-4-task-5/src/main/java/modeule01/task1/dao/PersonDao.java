package modeule01.task1.dao;

import java.util.List;

import modeule01.task1.domain.Person;

/**
 * Created by Kiryl_Parfiankou on 12/14/2015.
 */
public interface PersonDao {
    void writePerson(Person person);
    List<Person> readPersons();
    Person readPerson(String name);
}
