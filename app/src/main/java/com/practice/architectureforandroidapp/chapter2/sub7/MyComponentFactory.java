package com.practice.architectureforandroidapp.chapter2.sub7;

import androidx.annotation.Nullable;

import com.practice.architectureforandroidapp.chapter2.MyModule;

import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponentFactory {
    String getString();

    @Nullable
    Integer getInteger();

    @Component.Factory
    interface Factory {
        MyComponentFactory newMyComponentFactory(MyModule myModule);
    }
}
