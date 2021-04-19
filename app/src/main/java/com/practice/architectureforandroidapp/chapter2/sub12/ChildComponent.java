package com.practice.architectureforandroidapp.chapter2.sub12;

import java.util.Set;

import dagger.Subcomponent;

@Subcomponent(modules = ChildModule.class)
public interface ChildComponent {
    Set<String> strings();

    @Subcomponent.Builder
    interface Builder {
        ChildComponent build();
    }
}
