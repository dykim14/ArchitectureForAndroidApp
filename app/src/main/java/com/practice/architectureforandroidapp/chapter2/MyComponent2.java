package com.practice.architectureforandroidapp.chapter2;

import androidx.annotation.Nullable;

import dagger.Component;

@Component(modules = MyModule2.class)
public interface MyComponent2 {
    String getString();
    @Nullable
    Integer getInteger();
    long getLong();
}
