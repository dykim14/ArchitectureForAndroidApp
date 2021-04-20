package com.practice.architectureforandroidapp.chapter2.sub14;

import android.app.Application;

public class App extends Application {

    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = DaggerAppComponent.factory().create(this, new AppModule());
    }

    public AppComponent getAppComponent() {
        return appComponent;
    }
}
