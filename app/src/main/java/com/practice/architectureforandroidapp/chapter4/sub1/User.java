package com.practice.architectureforandroidapp.chapter4.sub1;

public class User {

    private final String firstName;
    private final String lastName;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public User(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }
}
