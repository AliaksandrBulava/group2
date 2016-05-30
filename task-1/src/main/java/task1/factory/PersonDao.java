package task1.factory;

import task1.domain.Person;

import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 12/14/2015.
 */
public interface PersonDao {
    void writePerson(Person person);
    List<Person> readPersons();
    Person readPerson(String name);
}
