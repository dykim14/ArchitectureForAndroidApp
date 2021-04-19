package com.practice.architectureforandroidapp.chapter2.sub12;

import dagger.Component;

@Component(modules = SetModule.class)
public interface SetComponent {
    void inject(Foo foo);
}
