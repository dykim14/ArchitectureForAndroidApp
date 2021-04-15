package com.practice.architectureforandroidapp.chapter2.sub1_6;

import dagger.Module;
import dagger.Provides;

@Module(includes = MyModule.class)
public class MyModule2 {

    @Provides
    long getLong() {
        return 100L;
    }
}
