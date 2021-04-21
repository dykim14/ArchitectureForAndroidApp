package com.practice.architectureforandroidapp.chapter2.sub14;

import android.content.SharedPreferences;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.practice.architectureforandroidapp.R;

import javax.inject.Inject;

public class MainActivityBefore extends AppCompatActivity {

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    String activityName;

    MainActivityComponent component;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        component = ((AppBefore)getApplication()).getAppComponent()
                .mainActivityComponentBuilder()
                .setModule(new MainActivityModuleBefore())
                .setActivity(this)
                .build();
        component.inject(this);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, new MainFragment())
                .commit();
    }

    public MainActivityComponent getComponent() {
        return component;
    }
}
