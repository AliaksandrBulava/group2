package module11.task1.service;

import task1.domain.Person;

import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 3/5/2016.
 */
public interface PersonService {
    void addPerson(String person);
    List<String> getPersons();
    String getPerson(String name);
}
