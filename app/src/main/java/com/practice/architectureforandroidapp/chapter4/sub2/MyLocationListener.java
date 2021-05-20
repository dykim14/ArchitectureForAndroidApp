package com.practice.architectureforandroidapp.chapter4.sub2;

import android.content.Context;
import android.location.LocationManager;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.OnLifecycleEvent;

public class MyLocationListener implements LifecycleObserver {
    private boolean enabled = false;
    private Lifecycle lifecycle;
    private Context context;

    public MyLocationListener(boolean enabled, Lifecycle lifecycle, Context context) {
        this.enabled = enabled;
        this.lifecycle = lifecycle;
        this.context = context;
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    void start() {
        if (enabled) {
            // 위치 서비스에 연결한다.
            LocationManager locationManager = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
        }
    }

    void enable() {
        enabled = true;
        if (lifecycle.getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {
            // 위치 서비스에 연결되지 않았으면 연결한다.
        }
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    void stop() {
        // 연결된 위치 서비스를 끊는다.
    }
}
