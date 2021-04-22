package com.practice.architectureforandroidapp.chapter2.sub14.contribute;

import javax.inject.Singleton;

import dagger.Component;
import dagger.android.AndroidInjectionModule;
import dagger.android.AndroidInjector;

@Component(modules = {AndroidInjectionModule.class, AppModule.class})
@Singleton
public interface AppComponent extends AndroidInjector<App> {

    @Component.Factory
    interface Factory extends AndroidInjector.Factory<App> {
    }
}
