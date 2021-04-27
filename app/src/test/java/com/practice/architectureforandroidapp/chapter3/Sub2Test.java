package com.practice.architectureforandroidapp.chapter3;

import org.junit.Test;
import org.reactivestreams.Publisher;

import java.sql.Time;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Maybe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.observables.ConnectableObservable;

public class Sub2Test {

    @Test
    public void observableCreateTest() {
        Observable<String> source = Observable.create(emitter -> {
            emitter.onNext("Hello");
            emitter.onError(new Throwable());
//            emitter.onComplete();
            emitter.onNext("World");
        });
        source.subscribe(System.out::println,
                throwable -> System.out.println("Error!!"));
    }

    @Test
    public void justTest() {
        Observable<String> source = Observable.just("Hello", "World");
        source.subscribe(System.out::println);
    }

    @Test
    public void fromTest() {
        String[] itemArray = new String[] {"A", "B", "C"};
        Observable source = Observable.fromArray(itemArray);
        source.subscribe(System.out::println);

        ArrayList itemList = new ArrayList();
        itemList.add("A");
        itemList.add("B");
        itemList.add(2);
        source = Observable.fromIterable(itemList);
        source.subscribe(System.out::println);

        Future<String> future = Executors.newSingleThreadExecutor()
                .submit(() -> {
//                    Thread.sleep(5000);
                    return "Hello World";
                });
        source = Observable.fromFuture(future);
        source.subscribe(System.out::println);

        Publisher<String> publisher = subscriber -> {
            subscriber.onNext("A");
            subscriber.onNext("B");
            subscriber.onNext("C");
            subscriber.onComplete();
        };
        source = Observable.fromPublisher(publisher);
        source.subscribe(System.out::println);

        Callable<String> callable = () -> "Hello World";
        source = Observable.fromCallable(callable);
        source.subscribe(System.out::println);
    }

    @Test
    public void otherStreamTest() {
        Single.just("Hello World")
                .subscribe(System.out::println);
        Single.create(emitter -> emitter.onSuccess("Hello"))
                .subscribe(System.out::println);
        Observable<Integer> src = Observable.just(1,2,3);

        Single<Boolean> singleSrc1 = src.all(i -> i > 0);
        singleSrc1.subscribe(System.out::println);
        Single<Integer> singleSrc2 = src.first(-1);
        singleSrc2.subscribe(System.out::println);
        Single<List<Integer>> singleSrc3 = src.toList();
        singleSrc3.subscribe(System.out::println);
        singleSrc3.toObservable().subscribe(System.out::println);

        Maybe.create(emitter -> {
            emitter.onSuccess(100);
            emitter.onComplete(); // 무시됨
        })
                .doOnSuccess(item -> System.out.println("doOnSuccess1"))
                .doOnComplete(() -> System.out.println("doOnComplete1"))
                .subscribe(System.out::println);

        Maybe.create(emitter -> {
            emitter.onComplete();
        })
                .doOnSuccess(item -> System.out.println("doOnSuccess1"))
                .doOnComplete(() -> System.out.println("doOnComplete1"))
                .subscribe(System.out::println);

        Observable<Integer> src1 = Observable.just(1, 2, 3);
        Maybe<Integer> srcMaybe1 = src1.firstElement();
        srcMaybe1.subscribe(System.out::println);

        Observable<Integer> src2 = Observable.empty();
        Maybe<Integer> srcMaybe2 = src2.firstElement();
        srcMaybe2.subscribe(System.out::println, throwable -> {},
                () -> System.out.println("onComplete"));

        Completable.create(emitter -> {
            emitter.onComplete();
        }).subscribe(() -> System.out.println("completed1"));
        Completable.fromRunnable(() -> {

        }).subscribe(() -> System.out.println("completed2"));
    }

    @Test
    public void coldHotObservableTest() {
        try {
//            Observable src = Observable.interval(1, TimeUnit.SECONDS);
//            src.subscribe(value -> System.out.println("#1: " + value));
//            Thread.sleep(3000);
//            src.subscribe(value -> System.out.println("#2: " + value));
//            Thread.sleep(3000);

//            ConnectableObservable src2 = Observable.interval(1, TimeUnit.SECONDS).publish();
//            src2.connect();
//            src2.subscribe(value -> System.out.println("#1: " + value));
//            Thread.sleep(3000);
//            src2.subscribe(value -> System.out.println("#2: " + value));
//            Thread.sleep(3000);

            Observable<Long> src = Observable.interval(100, TimeUnit.MILLISECONDS)
                    .publish()
                    .autoConnect(2);
            src.subscribe(i -> System.out.println("A: " + i));
            src.subscribe(i -> System.out.println("B: " + i));
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void disposableTest() {
        Observable source = Observable.interval(1000, TimeUnit.MILLISECONDS);
        Disposable disposable = source.subscribe(System.out::println);
//            try {
//                Thread.sleep(3500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            disposable.dispose();

        Disposable d1 = source.subscribe(System.out::println);
        Disposable d2 = source.subscribe(System.out::println);
        Disposable d3 = source.subscribe(System.out::println);
        CompositeDisposable cd = new CompositeDisposable();
        cd.addAll(d1, d2, d3);
        cd.dispose();
    }
}
