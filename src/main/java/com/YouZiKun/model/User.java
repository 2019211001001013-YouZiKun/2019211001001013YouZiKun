package com.YouZiKun.model;

import java.util.Date;

public class User {
    private String username;
    private String password;
    private String email;
    private String gender;
    private String birthdate;
    //constructor

    //default
    public User() {

    }
    //full

    public User(String username, String password, String email, String gender, String birthdate) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.birthdate = birthdate;
    }

    //getter and setter

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    //toString

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }
}
