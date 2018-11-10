package com.example.hackathon2018.happytravel;

import android.app.Application;
import android.content.Context;

/**
 * Created by Benix on 10/11/2018.
 */

public class MyApplication extends Application {

    private static Context context;

    public void onCreate() {
        super.onCreate();
        MyApplication.context = getApplicationContext();
    }

    public static Context getAppContext() {
        return MyApplication.context;
    }
}