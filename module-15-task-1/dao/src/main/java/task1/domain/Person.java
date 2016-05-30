package task1.domain;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Kiryl_Parfiankou on 12/14/2015.
 */
@XmlRootElement
public class Person {

    private String lastName;
    private String firstName;
    private String login;
    private String email;
    private int age;
    private String gender;

    public Person(String lastName, String firstName, String login, String email, int age, String gender) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.login = login;
        this.email = email;
        this.age = age;
        this.gender = gender;
    }

    public Person() {
    }

    @Override
    public String toString() {
        return lastName + ',' + age + ',' + gender;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
