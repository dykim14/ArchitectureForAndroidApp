package com.practice.architectureforandroidapp.chapter2.sub12;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ElementsIntoSet;
import dagger.multibindings.Multibinds;

@Module
public abstract class MultibindsModules {
    @Multibinds
    abstract Set<String> strings();

//    @Provides
//    @ElementsIntoSet
//    static Set<String> emptyStrings() {
////        return Collections.emptySet();
//        Set<String> s = new HashSet<>();
//        s.add("JiHwan");
//        s.add("DaeYoung");
//        s.add("TaeEun");
//        return s;
//    }
}
