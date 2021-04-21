package com.practice.architectureforandroidapp.chapter2.sub14;

import dagger.BindsInstance;
import dagger.Subcomponent;

@Subcomponent(modules = MainActivityModuleBefore.class)
@ActivityScope
public interface MainActivityComponent {
    MainFragmentComponent.Builder mainFragmentComponentBuilder();

    void inject(MainActivityBefore activity);

    @Subcomponent.Builder
    interface Builder {
        Builder setModule(MainActivityModuleBefore module);
        @BindsInstance
        Builder setActivity(MainActivityBefore activity);
        MainActivityComponent build();
    }
}
