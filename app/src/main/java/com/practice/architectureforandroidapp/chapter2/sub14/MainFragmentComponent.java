package com.practice.architectureforandroidapp.chapter2.sub14;

import android.app.Activity;

import dagger.BindsInstance;
import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = MainFragmentModuleBefore.class)
public interface MainFragmentComponent {
    void inject(MainFragmentBefore mainFragment);
    void inject(Activity activity);

    @Subcomponent.Builder
    interface Builder {
        Builder setModule(MainFragmentModuleBefore module);
        @BindsInstance
        Builder setFragment(MainFragmentBefore fragment);
        @BindsInstance
        Builder setActivity(Activity activity);
        MainFragmentComponent build();
    }
}
