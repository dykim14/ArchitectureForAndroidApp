package com.practice.architectureforandroidapp.chapter2.sub12;

import dagger.MapKey;

@MapKey
public @interface AnimalKey {
    Animal value();
}
