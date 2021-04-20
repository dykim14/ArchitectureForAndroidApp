package com.practice.architectureforandroidapp.chapter2;

import com.practice.architectureforandroidapp.chapter2.sub12.Animal;
import com.practice.architectureforandroidapp.chapter2.sub12.ChildComponent;
import com.practice.architectureforandroidapp.chapter2.sub12.DaggerMapComponent;
import com.practice.architectureforandroidapp.chapter2.sub12.DaggerMapKeyComponent;
import com.practice.architectureforandroidapp.chapter2.sub12.DaggerMultibindsComponent;
import com.practice.architectureforandroidapp.chapter2.sub12.DaggerParentComponent;
import com.practice.architectureforandroidapp.chapter2.sub12.DaggerSetComponent;
import com.practice.architectureforandroidapp.chapter2.sub12.Foo;
import com.practice.architectureforandroidapp.chapter2.sub12.Foo2;
import com.practice.architectureforandroidapp.chapter2.sub12.MapComponent;
import com.practice.architectureforandroidapp.chapter2.sub12.MapKeyComponent;
import com.practice.architectureforandroidapp.chapter2.sub12.MultibindsComponent;
import com.practice.architectureforandroidapp.chapter2.sub12.ParentComponent;
import com.practice.architectureforandroidapp.chapter2.sub12.SetComponent;

import org.junit.Test;

import java.util.Iterator;

public class Sub12Test {
    @Test
    public void testMultibindingSet() {
        Foo foo = new Foo();
        SetComponent setComponent = DaggerSetComponent.create();
        setComponent.inject(foo);
        foo.print();
    }

    @Test
    public void testMultibindingMap() {
        MapComponent component = DaggerMapComponent.create();
        long value = component.getLongsByString().get("foo");
        String srt = component.getStringsByClass().get(Foo2.class);

        System.out.println(value);
        System.out.println(srt);
    }

    @Test
    public void testCustomMapKey() {
        MapKeyComponent component = DaggerMapKeyComponent.create();
        String cat = component.getStringsByAnimal().get(Animal.CAT);
        String dog = component.getStringsByAnimal().get(Animal.DOG);
        String number = component.getStringsByNumber().get(Float.class);
        System.out.println(cat);
        System.out.println(dog);
        System.out.println(number);
    }

    @Test
    public void testMultibindingWithSubcomponent() {
        ParentComponent parentComp = DaggerParentComponent.create();
        ChildComponent childComp = parentComp.childCompBuilder().build();

        System.out.println("List set in Parent");

        Iterator itr = parentComp.strings().iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }

        System.out.println("List set in Child");
        itr = childComp.strings().iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }

    @Test
    public void testMultibinds() {
        MultibindsComponent component = DaggerMultibindsComponent.create();

        for (String s : component.getStrings()) {
            System.out.println(s);
        }
    }
}
