package com.practice.architectureforandroidapp.chapter4.sub3;

import android.os.Bundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.MutableLiveData;

public class MainActivity extends AppCompatActivity {

    MutableLiveData<String> liveString = new MutableLiveData<>();

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        liveString.postValue("Hello Charles");
        liveString.setValue("Hello World");
        liveString.observe(this, s -> Log.d("Test", s));
    }
}
