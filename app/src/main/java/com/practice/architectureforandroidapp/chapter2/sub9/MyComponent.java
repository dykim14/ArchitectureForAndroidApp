package com.practice.architectureforandroidapp.chapter2.sub9;

import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponent {
    void inject(MyClass myClass);
}
