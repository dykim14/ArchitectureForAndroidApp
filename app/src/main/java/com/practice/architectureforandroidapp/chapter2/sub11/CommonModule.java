package com.practice.architectureforandroidapp.chapter2.sub11;

import dagger.BindsOptionalOf;
import dagger.Module;

@Module
public abstract class CommonModule {
    @BindsOptionalOf
    abstract String bindsOptionalOfString();
}
