package com.practice.architectureforandroidapp.chapter2.sub12;

import java.util.Iterator;
import java.util.Set;

import javax.inject.Inject;

public class Foo {
    @Inject
    Set<String> strings;

    public void print() {
        for (Iterator<String> itr = strings.iterator(); itr.hasNext();) {
            System.out.println(itr.next());
        }
    }
}
