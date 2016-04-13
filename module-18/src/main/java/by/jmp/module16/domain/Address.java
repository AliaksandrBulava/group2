package by.jmp.module16.domain;

import javax.persistence.Embeddable;

/**
 * Created by Kiryl_Parfiankou on 4/3/2016.
 */
@Embeddable
public class Address {

    public Address() {

    }
    public String country;
    public String city;
    public String street;
    public String number;
    public int postcode;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getPostcode() {
        return postcode;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }
}
