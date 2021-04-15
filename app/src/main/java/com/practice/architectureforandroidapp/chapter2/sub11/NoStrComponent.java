package com.practice.architectureforandroidapp.chapter2.sub11;

import dagger.Component;

@Component(modules = CommonModule.class)
public interface NoStrComponent {
    void inject(Foo foo);
}
