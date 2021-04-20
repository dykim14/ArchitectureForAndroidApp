package com.practice.architectureforandroidapp.chapter2.sub13;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = MachineComponent.class)
public class CafeModule {

    @Provides
    Water provideWater() {
        return new Water();
    }

    @Provides
    Machine provideMachine(MachineComponent.Builder builder) {
        return new Machine(builder);
    }
}
