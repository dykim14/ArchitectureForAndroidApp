package com.practice.architectureforandroidapp.chapter3;

import org.junit.Test;

import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;

public class Sub1Test {

    @Test
    public void reactive_programming() {
        ReplaySubject<Integer> items = ReplaySubject.create();
//        PublishSubject<Integer> items = PublishSubject.create();
        items.onNext(1);
        items.onNext(2);
        items.onNext(3);
        items.onNext(4);
        items.filter(item -> item % 2 == 0)
                .subscribe(System.out::println);
        items.onNext(5);
        items.onNext(6);
        items.onNext(7);
        items.onNext(8);
    }
}
