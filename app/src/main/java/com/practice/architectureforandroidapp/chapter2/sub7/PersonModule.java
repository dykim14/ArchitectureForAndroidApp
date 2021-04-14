package com.practice.architectureforandroidapp.chapter2.sub7;

import dagger.Module;
import dagger.Provides;

@Module
public class PersonModule {
    @Provides
    String provideName() {
        return "KDY";
    }

    @Provides
    int provideAge() {
        return 1000;
    }
}
