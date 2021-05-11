package com.practice.architectureforandroidapp.chapter4.sub1;

import android.view.View;

import androidx.core.util.Pair;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

import java.util.concurrent.TimeUnit;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.subjects.PublishSubject;

public class ClickBindingImpl implements ClickBinding, LifecycleObserver {
    private final PublishSubject<Pair<View, View.OnClickListener>> publishSubject = PublishSubject.create();
    private CompositeDisposable disposable = new CompositeDisposable();
    private final int TIME_OUT = 1000;

    public ClickBindingImpl(Lifecycle lifecycle) {
        lifecycle.addObserver(this);
    }

    @Override
    public void setOnClickListener(View view, View.OnClickListener onClickListener) {
        view.setOnClickListener(v -> publishSubject.onNext(Pair.create(view, onClickListener)));
        disposable.add(publishSubject.throttleFirst(TIME_OUT, TimeUnit.MILLISECONDS, AndroidSchedulers.mainThread())
                .subscribe(pair -> {
                    if (pair != null && pair.first != null && pair.second != null) {
                        pair.second.onClick(pair.first);
                    }
                })
        );
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroyed() {
        if (!disposable.isDisposed()) {
            disposable.dispose();
        }
    }
}
