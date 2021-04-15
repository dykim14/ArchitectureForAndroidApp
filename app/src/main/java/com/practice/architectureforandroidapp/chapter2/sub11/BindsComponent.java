package com.practice.architectureforandroidapp.chapter2.sub11;

import dagger.BindsInstance;
import dagger.Component;

@Component
public interface BindsComponent {
    void inject(Foo2 foo);
    @Component.Builder
    interface Builder {
        @BindsInstance
        Builder setString(String str);
        BindsComponent build();
    }
}
