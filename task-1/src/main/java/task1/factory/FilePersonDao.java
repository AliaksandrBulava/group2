package task1.factory;

import task1.domain.Person;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 12/14/2015.
 */
public class FilePersonDao implements PersonDao{

    private static final String DEVIDER = ",";

    private String fileName;
    private List<Person> cache;



    public FilePersonDao(String fileName) {
        this.fileName = fileName;
        cache = new ArrayList<Person>();
    }

    public void writePerson(Person person) {

        try {
            Writer writer = new BufferedWriter(new FileWriter(fileName, true));
            writer.append(person.toString());
            cache.add(person);
            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public List<Person> readPersons() {

        List<Person> persons = new ArrayList<Person>();

        try {

            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line;
            while (true) {
                line = reader.readLine();
                if (line == null) {
                    break;
                }
                persons.add(convert(line));

            }

        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return persons;
    }

    public Person readPerson(String name) {

        if (name == null) {
            return null;
        }

        Person result = null;
        for (Person person: cache) {
            if (person.equals(name)) {
                result = person;
                break;
            }
        }

        if (result == null)  {
            try {
                BufferedReader reader = new BufferedReader(new FileReader(fileName));
                String line;
                while (true) {
                    line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    if (name.equals(convert(line).getName())) {
                        break;
                    }
                }

            } catch (FileNotFoundException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return result;
    }

    private Person convert(String line) {

        String[] snippets = line.split(DEVIDER);
        Person person = new Person(snippets[0], // name
                                   Integer.valueOf(snippets[1]), // age
                                   snippets[2]); // gender

        return person;
    }
}
