package com.practice.architectureforandroidapp;

import com.practice.architectureforandroidapp.chapter2.DaggerMyComponent;
import com.practice.architectureforandroidapp.chapter2.DaggerMyComponent2;
import com.practice.architectureforandroidapp.chapter2.MyComponent;
import com.practice.architectureforandroidapp.chapter2.ModuleInstance;
import com.practice.architectureforandroidapp.chapter2.MyComponent2;

import org.junit.Test;

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
}