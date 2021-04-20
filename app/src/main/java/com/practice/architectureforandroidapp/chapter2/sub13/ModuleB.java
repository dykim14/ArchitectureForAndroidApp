package com.practice.architectureforandroidapp.chapter2.sub13;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleB {
    @Provides
    Integer provideInteger() {
        return 100;
    }
}
