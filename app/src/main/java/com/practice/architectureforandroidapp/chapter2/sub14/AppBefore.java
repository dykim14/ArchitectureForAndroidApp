package com.practice.architectureforandroidapp.chapter2.sub14;

import android.app.Application;

public class AppBefore extends Application {

    private AppComponentBefore appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponentBefore.factory().create(this, new AppModuleBefore());
    }

    public AppComponentBefore getAppComponent() {
        return appComponent;
    }
}
