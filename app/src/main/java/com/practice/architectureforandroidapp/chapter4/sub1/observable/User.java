package com.practice.architectureforandroidapp.chapter4.sub1.observable;

import androidx.databinding.ObservableField;
import androidx.databinding.ObservableInt;

public class User {
    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();
    public final ObservableInt age = new ObservableInt();
}
