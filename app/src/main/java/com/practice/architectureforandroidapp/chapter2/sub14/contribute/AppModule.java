package com.practice.architectureforandroidapp.chapter2.sub14.contribute;

import com.practice.architectureforandroidapp.chapter2.sub14.ActivityScope;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class AppModule {

    @Named("app")
    @Provides
    @Singleton
    static String provideString() {
        return "String from AppModule";
    }

    @ActivityScope
    @ContributesAndroidInjector(modules = MainActivityModule.class)
    abstract MainActivity mainActivity();
}
