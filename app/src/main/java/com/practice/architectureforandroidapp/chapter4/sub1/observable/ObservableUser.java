package com.practice.architectureforandroidapp.chapter4.sub1.observable;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

//import com.practice.architectureforandroidapp.BR;

public class ObservableUser extends BaseObservable {
    private String firstName;
    private String lastName;

    @Bindable
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
//        notifyPropertyChanged(BR.firstName);
    }

    @Bindable
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
//        notifyPropertyChanged(BR.lastName);
    }
}
