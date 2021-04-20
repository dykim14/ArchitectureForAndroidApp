package com.practice.architectureforandroidapp.chapter2.sub13;

public class Machine {
    private MachineComponent component;
    public Machine(MachineComponent.Builder builder) {
        component = builder.setMachineModule(new MachineModule()).build();
        component.inject(this);
    }

    public Coffee extract() {
        return component.getCoffee();
    }
}
