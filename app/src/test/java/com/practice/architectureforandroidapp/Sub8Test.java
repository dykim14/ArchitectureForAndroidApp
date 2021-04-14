package com.practice.architectureforandroidapp;

import com.practice.architectureforandroidapp.chapter2.sub8.Counter;
import com.practice.architectureforandroidapp.chapter2.sub8.CounterComponent;
import com.practice.architectureforandroidapp.chapter2.sub8.DaggerCounterComponent;

import org.junit.Test;

public class Sub8Test {

    @Test
    public void testLazy() {
        CounterComponent counterComponent = DaggerCounterComponent.create();
        Counter counter = new Counter();
        counterComponent.inject(counter);
        counter.printLazy();
    }

    @Test
    public void testProvider() {
        CounterComponent counterComponent = DaggerCounterComponent.create();
        Counter counter = new Counter();
        counterComponent.inject(counter);
        counter.printProvider();
    }
}
