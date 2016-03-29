package com.example.maratmamin.rentamate;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by maratmamin on 3/29/16.
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}
