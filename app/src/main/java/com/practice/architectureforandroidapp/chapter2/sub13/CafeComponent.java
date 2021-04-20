package com.practice.architectureforandroidapp.chapter2.sub13;

import dagger.Component;

@Component(modules = CafeModule.class)
public interface CafeComponent {
    void inject(Cafe cafe);
}
