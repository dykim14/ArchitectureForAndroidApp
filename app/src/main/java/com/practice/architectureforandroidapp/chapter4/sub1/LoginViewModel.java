package com.practice.architectureforandroidapp.chapter4.sub1;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

import com.practice.architectureforandroidapp.BR;

public class LoginViewModel extends BaseObservable {
    // private Model data = ...

    private Boolean rememberMe;

    @Bindable
    public Boolean getRememberMe() {
        return rememberMe;
    }

    public void setRememberMe(Boolean value) {
        if (rememberMe != value) {
            rememberMe = value;

            // 변화에 대응
            // saveData();

            // 새로운 값을 알린다.
            notifyPropertyChanged(BR.rememberMe);
        }
    }
}
