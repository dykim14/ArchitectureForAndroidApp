package com.practice.architectureforandroidapp.chapter2.sub9;

import javax.inject.Inject;
import javax.inject.Named;

public class MyClass {
    @Inject
//    @Named("hello")
    @Hello
    String strHello;

    @Inject
//    @Named("world")
    String strWorld;

    public String getStrHello() {
        return strHello;
    }

    public String getStrWorld() {
        return strWorld;
    }
}
