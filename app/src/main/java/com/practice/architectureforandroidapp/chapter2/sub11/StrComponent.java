package com.practice.architectureforandroidapp.chapter2.sub11;

import dagger.Component;

@Component(modules = {CommonModule.class, HelloModule.class})
//@Component(modules = HelloModule.class)
public interface StrComponent {
    void inject(Foo foo);
}
