package com.practice.architectureforandroidapp.chapter4.sub1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.practice.architectureforandroidapp.R;
import com.practice.architectureforandroidapp.databinding.ActivityMain2Binding;
import com.practice.architectureforandroidapp.databinding.ActivityMainLayoutBinding;

public class MainActivity extends AppCompatActivity {

    ActivityMain2Binding binding;
    ActivityMainLayoutBinding binding2;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView(
                this, R.layout.activity_main_2);
        FrameLayout rootLayout = binding.container;
        TextView textView = binding.tv;
        textView.setText("Hello charles");
        // Or
        binding.setMyText("Hello charles");

        binding2 = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_main_3, null, false);
        binding2.setUser(new User("Charles", "Darwin"));
    }
}
