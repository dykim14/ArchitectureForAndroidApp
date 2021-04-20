package com.practice.architectureforandroidapp.chapter2.sub14;

import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module(subcomponents = MainActivityComponent.class)
public class AppModule {

    @Provides
    @Singleton
    SharedPreferences provideSharedPreferences(App app) {
        return app.getSharedPreferences("default", Context.MODE_PRIVATE);
    }
}