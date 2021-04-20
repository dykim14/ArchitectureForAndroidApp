package com.practice.architectureforandroidapp.chapter2.sub14;

import dagger.BindsInstance;
import dagger.Subcomponent;

@FragmentScope
@Subcomponent(modules = MainFragmentModule.class)
public interface MainFragmentComponent {
    void inject(MainFragment mainFragment);

    @Subcomponent.Builder
    interface Builder {
        Builder setModule(MainFragmentModule module);
        @BindsInstance
        Builder setFragment(MainFragment fragment);
        MainFragmentComponent build();
    }
}
