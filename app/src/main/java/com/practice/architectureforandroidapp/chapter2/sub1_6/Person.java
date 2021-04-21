package com.practice.architectureforandroidapp.chapter2.sub1_6;

import javax.inject.Inject;

public class Person {

    @Inject
    public String name;
    public int age;

    public Person() {}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Inject
    public void setAge(int age) {
        this.age = age;
    }
}
