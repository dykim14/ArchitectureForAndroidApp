package com.practice.architectureforandroidapp.chapter2.sub12;

import java.util.Set;

import dagger.Component;

@Component(modules = MultibindsModules.class)
public interface MultibindsComponent {
    Set<String> getStrings();
}
