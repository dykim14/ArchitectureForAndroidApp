package com.practice.architectureforandroidapp.chapter2.sub14.contribute;

import com.practice.architectureforandroidapp.chapter2.sub14.ActivityScope;
import com.practice.architectureforandroidapp.chapter2.sub14.FragmentScope;
import com.practice.architectureforandroidapp.chapter2.sub14.MainFragment;
import com.practice.architectureforandroidapp.chapter2.sub14.MainFragmentModule;

import javax.inject.Named;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class MainActivityModule {

    @Named("activity")
    @Provides
    @ActivityScope
    static String provideString() {
        return "String from MainActivityModule";
    }

    @FragmentScope
    @ContributesAndroidInjector(modules = MainFragmentModule.class)
    abstract MainFragment mainFragment();
}
