package com.practice.architectureforandroidapp;

import com.practice.architectureforandroidapp.chapter2.DaggerMyComponent;
import com.practice.architectureforandroidapp.chapter2.DaggerMyComponent2;
import com.practice.architectureforandroidapp.chapter2.DaggerMyComponent3;
import com.practice.architectureforandroidapp.chapter2.ModuleInstance;
import com.practice.architectureforandroidapp.chapter2.MyClass;
import com.practice.architectureforandroidapp.chapter2.MyComponent;
import com.practice.architectureforandroidapp.chapter2.MyComponent2;
import com.practice.architectureforandroidapp.chapter2.MyComponent3;

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
        MyComponent myComponent = DaggerMyComponent.builder().myModule(new ModuleInstance()).build();
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
        MyComponent3 myComponent3 = DaggerMyComponent3.create();
//        myComponent3.inject(myClass);
        MembersInjector<MyClass> injector = myComponent3.getInjector();
        injector.injectMembers(myClass);
        str = myClass.getStr();
        assertEquals("KDY", str);
    }
}