package module11.task1.service;

import task1.dao.PersonDao;
import task1.domain.Person;
import task1.factory.PersonAbstractFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 3/5/2016.
 */
public class PersonServiceImpl implements PersonService {
    
    private PersonDao personDao;

    public PersonServiceImpl() {
        personDao = PersonAbstractFactory.getInstance();
    }

    @Override
    public void addPerson(String personStr) {
        
        if (personStr == null) {
            return;
        }

        String[] snippets = personStr.split(",");
        Person person = null;
        int age;
        if (snippets.length > 2) {
            age = Integer.valueOf(snippets[1]);
            person = new Person(snippets[0], age, snippets[2]);
            person.setName(snippets[0]);
        } else if (snippets.length > 1) {
            age = Integer.valueOf(snippets[1]);
            person = new Person(snippets[0], age, snippets[2]);
        } else if(snippets.length > 0) {
            person = new Person(snippets[0], 0, "");
        }
        personDao.writePerson(person);
    }

    @Override
    public List<String> getPersons() {

        List<String> result = new ArrayList<String>();

        for(Person person: personDao.readPersons()) {
            result.add(person.toString());
        }
        
        return result;
    }

    @Override
    public String getPerson(String name) {
        Person person = personDao.readPerson(name);
        return person != null ? person.toString() : null;
    }
}
