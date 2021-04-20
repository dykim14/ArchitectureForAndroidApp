package com.practice.architectureforandroidapp.chapter2.sub13;

import javax.inject.Inject;

public class Cafe {
    @Inject
    Machine coffeeMachine;

    public Cafe() {
        CafeComponent component = DaggerCafeComponent.create();
        component.inject(this);
    }

    public Coffee orderCoffee() {
        return coffeeMachine.extract();
    }
}
