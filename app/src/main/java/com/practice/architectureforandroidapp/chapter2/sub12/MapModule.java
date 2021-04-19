package com.practice.architectureforandroidapp.chapter2.sub12;

import dagger.Module;
import dagger.Provides;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;
import dagger.multibindings.StringKey;

@Module
public class MapModule {

    @Provides
    @IntoMap
    @StringKey("foo")
    Long provideFooValue() {
        return 100L;
    }

    @Provides
    @IntoMap
    @ClassKey(Foo2.class)
    static String provideFooStr() {
        return "Foo String";
    }
}
