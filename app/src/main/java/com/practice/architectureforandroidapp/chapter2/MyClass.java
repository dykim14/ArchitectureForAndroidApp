package com.practice.architectureforandroidapp.chapter2;

import javax.inject.Inject;

public class MyClass {
    @Inject
    String str;

    public String getStr() {
        return str;
    }
}
