package com.practice.architectureforandroidapp.chapter2.sub14;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = AppModuleBefore.class)
@Singleton
public interface AppComponentBefore {
    MainActivityComponent.Builder mainActivityComponentBuilder();
    void inject(AppBefore app);

    @Component.Factory
    interface Factory {
        AppComponentBefore create(
                @BindsInstance AppBefore app,
                AppModuleBefore appModule
        );
    }
}
