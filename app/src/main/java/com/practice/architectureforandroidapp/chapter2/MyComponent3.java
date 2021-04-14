package com.practice.architectureforandroidapp.chapter2;

import dagger.Component;
import dagger.MembersInjector;

@Component(modules = MyModule.class)
public interface MyComponent3 {
   void inject(MyClass myClass);

   MembersInjector<MyClass> getInjector();
}
