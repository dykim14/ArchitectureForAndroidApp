package com.practice.architectureforandroidapp.chapter2.sub7;

import javax.inject.Inject;

public class PersonA {

    private String name;
    private int age;

    @Inject
    PersonA(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}
