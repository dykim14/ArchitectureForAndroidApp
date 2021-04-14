package com.practice.architectureforandroidapp.chapter2;

import android.app.Activity;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.practice.architectureforandroidapp.R;

public class MyActivity extends Activity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_activity);
    }
}
