package com.practice.architectureforandroidapp.chapter2.sub14;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import javax.inject.Inject;

public class MainFragmentBefore extends Fragment {

    @Inject
    SharedPreferences sharedPreferences;

    @Inject
    String activityName;

    @Inject
    Integer randomNumber;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        if (getActivity() instanceof MainActivityBefore) {
            ((MainActivityBefore)getActivity()).getComponent()
                    .mainFragmentComponentBuilder()
                    .setModule(new MainFragmentModuleBefore())
                    .setFragment(this)
                    .build()
                    .inject(this);
        }

        Log.d("MainFragment", activityName);
        Log.d("MainFragment", "randomNumber = " + randomNumber);
    }
}
