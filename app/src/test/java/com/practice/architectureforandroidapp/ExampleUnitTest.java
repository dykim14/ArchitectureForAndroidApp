package com.practice.architectureforandroidapp;

import com.practice.architectureforandroidapp.chapter2.DaggerMyComponent;
import com.practice.architectureforandroidapp.chapter2.DaggerMyComponent2;
import com.practice.architectureforandroidapp.chapter2.MyComponent;
import com.practice.architectureforandroidapp.chapter2.sub7.DaggerPersonComponent;
import com.practice.architectureforandroidapp.chapter2.ModuleInstance;
import com.practice.architectureforandroidapp.chapter2.sub7.MyClass;
import com.practice.architectureforandroidapp.chapter2.MyComponent2;
import com.practice.architectureforandroidapp.chapter2.sub7.PersonA;
import com.practice.architectureforandroidapp.chapter2.sub7.PersonB;
import com.practice.architectureforandroidapp.chapter2.sub7.PersonComponent;

import org.junit.Test;

import dagger.MembersInjector;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void testHelloWorld() {
        MyComponent myComponent = DaggerMyComponent.create();
        System.out.println("result=" + myComponent.getString());
    }

    @Test
    public void testModuleInstance() {
        com.practice.architectureforandroidapp.chapter2.MyComponent myComponent = DaggerMyComponent.builder().myModule(new ModuleInstance()).build();
        System.out.println("result=" + myComponent.getString());
    }

    @Test
    public void testMyModule2() {
        MyComponent2 myComponent = DaggerMyComponent2.create();
        System.out.println("result=" + myComponent.getString() + " " + myComponent.getInteger() + " " + myComponent.getLong());
    }

    @Test
    public void testMemberInjection() {
        MyClass myClass = new MyClass();
        String str = myClass.getStr();
//        assertNotNull("조회 결과 null", str);
        com.practice.architectureforandroidapp.chapter2.sub7.MyComponent myComponent3 = com.practice.architectureforandroidapp.chapter2.sub7.DaggerMyComponent.create();
//        myComponent3.inject(myClass);
        MembersInjector<MyClass> injector = myComponent3.getInjector();
        injector.injectMembers(myClass);
        str = myClass.getStr();
        assertEquals("KDY", str);
    }

    @Test
    public void testInjection() {
        PersonComponent personComponent = DaggerPersonComponent.create();
        PersonA personA = personComponent.getPersonA();
        System.out.println(personA.getName() + ":" + personA.getAge());

        PersonB personB = new PersonB();
        personComponent.inject(personB);
        System.out.println(personB.getName() + ":" + personB.getAge());
    }

}