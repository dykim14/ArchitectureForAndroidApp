package com.practice.architectureforandroidapp.chapter2.sub14;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;

@Component(modules = AppModule.class)
@Singleton
public interface AppComponent {
    MainActivityComponent.Builder mainActivityComponentBuilder();
    void inject(App app);

    @Component.Factory
    interface Factory {
        AppComponent create(
                @BindsInstance App app,
                AppModule appModule
        );
    }
}
