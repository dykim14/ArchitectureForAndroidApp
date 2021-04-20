package com.practice.architectureforandroidapp.chapter2.sub13;

import dagger.Component;

@Component(
        modules = ModuleB.class,
        dependencies = ComponentA.class
)
public interface ComponentB {
    void inject(Foo foo);
}
