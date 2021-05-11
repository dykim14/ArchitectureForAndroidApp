package com.practice.architectureforandroidapp.chapter4.sub1;

import android.view.View;

import androidx.databinding.BindingAdapter;

public interface ClickBinding {
    @BindingAdapter("onClick")
    void setOnClickListener(View view, View.OnClickListener onClickListener);
}
