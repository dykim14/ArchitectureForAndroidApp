package com.practice.architectureforandroidapp.chapter3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.disposables.Disposable;

public class Sub3Test {

    @Test
    public void testEmitObservable() {
        Observable<Long> justSrc = Observable.just(
                System.currentTimeMillis()
        );
        Observable<Long> deferSrc = Observable.defer(() ->
                Observable.just(System.currentTimeMillis())
        );
        System.out.println("#1 now = " + System.currentTimeMillis());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("#2 now = " + System.currentTimeMillis());
        justSrc.subscribe(time ->
                System.out.println("#1 time = " + time)
        );
        deferSrc.subscribe(time ->
                System.out.println("#2 time = " + time)
        );
    }

    @Test
    public void testEmptyNever() {
        Observable.empty()
                .doOnTerminate(() -> System.out.println("empty 종료"))
                .subscribe(System.out::println);
        Observable.never()
                .doOnTerminate(() -> System.out.println("never 종료"))
                .subscribe(System.out::println);
    }

    @Test
    public void testInterval() {
        Disposable d = Observable.interval(1, TimeUnit.SECONDS)
                .subscribe(System.out::println);
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        d.dispose();
    }

    @Test
    public void testRange() {
        Observable.range(1, 3).subscribe(System.out::println);
    }

    @Test
    public void testTimer() {
        Observable src = Observable.timer(1, TimeUnit.SECONDS);
        System.out.println("구독");
        src.subscribe(event -> System.out.println("실행!"));
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
    }

    @Test
    public void testMap() {
        Observable<Integer> intSrc = Observable.just(1, 2, 3);
        Observable<Integer> strSrc = intSrc.map(value -> value * 10);
        strSrc.subscribe(System.out::println);
    }

    @Test
    public void testFlatMap() {
        Observable<String> src = Observable.just("a", "b", "c");
        src.flatMap(str -> Observable.just(str + 1, str + 2))
                .subscribe(System.out::println);

        Observable.range(2, 8)
                .flatMap(num -> Observable.range(1, 9)
                        .map(y -> String.format("%d*%d=%d", num, y, num * y)))
                .subscribe(System.out::println);
    }

    @Test
    public void testBuffer() {
        Observable.range(0, 10)
                .buffer(3)
                .subscribe(integers -> {
                    System.out.println("버퍼 데이터 발행");
                    for (Integer integer : integers) {
                        System.out.println("#" + integer);
                    }
                });
    }

    @Test
    public void testScan() {
        Observable.range(1, 5)
                .scan((x, y) -> {
                    System.out.print(String.format("%d+%d=", x, y));
                    return x + y;
                })
                .subscribe(System.out::println);

        Observable.just("a", "b", "c", "d", "e")
                .scan((x, y) -> x + y)
                .subscribe(System.out::println);
    }

    @Test
    public void testGroupBy() {
        Observable.just(
                "Magenta Circle",
                "Cyan Circle",
                "Yellow Triangle",
                "Yellow Circle",
                "Magenta Triangle",
                "Cyan Triangle")
                .groupBy(item -> {
                    if (item.contains("Circle")) {
                        return "C";
                    } else if (item.contains("Triangle")) {
                        return "T";
                    } else {
                        return "None";
                    }
                })
                .subscribe(group -> {
                    System.out.println(group.getKey() + "그룹 발생 시작");
                    group.subscribe(shape -> System.out.println(group.getKey() + ":" + shape));
                });
    }

    @Test
    public void testDebounce() throws InterruptedException {
        Observable.create(emitter -> {
            emitter.onNext("1");
            Thread.sleep(100);
            emitter.onNext("2");
            emitter.onNext("3");
            emitter.onNext("4");
            emitter.onNext("5");
            Thread.sleep(100);
            emitter.onNext("6");
        })
                .debounce(10, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);
        Thread.sleep(300);
    }

