package com.practice.architectureforandroidapp.chapter2.sub8;

import dagger.Component;

@Component(modules = CounterModule.class)
public interface CounterComponent {
    void inject(Counter counter);
}
