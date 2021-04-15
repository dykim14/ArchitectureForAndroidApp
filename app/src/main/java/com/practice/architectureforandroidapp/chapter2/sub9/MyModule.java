package com.practice.architectureforandroidapp.chapter2.sub9;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {

    @Provides
//    @Named("hello")
    @Hello
    String provideHello() {
        return "Hello";
    }

    @Provides
//    @Named("world")
    String provideWorld() {
        return "World";
    }
}
