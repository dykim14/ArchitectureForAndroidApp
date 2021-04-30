package com.practice.architectureforandroidapp.chapter3;

import org.junit.Test;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.BackpressureStrategy;
import io.reactivex.rxjava3.core.Flowable;
import io.reactivex.rxjava3.core.FlowableOnSubscribe;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class Sub5Test {

    @Test
    public void testBackpressureDef() throws InterruptedException {
        Observable.range(1, Integer.MAX_VALUE)
                .map(item -> {
                    System.out.println("아이템 발행 : " + item);
                    return item;
                })
                .subscribe(item -> {
                    Thread.sleep(100);
                    System.out.println("아이템 소비 : " + item);
                });
        Thread.sleep(30 * 1000);
    }

    @Test
    public void testBackpressureDef1() throws InterruptedException {
        Observable.range(1, Integer.MAX_VALUE)
                .map(item -> {
                    System.out.println("아이템 발행 : " + item);
                    return item;
                })
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    Thread.sleep(100);
                    System.out.println("아이템 소비 : " + item);
                });
        Thread.sleep(30 * 1000);
    }

    @Test
    public void testFlowable() throws InterruptedException {
        Flowable.range(1, Integer.MAX_VALUE)
                .map(item -> {
                    System.out.println("아이템 발행 : " + item);
                    return item;
                })
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    Thread.sleep(100);
                    System.out.println("아이템 소비 : " + item);
                });
        Thread.sleep(30 * 1000);
    }

    @Test
    public void testFlowableCollision() throws InterruptedException {
        Flowable.interval(10, TimeUnit.MILLISECONDS)
                .observeOn(Schedulers.io())
                .map(item -> {
                    Thread.sleep(2000);
                    System.out.println("아이템 발행 : " + item);
                    return item;
                })
                .subscribe(item -> {
                    System.out.println("아이템 소비 : " + item);
                }, t -> t.printStackTrace());
        Thread.sleep(30 * 1000);
    }

    @Test
    public void testOnBackpressureBuffer() throws InterruptedException {
        System.out.println(Flowable.bufferSize());
        Flowable.interval(10, TimeUnit.MILLISECONDS)
                // delayError 인자 : 생산이 소비보다 빨라서 내부 생산 스케쥴보다 빨리 소비가 안되는 경우 delay error를 발생할 지 여부를 결정
                // unbounded 인자 : 버퍼가 가득찬경우에도 한계없이 계속 생산할 것인지 여부를 결정
                .onBackpressureBuffer(10, false, true)
//                .onBackpressureBuffer()
                .observeOn(Schedulers.io())
                .map(item -> {
//                    Thread.sleep(2000);
                    System.out.println("아이템 발행 : " + item);
                    return item;
                })
                .subscribe(item -> {
                    Thread.sleep(1000);
                    System.out.println("아이템 소비 : " + item);
                }, t -> t.printStackTrace());
        Thread.sleep(30 * 1000);
    }

    @Test
    public void testOnBackpressureLatest() throws InterruptedException {
        Flowable.interval(1, TimeUnit.MILLISECONDS)
//                .onBackpressureBuffer(20, false, false)
                .onBackpressureLatest()
                .observeOn(Schedulers.io())
//                .map(item -> {
//                    System.out.println("아이템 발행 : " + item);
//                    return item;
//                })
//                .doOnNext(item -> {
//                    System.out.println("아이템 발행 : " + item);
//                })
                .subscribe(item -> {
                    Thread.sleep(100);
                    System.out.println("아이템 소비 : " + item);
                }, t -> t.printStackTrace());
        Thread.sleep(30 * 1000);
    }

    @Test
    public void testOnBackpressureDrop() throws InterruptedException {
        Flowable.range(1, 300)
                .onBackpressureDrop()
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    Thread.sleep(10);
                    System.out.println("아이템 소비 : " + item);
                }, t -> t.printStackTrace());
        Thread.sleep(30 * 1000);
    }

    @Test
    public void testOnBackpressureDropCallback() throws InterruptedException {
        Flowable.range(1, 300)
                .onBackpressureDrop(item -> {
                    System.out.println("아이템 버림 : " + item);
                })
                .observeOn(Schedulers.io())
                .subscribe(item -> {
                    Thread.sleep(100);
                    System.out.println("아이템 소비 : " + item);
                }, t -> t.printStackTrace());
        Thread.sleep(30 * 1000);
    }

    @Test
    public void testFlowableCreation() throws InterruptedException {
        Flowable.create((FlowableOnSubscribe<Integer>) emitter -> {
            for (int i = 0; i <= 1000; i++) {
                if (emitter.isCancelled()) {    // 다운스트림 취소 및 폐기 시 true
                    return;
                }
                emitter.onNext(i);
            }
            emitter.onComplete();
        }, BackpressureStrategy.BUFFER) // 배압 제어 전략
        .subscribeOn(Schedulers.computation())
                .observeOn(Schedulers.io())
                .subscribe(System.out::println,
                        t -> t.printStackTrace());
        Thread.sleep(100);
    }
}
