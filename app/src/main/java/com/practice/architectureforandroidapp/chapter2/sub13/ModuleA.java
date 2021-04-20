package com.practice.architectureforandroidapp.chapter2.sub13;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleA {
    @Provides
    String provideString() {
        return "String from ModuleA";
    }
}
