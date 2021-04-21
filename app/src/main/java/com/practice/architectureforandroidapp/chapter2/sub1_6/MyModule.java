package com.practice.architectureforandroidapp.chapter2.sub1_6;

import androidx.annotation.Nullable;

import java.lang.reflect.Member;

import dagger.MembersInjector;
import dagger.Module;
import dagger.Provides;

@Module
public class MyModule {

//    @Provides
//    String provideHelloWorld() {
//        return "Hello World";
//    }
    @Provides
    String provideName() {
        return "KDY";
    }

    @Provides
    int providesAge() {
        return 1000;
    }

    @Provides
    Person providesPerson(String name, int age) {
        return new Person(name, age);
    }

//    @Nullable
//    @Provides
//    Integer provideInteger() {
//        return null;
//    }

}
