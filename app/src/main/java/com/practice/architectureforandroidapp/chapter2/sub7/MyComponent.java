package com.practice.architectureforandroidapp.chapter2.sub7;

import com.practice.architectureforandroidapp.chapter2.sub1_6.MyModule;

import dagger.Component;
import dagger.MembersInjector;

@Component(modules = MyModule.class)
public interface MyComponent {
   void inject(MyClass myClass);

   MembersInjector<MyClass> getInjector();
}
