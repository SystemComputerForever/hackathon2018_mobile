package com.example.hackathon2018.happytravel.UIActiviy;

import android.os.Bundle;

import com.example.hackathon2018.happytravel.Function.CallBackFunction;
import com.example.hackathon2018.happytravel.R;
import com.example.hackathon2018.happytravel.UIActiviy.BasicActivity.NavigationActivity;
import com.example.hackathon2018.happytravel.UIActiviy.BasicActivity.NoNavigationActivity;

/**
 * Created by Benix on 13/11/2018.
 */

public class MyplanActivity extends NoNavigationActivity implements CallBackFunction {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_myplan);
        super.onCreate(savedInstanceState);

    }

    @Override
    public void done(String result) {

    }
}
