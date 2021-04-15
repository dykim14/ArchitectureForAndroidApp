package com.practice.architectureforandroidapp.chapter2.sub10;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {

    @Singleton
//    @UserScope
    @Provides
    Object provideObject() {
        return new Object();
    }
}
