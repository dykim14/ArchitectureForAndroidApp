package com.practice.architectureforandroidapp.chapter2.sub10;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = MyModule.class)
public interface MyComponent {
    Object getObject();
}
