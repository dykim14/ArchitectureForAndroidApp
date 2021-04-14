package com.practice.architectureforandroidapp.chapter2;

import androidx.annotation.Nullable;

import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponent {
    String getString();
    @Nullable
    Integer getInteger();
}
