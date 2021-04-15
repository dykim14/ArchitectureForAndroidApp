package com.practice.architectureforandroidapp.chapter2;

import com.practice.architectureforandroidapp.chapter2.sub11.BindsComponent;
import com.practice.architectureforandroidapp.chapter2.sub11.DaggerBindsComponent;
import com.practice.architectureforandroidapp.chapter2.sub11.DaggerNoStrComponent;
import com.practice.architectureforandroidapp.chapter2.sub11.DaggerStrComponent;
import com.practice.architectureforandroidapp.chapter2.sub11.Foo;
import com.practice.architectureforandroidapp.chapter2.sub11.Foo2;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Sub11Test {

    @Test
    public void testFoo() {
        Foo foo = new Foo();

        DaggerStrComponent.create().inject(foo);
        System.out.println(foo.str.isPresent());
        System.out.println(foo.str.get());

        DaggerNoStrComponent.create().inject(foo);
        System.out.println(foo.str.isPresent());
        System.out.println(foo.str.get());
    }

    @Test
    public void testBindsInstance() {
        String hello = "Hello World";
        Foo2 foo = new Foo2();
        BindsComponent component = DaggerBindsComponent.builder()
                .setString(hello)
                .build();
        component.inject(foo);
        assertEquals("Hello World", foo.str);
    }
}
