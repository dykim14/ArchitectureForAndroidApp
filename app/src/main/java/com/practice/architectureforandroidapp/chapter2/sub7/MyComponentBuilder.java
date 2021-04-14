package com.practice.architectureforandroidapp.chapter2.sub7;

import androidx.annotation.Nullable;

import com.practice.architectureforandroidapp.chapter2.MyModule;

import dagger.Component;

@Component(modules = MyModule.class)
public interface MyComponentBuilder {
    String getString();
    @Nullable
    Integer getInteger();

    @Component.Builder
    interface Builder {
        Builder myModule(MyModule myModule);
        MyComponentBuilder build();
    }
}
