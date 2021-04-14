package com.practice.architectureforandroidapp.chapter2;

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
