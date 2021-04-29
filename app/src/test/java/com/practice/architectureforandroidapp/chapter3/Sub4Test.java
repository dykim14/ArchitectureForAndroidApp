package com.practice.architectureforandroidapp.chapter3;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Sub4Test {

    @Test
    public void testSchedulerDefinition() {
        Scheduler io = Schedulers.io();
        Scheduler computation = Schedulers.computation();
        Scheduler trampoline = Schedulers.trampoline();
        Scheduler newThread = Schedulers.newThread();
        Scheduler mainThread = AndroidSchedulers.mainThread();
    }

    @Test
    public void testMainThread() {
        Observable<Integer> src = Observable.create(emitter -> {
            for (int i = 0; i < 3; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.println("#Subs on " + threadName + ": " + i);
                emitter.onNext(i);
                Thread.sleep(100);
            }
            emitter.onComplete();
        });
        src.subscribe(s -> {
            String threadName = Thread.currentThread().getName();
            System.out.println("#Obsv on " + threadName + ": " + s);
        });
    }

    @Test
    public void testSubscribeOn() throws InterruptedException {
        Observable<Integer> src = Observable.create(emitter -> {
            for (int i = 0; i < 3; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.println("#Subs on " + threadName + ": " + i);
                emitter.onNext(i);
                Thread.sleep(100);
            }
            emitter.onComplete();
        });
        src.subscribeOn(Schedulers.io())
                .subscribe(s -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("#Obsv on " + threadName + ": " + s);
                });
        Thread.sleep(500);
    }

    @Test
    public void testObserveOn() throws InterruptedException {
        Observable<Integer> src = Observable.create(emitter -> {
            for (int i = 0; i < 3; i++) {
                String threadName = Thread.currentThread().getName();
                System.out.println("#Subs on " + threadName + ": " + i);
                emitter.onNext(i);
                Thread.sleep(100);
            }
            emitter.onComplete();
        });
        src.observeOn(Schedulers.computation())
                .subscribeOn(Schedulers.io())
                .subscribe(s -> {
                    String threadName = Thread.currentThread().getName();
                    System.out.println("#Obsv on " + threadName + ": " + s);
                });
        Thread.sleep(500);
    }

    @Test
    public void testFixedScheduler() throws InterruptedException {
        Observable.interval(200, TimeUnit.MILLISECONDS)
                .subscribeOn(Schedulers.io())
                .subscribe(value -> System.out.println(Thread.currentThread().getName() + ": " + value));
        Thread.sleep(1000);
    }
}