    @Test
    public void testDistinct() {
        Observable.just(1, 2, 2, 1, 3)
                .distinct()
                .subscribe(System.out::println);
    }

    @Test
    public void testElementAt() {
        Observable.just(1, 2, 3, 4)
                .elementAt(3)
                .subscribe(System.out::println);
    }

    @Test
    public void testFilter() {
        Observable.just(2, 30, 22, 5, 60, 1)
                .filter(x -> x > 10)
                .subscribe(System.out::println);
    }

    @Test
    public void testSample() throws InterruptedException {
        Observable.interval(100, TimeUnit.MILLISECONDS)
                .sample(400, TimeUnit.MILLISECONDS)
                .subscribe(System.out::println);
        Thread.sleep(1000);
    }

    @Test
    public void testSkip() {
        Observable.just(2, 30, 22, 5, 60, 1)
                .skip(2)
                .subscribe(System.out::println);
    }

    @Test
    public void testTake() {
        Observable.just(2, 30, 22, 5, 60, 1)
                .take(2)
                .subscribe(System.out::println);
    }

    @Test
    public void testAll() {
        Observable.just(2, 30, 22, 5, 60, 1)
                .all(x -> x > 0)
                .subscribe(System.out::println);
    }

    @Test
    public void testAmb() {
        ArrayList<Observable<Integer>> list = new ArrayList<>();
        list.add(Observable.just(20, 40, 60)
                .delay(100, TimeUnit.MILLISECONDS));
        list.add(Observable.just(1, 2, 3));
        list.add(Observable.just(0, 0, 0)
                .delay(200, TimeUnit.MILLISECONDS));
        Observable.amb(list).subscribe(System.out::println);
    }

