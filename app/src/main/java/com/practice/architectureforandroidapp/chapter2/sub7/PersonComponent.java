package com.practice.architectureforandroidapp.chapter2.sub7;

import dagger.Component;

@Component(modules = PersonModule.class)
public interface PersonComponent {
    PersonA getPersonA();
    void inject(PersonB personB);
}
