package de.codecentric.eater.domain;

import org.springframework.util.StringUtils;

import java.util.Date;
import java.util.regex.Pattern;

public class EaterProfile {

    private Integer id;
    private String email;
    private String firstname;
    private String lastname;
    private String street;
    private String city;
    private Date birthday;

    public boolean isEmailValid() {
        if (StringUtils.isEmpty(email)) {
            return true;
        }
        Pattern emailPattern = Pattern.compile("^(.+)@([^@]+[^.])$");
        return emailPattern.matcher(email).matches();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
