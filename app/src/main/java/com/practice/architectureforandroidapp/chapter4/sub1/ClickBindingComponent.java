package com.practice.architectureforandroidapp.chapter4.sub1;

import androidx.lifecycle.Lifecycle;

public class ClickBindingComponent implements androidx.databinding.DataBindingComponent {

    private final ClickBindingImpl clickBinding;

    public ClickBindingComponent(Lifecycle lifecycle) {
        clickBinding = new ClickBindingImpl(lifecycle);
    }

    @Override
    public ClickBinding getClickBinding() {
        return clickBinding;
    }
}
