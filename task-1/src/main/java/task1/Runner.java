package task1;

import task1.domain.Person;
import task1.factory.PersonAbstractFactory;
import task1.dao.PersonDao;

/**
 * Created by Kiryl_Parfiankou on 12/14/2015.
 */
public class Runner {
    public static void main(String [] args) {
        System.out.println("Task 1.");

        PersonDao personDao =  PersonAbstractFactory.getInstance();

        Person person = new Person("Ivanov", 20, "M");

        personDao.writePerson(person);
        for (Person per: personDao.readPersons()) {
            System.out.println(per);
        }
    }
}
