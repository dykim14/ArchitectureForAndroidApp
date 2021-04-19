package com.practice.architectureforandroidapp.chapter2.sub12;

import java.util.Map;

import dagger.Component;

@Component(modules = MapModule2.class)
public interface MapKeyComponent {
    Map<Animal, String> getStringsByAnimal();
    Map<Class<? extends Number>, String> getStringsByNumber();
}
