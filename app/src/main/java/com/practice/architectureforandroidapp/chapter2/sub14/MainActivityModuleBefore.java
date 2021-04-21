package com.practice.architectureforandroidapp.chapter2.sub14;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = MainFragmentComponent.class)
public class MainActivityModuleBefore {
    @Provides
    @ActivityScope
    String provideActivityName() {
        return MainActivity.class.getSimpleName();
    }
}
