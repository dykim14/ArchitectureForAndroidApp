package com.practice.architectureforandroidapp.chapter3;

import org.junit.Test;
import org.reactivestreams.Subscriber;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.subjects.AsyncSubject;
import io.reactivex.rxjava3.subjects.BehaviorSubject;
import io.reactivex.rxjava3.subjects.PublishSubject;
import io.reactivex.rxjava3.subjects.ReplaySubject;
import io.reactivex.rxjava3.subjects.Subject;
import io.reactivex.rxjava3.subjects.UnicastSubject;

public class Sub6Test {

    @Test
    public void testPublishSubject() throws InterruptedException {
        Subject<String> src = PublishSubject.create();
        src.subscribe(item -> System.out.println("A: " + item),
                t -> t.printStackTrace(),
                () -> System.out.println("A: onComplete"));
        src.subscribe(item -> System.out.println("B: " + item),
                t -> t.printStackTrace(),
                () -> System.out.println("B: onComplete"));
        src.onNext("Hello");
        src.onNext("World");
        src.onNext("!!!");
        src.onComplete();
    }

    @Test
    public void testPublishSubjectIsHotObservable() throws InterruptedException {
        Subject<String> src = PublishSubject.create();
        src.onNext("Hello");
        src.onNext("World");
        src.onNext("!!!");
        src.subscribe(item -> System.out.println("A: " + item),
                t -> t.printStackTrace(),
                () -> System.out.println("A: onComplete"));
        src.subscribe(item -> System.out.println("B: " + item),
                t -> t.printStackTrace(),
                () -> System.out.println("B: onComplete"));
        src.onComplete();
    }

    @Test
    public void testSubjectAsObserver() throws InterruptedException {
        Observable src1 = Observable.interval(1, TimeUnit.SECONDS);
        Observable src2 = Observable.interval(500, TimeUnit.MILLISECONDS);
        PublishSubject subject = PublishSubject.create();

        src1.map(item -> "A: " + item).subscribe(subject);
        src2.map(item -> "B: " + item).subscribe(subject);
        subject.subscribe(System.out::println);
        Thread.sleep(5000);
    }

    @Test
    public void testSerializedSubject() throws InterruptedException {
        AtomicInteger counter = new AtomicInteger();
//        Subject<Object> subject = PublishSubject.create();
        Subject<Object> subject = PublishSubject.create().toSerialized();
        subject.doOnNext(i -> counter.incrementAndGet())
                .doOnNext(i -> counter.decrementAndGet())
                .filter(i -> counter.get() != 0)
                .subscribe(System.out::println, t -> t.printStackTrace());

        Runnable r = () -> {
            for (int i = 0; i < 100000; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                subject.onNext(i);
            }
        };
        new Thread(r).start();
        new Thread(r).start();
        Thread.sleep(1000);
        System.out.println("종료");
    }

    @Test
    public void testBehaviorSubject() throws InterruptedException {
        BehaviorSubject<Integer> subject = BehaviorSubject.create();
//        PublishSubject<Integer> subject = PublishSubject.create();
        subject.subscribe(item -> System.out.println("A: " + item));
        subject.onNext(1);
        subject.onNext(2);
        subject.subscribe(item -> System.out.println("B: " + item));
        subject.onNext(3);
        subject.subscribe(item -> System.out.println("C: " + item));
    }

    @Test
    public void testReplaySubject() throws InterruptedException {
        ReplaySubject<Integer> subject = ReplaySubject.create();
        subject.subscribe(item -> System.out.println("A: " + item));
        subject.onNext(1);
        subject.onNext(2);
        subject.subscribe(item -> System.out.println("B: " + item));
        subject.onNext(3);
        subject.subscribe(item -> System.out.println("C: " + item));
    }

    @Test
    public void testAsyncSubject() throws InterruptedException {
        AsyncSubject<Integer> subject = AsyncSubject.create();
        subject.subscribe(item -> System.out.println("A: " + item));
        subject.onNext(1);
        subject.onNext(2);
        subject.subscribe(item -> System.out.println("B: " + item));
        subject.onNext(3);
        subject.onComplete();
        subject.subscribe(item -> System.out.println("C: " + item));
    }

    @Test
    public void testUnicastSubject() throws InterruptedException {
        Subject<Long> subject = UnicastSubject.create();
        Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(subject);
        Thread.sleep(3000);
        subject.subscribe(i -> System.out.println("A: " + i));
        Thread.sleep(2000);
    }
}
