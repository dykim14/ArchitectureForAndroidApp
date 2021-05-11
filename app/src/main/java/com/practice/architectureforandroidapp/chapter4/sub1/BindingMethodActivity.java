package com.practice.architectureforandroidapp.chapter4.sub1;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.databinding.BindingMethod;
import androidx.databinding.BindingMethods;
import androidx.databinding.DataBindingUtil;

import com.practice.architectureforandroidapp.R;
import com.practice.architectureforandroidapp.databinding.ActivityMainBindingMethodsBinding;

public class BindingMethodActivity extends AppCompatActivity {

    ActivityMainBindingMethodsBinding binding2;

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding2 = DataBindingUtil.inflate(LayoutInflater.from(this), R.layout.activity_main_binding_methods, null, false);
        
    }
}
