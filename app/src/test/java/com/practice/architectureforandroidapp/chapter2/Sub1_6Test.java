package com.practice.architectureforandroidapp.chapter2;

import com.practice.architectureforandroidapp.chapter2.sub1_6.DaggerMyComponent;
import com.practice.architectureforandroidapp.chapter2.sub1_6.DaggerMyComponent2;
import com.practice.architectureforandroidapp.chapter2.sub1_6.MyComponent;
import com.practice.architectureforandroidapp.chapter2.sub1_6.ModuleInstance;
import com.practice.architectureforandroidapp.chapter2.sub1_6.MyComponent2;
import com.practice.architectureforandroidapp.chapter2.sub1_6.Person;

import org.junit.Test;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class Sub1_6Test {
    @Test
    public void testHelloWorld() {
        MyComponent myComponent = DaggerMyComponent.create();
        System.out.println("result=" + myComponent.getString());
    }

    @Test
    public void testPerson() {
        MyComponent myComponent = DaggerMyComponent.create();
        System.out.println("name = " + myComponent.getPerson().name);
        System.out.println("age = " + myComponent.getPerson().age);
        Person a = new Person("BBB", 999);
//        Person a = new Person();
        System.out.println("name = " + a.name);
        System.out.println("age = " + a.age);
        myComponent.inject(a);
        System.out.println("name = " + a.name);
        System.out.println("age = " + a.age);
    }

    @Test
    public void testModuleInstance() {
        MyComponent myComponent = DaggerMyComponent.builder().myModule(new ModuleInstance()).build();
        System.out.println("result=" + myComponent.getString());
    }

    @Test
    public void testMyModule2() {
        MyComponent2 myComponent = DaggerMyComponent2.create();
        System.out.println("result=" + myComponent.getString() + " " + myComponent.getInteger() + " " + myComponent.getLong());
    }
}