package com.practice.architectureforandroidapp.chapter2.sub13;

import dagger.Module;
import dagger.Provides;

@Module
public class MachineModule {
    @Provides
    CoffeeBean provideCoffeeBean() {
        return new CoffeeBean();
    }
}
