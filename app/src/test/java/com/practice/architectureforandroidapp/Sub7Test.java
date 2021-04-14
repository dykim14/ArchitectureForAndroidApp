package com.practice.architectureforandroidapp;

import com.practice.architectureforandroidapp.chapter2.sub7.DaggerMyComponent;
import com.practice.architectureforandroidapp.chapter2.sub7.DaggerPersonComponent;
import com.practice.architectureforandroidapp.chapter2.sub7.MyClass;
import com.practice.architectureforandroidapp.chapter2.sub7.MyComponent;
import com.practice.architectureforandroidapp.chapter2.sub7.PersonA;
import com.practice.architectureforandroidapp.chapter2.sub7.PersonB;
import com.practice.architectureforandroidapp.chapter2.sub7.PersonComponent;

import org.junit.Test;

import dagger.MembersInjector;

import static org.junit.Assert.assertEquals;

public class Sub7Test {

    @Test
    public void testMemberInjection() {
        MyClass myClass = new MyClass();
        String str = myClass.getStr();
//        assertNotNull("조회 결과 null", str);
        MyComponent myComponent3 = DaggerMyComponent.create();
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
