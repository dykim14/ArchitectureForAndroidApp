package com.practice.architectureforandroidapp.chapter4.sub1.observable;

import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableArrayMap;

public class Utilize {

    public void one() {
        User user = new User();
        user.firstName.set("Charles");
        int age = user.age.get();
    }

    public void two() {
        ObservableArrayMap<String, Object> user = new ObservableArrayMap<>();
        user.put("firstName", "Charles");
        user.put("lastName", "Darwin");
        user.put("age", 17);
    }

    public void three() {
        ObservableArrayList<Object> user = new ObservableArrayList<>();
        user.add("Charles");
        user.add("Darwin");
        user.add(17);
    }
}
