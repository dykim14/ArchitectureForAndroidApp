package com.practice.architectureforandroidapp.chapter2.sub12;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.IntoSet;

@Module
public class ChildModule {
    @Provides
    @IntoSet
    String string3() {
        return "child string 1";
    }

    @Provides
    @IntoSet
    String string4() {
        return "child string 2";
    }
}
