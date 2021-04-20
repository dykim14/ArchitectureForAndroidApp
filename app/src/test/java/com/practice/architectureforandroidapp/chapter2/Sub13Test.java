package com.practice.architectureforandroidapp.chapter2;

import com.practice.architectureforandroidapp.chapter2.sub13.Cafe;
import com.practice.architectureforandroidapp.chapter2.sub13.ComponentB;
import com.practice.architectureforandroidapp.chapter2.sub13.DaggerComponentA;
import com.practice.architectureforandroidapp.chapter2.sub13.DaggerComponentB;
import com.practice.architectureforandroidapp.chapter2.sub13.Foo;

import org.junit.Test;

public class Sub13Test {
    @Test
    public void testCafe() {
        Cafe cafe = new Cafe();
        System.out.println(cafe.orderCoffee());
        System.out.println(cafe.orderCoffee());
        System.out.println(cafe.orderCoffee());
    }

    @Test
    public void testDependency() {
        ComponentB componentB = DaggerComponentB.builder()
                .componentA(DaggerComponentA.create())
                .build();
        Foo foo = new Foo();
        componentB.inject(foo);

        System.out.println(foo.str);
        System.out.println(foo.integer);
    }
}