    @Test
    public void testCombineLatest() throws InterruptedException {
        Observable<Integer> src1 = Observable.create(emitter -> {
            new Thread(() -> {
                for (int i = 1; i <= 5; i++) {
                    emitter.onNext(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });

        Observable<String> src2 = Observable.create(emitter -> {
            new Thread(() -> {
                try {
                    Thread.sleep(500);
                    emitter.onNext("A");
                    Thread.sleep(700);
                    emitter.onNext("B");
                    Thread.sleep(100);
                    emitter.onNext("C");
                    Thread.sleep(700);
                    emitter.onNext("D");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        });

        Observable.combineLatest(src1, src2, (num, str) -> num + str)
                .subscribe(System.out::println);
        Thread.sleep(5000);
    }

    @Test
    public void testZip() throws InterruptedException {
        Observable<Integer> src1 = Observable.create(emitter -> {
            new Thread(() -> {
                for (int i = 1; i <= 5; i++) {
                    emitter.onNext(i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        });

        Observable<String> src2 = Observable.create(emitter -> {
            new Thread(() -> {
                try {
                    Thread.sleep(500);
                    emitter.onNext("A");
                    Thread.sleep(700);
                    emitter.onNext("B");
                    Thread.sleep(100);
                    emitter.onNext("C");
                    Thread.sleep(700);
                    emitter.onNext("D");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        });

        Observable.zip(src1, src2, (num, str) -> num + str)
                .subscribe(System.out::println);
        Thread.sleep(5000);
    }

    @Test
    public void testMerge() throws InterruptedException {
        Observable src1 = Observable.intervalRange(
                1,  // 시작값
                5,  // 발행 횟수
                0,  // 초기 지연
                100,// 발행 간격
                TimeUnit.MILLISECONDS
        ).map(value -> value * 20);
        Observable src2 = Observable.create(emitter -> {
            new Thread(() -> {
                try {
                    Thread.sleep(350);
                    emitter.onNext(1);
                    Thread.sleep(200);
                    emitter.onNext(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        });
        Observable.merge(src1, src2)
                .subscribe(System.out::println);
        Thread.sleep(1000);
    }

    @Test
    public void testOnError() {
        Observable.just("1", "2", "a", "3")
                .map(Integer::parseInt)
                .subscribe(System.out::println,
                        throwable -> System.out.println("Error!"));
    }

    @Test
    public void testOnErrorReturn() {
        Observable.just("1", "2", "a", "3")
                .map(Integer::parseInt)
                .onErrorReturn(throwable -> -1)
                .subscribe(System.out::println,
                        throwable -> System.out.println("Error!"));
    }

    @Test
    public void testOnErrorResumeNext() {
        Observable.just("1", "2", "a", "3")
                .map(Integer::parseInt)
                .onErrorResumeNext(throwable ->
                        Observable.just(100, 200, 300))
                .subscribe(System.out::println,
                        throwable -> System.out.println("Error!"));
    }

    @Test
    public void testRetry() {
        Observable.just("1", "2", "a", "3")
                .map(Integer::parseInt)
                .retry(2)
                .subscribe(System.out::println,
                        throwable -> System.out.println("Error!"));
    }

    @Test
    public void testDoOnEach() {
        Observable.just(1, 2, 3)
                .doOnEach(notification -> {
                    Integer i = notification.getValue();
                    boolean isOnNext = notification.isOnNext();
                    boolean isOnComplete = notification.isOnComplete();
                    boolean isOnError = notification.isOnError();
                    Throwable throwable = notification.getError();
                    System.out.println("i = " + i);
                    System.out.println("isOnNext = " + isOnNext);
                    System.out.println("isOnComplete = " + isOnComplete);
                    System.out.println("isOnError = " + isOnError);
                    if (throwable != null) {
                        throwable.printStackTrace();
                    }
                })
                .subscribe(value -> {
                    System.out.println("Subscribed = " + value);
                });

    }

    @Test
    public void testDoOnNext() {
        Observable.just(1, 2, 3)
                .doOnNext(item -> {
                    if (item > 1) {
//                        throw new IllegalArgumentException();
                        System.out.println("doOnNext = " + item);
                    }
                })
                .subscribe(System.out::println,
                        throwable -> throwable.printStackTrace());
    }

    @Test
    public void testDoOnSubscribe() {
        Observable.just(1, 2, 3)
                .doOnSubscribe(disposable -> System.out.println("구독 시작!"))
                .subscribe(System.out::println);
    }

    @Test
    public void testDoOnComplete() {
        Observable.just(1, 2, 3)
                .doOnComplete(() -> System.out.println("완료!"))
                .subscribe(System.out::println);
    }

    @Test
    public void testDoOnError() {
        Observable.just(2, 1, 0)
                .map(i -> 10 / i)
                .doOnError(throwable -> System.out.println("오류!"))
                .subscribe(System.out::println, t -> t.printStackTrace());
    }

    @Test
    public void testDoOnTerminate() {
        Observable.just(2, 1, 0)
                .map(i -> 10 / i)
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .subscribe(System.out::println, t -> t.printStackTrace());
    }

    @Test
    public void testDoOnDispose() throws InterruptedException {
        Observable src = Observable.interval(500, TimeUnit.MILLISECONDS)
                .doOnNext(i -> System.out.println("doOnNext = " + i))
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doOnDispose(() -> System.out.println("doOnDispose"));
        Disposable disposable = src.subscribe(System.out::println);
        Thread.sleep(1100);
        disposable.dispose();
    }

    @Test
    public void testDoFinally() throws InterruptedException {
        Observable src = Observable.interval(500, TimeUnit.MILLISECONDS)
                .doOnNext(i -> System.out.println("doOnNext = " + i))
                .doOnComplete(() -> System.out.println("doOnComplete"))
                .doOnTerminate(() -> System.out.println("doOnTerminate"))
                .doOnDispose(() -> System.out.println("doOnDispose"))
                .doFinally(() -> System.out.println("doFinally"));
        Disposable disposable = src.subscribe(System.out::println);
        Thread.sleep(1100);
        disposable.dispose();
    }
}