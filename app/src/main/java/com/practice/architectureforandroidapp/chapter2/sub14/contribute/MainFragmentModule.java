package com.practice.architectureforandroidapp.chapter2.sub14.contribute;

import com.practice.architectureforandroidapp.chapter2.sub14.FragmentScope;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;

@Module
public class MainFragmentModule {

    @Named("fragment")
    @Provides
    @FragmentScope
    String provideString() {
        return "String from fragment";
    }
}
