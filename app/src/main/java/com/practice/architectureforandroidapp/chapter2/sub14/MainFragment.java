package com.practice.architectureforandroidapp.chapter2.sub14;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import javax.inject.Inject;
import javax.inject.Named;

import dagger.android.AndroidInjection;
import dagger.android.support.AndroidSupportInjection;

public class MainFragment extends Fragment {

    @Inject
    @Named("app")
    String appString;

    @Inject
    @Named("activity")
    String activityString;

    @Inject
    @Named("fragment")
    String fragmentString;

    @Override
    public void onAttach(@NonNull Context context) {
        AndroidSupportInjection.inject(this);
        Log.d("MainFragment", appString);
        Log.d("MainFragment", activityString);
        Log.d("MainFragment", fragmentString);
        super.onAttach(context);
    }
}
