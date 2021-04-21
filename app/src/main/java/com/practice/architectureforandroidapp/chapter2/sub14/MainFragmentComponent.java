package com.practice.architectureforandroidapp.chapter2.sub14;

import android.app.Activity;

import dagger.BindsInstance;
import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = MainFragmentModule.class)
public interface MainFragmentComponent {
    void inject(MainFragment mainFragment);
    void inject(Activity activity);

    @Subcomponent.Builder
    interface Builder {
        Builder setModule(MainFragmentModule module);
        @BindsInstance
        Builder setFragment(MainFragment fragment);
        @BindsInstance
        Builder setActivity(Activity activity);
        MainFragmentComponent build();
    }
}
