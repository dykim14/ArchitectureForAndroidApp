package com.practice.architectureforandroidapp.chapter2.sub11;

import dagger.Module;
import dagger.Provides;

@Module
public class HelloModule {
    @Provides
    String provideString() {
        return "Hello";
    }
}
