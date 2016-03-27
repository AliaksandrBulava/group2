package task1.dao;

import task1.domain.Person;

import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 12/14/2015.
 */
public interface PersonDao {
    void writePerson(Person person);
    List<Person> readPersons();
    Person readPerson(String login);
    void deletePerson(String login);
    void updatePerson(Person person);
}
