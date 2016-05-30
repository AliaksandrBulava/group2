package module11.task1.resource;

import com.fasterxml.jackson.databind.ObjectMapper;
import task1.dao.PersonDao;
import task1.domain.Person;
import task1.factory.PersonAbstractFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 3/27/2016.
 */
@Path("/persons")
public class PersonResource {

    private PersonDao personDao;

    public PersonResource() {
        super();
        this.personDao = PersonAbstractFactory.getInstance();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersons() {
        return personDao.readPersons();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public void addPerson(String personStr) {

        ObjectMapper objectMapper = new ObjectMapper();
        Person person = null;
        try {
            person = objectMapper.readValue(personStr, Person.class);
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (person != null) {
            personDao.writePerson(person);
        }
    }

    @PUT
    @Consumes(MediaType.APPLICATION_XML)
    public void updatePerson(String personStr) {

        try {
            JAXBContext context = JAXBContext.newInstance(Person.class);
            Unmarshaller unmarshaller = context.createUnmarshaller();

            Person person = (Person) unmarshaller.unmarshal(new ByteArrayInputStream(personStr.getBytes()));
            personDao.updatePerson(person);

        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    @DELETE
    @Path("{login}")
    public void deletePerson(@PathParam("login") String login) {
        personDao.deletePerson(login);
    }

    @POST
    @Path("{login}")
    public void getPerson(@PathParam("login") String login) {
        personDao.readPerson(login);
    }
}