package com.practice.architectureforandroidapp.chapter2.sub12;

import java.util.Set;

import dagger.Component;

@Component(modules = ParentModule.class)
public interface ParentComponent {
    Set<String> strings();
    ChildComponent.Builder childCompBuilder();
}
