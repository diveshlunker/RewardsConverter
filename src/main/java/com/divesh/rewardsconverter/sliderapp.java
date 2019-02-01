package com.divesh.rewardsconverter;

import android.app.Application;

import com.firebase.client.Firebase;

public class sliderapp extends Application {
    @Override
    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);
    }

}
