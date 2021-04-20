package com.practice.architectureforandroidapp.chapter2.sub13;

import dagger.Component;

@Component(modules = ModuleA.class)
public interface ComponentA {
    String provideString();
}
