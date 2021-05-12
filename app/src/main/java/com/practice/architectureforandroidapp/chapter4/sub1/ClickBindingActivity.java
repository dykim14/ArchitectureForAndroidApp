package com.practice.architectureforandroidapp.chapter4.sub1;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.Observable;

import com.practice.architectureforandroidapp.R;
import com.practice.architectureforandroidapp.databinding.ActivityClickBindingBinding;

public class ClickBindingActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String TAG = ClickBindingActivity.class.getSimpleName();

    @Override
    protected void onCreate(@Nullable @org.jetbrains.annotations.Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityClickBindingBinding binding = DataBindingUtil.setContentView(
                this,
                R.layout.activity_click_binding,
                new ClickBindingComponent(getLifecycle()));
        binding.setClickListener(this);
        LoginViewModel loginViewModel = new LoginViewModel();
        binding.setViewModel(loginViewModel);
        loginViewModel.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() {
            @Override
            public void onPropertyChanged(Observable sender, int propertyId) {
                sender.removeOnPropertyChangedCallback(this);
            }
        });
    }

    @Override
    public void onClick(View v) {
        Log.e(TAG, "Clicked");
        Toast.makeText(this, "Clicked", Toast.LENGTH_SHORT).show();
    }
}
