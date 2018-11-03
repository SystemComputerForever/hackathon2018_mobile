package com.example.hackathon2018.happytravel.Controller;

/**
 * Created by Benix on 17/11/2018.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.view.MotionEvent;
import android.view.View;
import com.example.hackathon2018.happytravel.DataHandler.REST;
import com.example.hackathon2018.happytravel.Function.CallBackFunction;
import com.example.hackathon2018.happytravel.Item.Travelpost;
import com.example.hackathon2018.happytravel.UIHandler.AlertBox;
import com.example.hackathon2018.happytravel.UIHandler.OnClickMethod;
import com.google.gson.Gson;

import java.util.HashMap;

public class TravelPostController extends AsyncTask<String, Void, String> {
    private View progress_form;
    private Context mContext;
    private DrawerLayout drawer;
    private CallBackFunction mCallback;
    private AlertBox ab = new AlertBox();
    private Travelpost tp;
    private Gson gson = new Gson();
    private SharedPreferences mPrefs;
    private OnClickMethod ocm = new OnClickMethod();

    public TravelPostController(View progressview, Context mContext, DrawerLayout drawer) {
        this.mContext = mContext;
        this.progress_form = progressview;
        this.drawer = drawer;
        mPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        //   tp = gson.fromJson(, Travelpost.class);
        mCallback = (CallBackFunction) mContext;

    }

    protected void onPreExecute() {
        drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        showProgress(true);
    }

    @Override
    protected String doInBackground(String... params) {
        String response = "";
        try {
            HashMap<String, String> data = new HashMap<>();
            REST rest = new REST();
            response = rest.ClientData("the link", data, "POST", mContext);
            Thread.sleep(2000);
        } catch (Exception ex) {
            return "Lost Connectivity";
        }
        return response;
    }

    @Override
    protected void onPostExecute(String result) {
        showProgress(false);
        switch (result) {
            case "Server Maintenance":
                ab.setAlertDialog(mContext,false,ocm.errorOnClick(mContext),null,"OK",null,"Error","Server Maintenance").show();
                break;
            case "Lost Connectivity":
                 ab.setAlertDialog(mContext,false,ocm.errorOnClick(mContext),null,"OK",null,"Error","Connectivity Problem").show();
                break;
            default:
                if (!result.isEmpty()) {
                    mCallback.done(result);
                } else {
                    ab.setAlertDialog(mContext,false,ocm.errorOnClick(mContext),null,"OK",null,"Error","Server Maintenance").show();
                }
                break;
        }
    }

    private void showProgress(final boolean show) {
        progress_form.setVisibility(show ? View.VISIBLE : View.GONE);
        progress_form.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                return true;
            }
        });
        if (!show)
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        else
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);


    }
}