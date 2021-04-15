package com.practice.architectureforandroidapp.chapter2.sub1_6;

import androidx.annotation.Nullable;

public class ModuleInstance extends MyModule {

    @Override
    String provideName() {
        return "KJH";
    }

    @Nullable
    @Override
    Integer provideInteger() {
        return 2;
    }
}
