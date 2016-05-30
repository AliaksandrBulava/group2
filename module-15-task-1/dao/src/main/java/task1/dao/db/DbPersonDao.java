package task1.dao.db;

import task1.dao.PersonDao;
import task1.domain.Person;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kiryl_Parfiankou on 12/15/2015.
 */
public class DbPersonDao extends AbstractDbDao implements PersonDao {

    private final String CONNECTION_URL = "jdbc:derby:memory:persons;create=true";
    private final String CREATE_SCRIPT = "CREATE TABLE persons"
                                          + " (lastName VARCHAR(255),"
                                          + " firstName VARCHAR(255),"
                                          + " login VARCHAR(255),"
                                          + " email VARCHAR(255),"
                                          + " age INT,"
                                          + " gender VARCHAR(255))";
    public DbPersonDao() {

        Statement statement = null;
        Connection connection = null;

        try {
            DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
            connection = DriverManager.getConnection(CONNECTION_URL);
            statement = connection.createStatement();
            statement.executeUpdate(CREATE_SCRIPT);

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(statement);
            close(connection);
        }
    }


    public void writePerson(Person person) {

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DriverManager.getConnection(CONNECTION_URL);
            ps = connection.prepareStatement("INSERT INTO persons VALUES(?,?,?,?,?,?)");

            ps.setString(1, person.getLastName());
            ps.setString(2, person.getFirstName());
            ps.setString(3, person.getLogin());
            ps.setString(4, person.getEmail());
            ps.setInt(5, person.getAge());
            ps.setString(6, person.getGender());
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
            close(connection);
        }

    }

    public List<Person> readPersons() {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        List<Person> persons = null;

        try {
            connection = DriverManager.getConnection(CONNECTION_URL);
            ps = connection.prepareStatement("SELECT * FROM persons");
            result =  ps.executeQuery();
            persons = new ArrayList<Person>();
            while (result.next()) {
                persons.add(new Person(
                        result.getString("lastName"),
                        result.getString("firstName"),
                        result.getString("login"),
                        result.getString("email"),
                        result.getInt("age"),
                        result.getString("gender")
                ));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(result);
            close(ps);
            close(connection);
        }

        return persons;
    }

    public void updatePerson(Person person) {

        Connection connection = null;
        PreparedStatement ps = null;

        try {
            connection = DriverManager.getConnection(CONNECTION_URL);
            ps = connection.prepareStatement("UPDATE persons SET lastName=?," +
                                                                "firstName=?," +
                                                                "email=?," +
                                                                "age=?," +
                                                                "gender=? WHERE login=?");

            ps.setString(1, person.getLastName());
            ps.setString(2, person.getFirstName());
            ps.setString(3, person.getEmail());
            ps.setInt(4, person.getAge());
            ps.setString(5, person.getGender());
            ps.setString(6, person.getLogin());
            ps.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(ps);
            close(connection);
        }
    }

    public Person readPerson(String login) {

        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        Person person = null;

        try {
            connection = DriverManager.getConnection(CONNECTION_URL);
            ps = connection.prepareStatement("SELECT * FROM persons WHERE login = ?");
            ps.setString(1, login);
            result = ps.executeQuery();


            if (result.next()) {
                person = new Person(
                            result.getString("lastName"),
                            result.getString("firstName"),
                            result.getString("login"),
                            result.getString("email"),
                            result.getInt("age"),
                            result.getString("gender")
                );
            }


        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(result);
            close(ps);
            close(connection);
        }

        return person;
    }

    public void deletePerson(String login) {
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet result = null;
        Person person = null;

        try {
            connection = DriverManager.getConnection(CONNECTION_URL);
            ps = connection.prepareStatement("DELETE FROM persons WHERE login = ?");
            ps.setString(1, login);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            close(result);
            close(ps);
            close(connection);
        }
    }
}
