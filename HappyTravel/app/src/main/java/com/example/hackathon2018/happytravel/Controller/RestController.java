package com.example.hackathon2018.happytravel.Controller;

/**
 * Created by Benix on 17/11/2018.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.preference.PreferenceManager;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.example.hackathon2018.happytravel.DataHandler.REST;
import com.example.hackathon2018.happytravel.Function.CallBackFunction;
import com.example.hackathon2018.happytravel.Item.Travelpost;
import com.example.hackathon2018.happytravel.MyApplication;
import com.example.hackathon2018.happytravel.UIHandler.AlertBox;
import com.example.hackathon2018.happytravel.UIHandler.OnClickMethod;
import com.google.gson.Gson;

import java.util.HashMap;

public class RestController extends AsyncTask<String, Void, String> {
    private View progress_form;
    private Context mContext;
    private DrawerLayout drawer;
    private CallBackFunction mCallback;
    private AlertBox ab = new AlertBox();
    private Travelpost tp;
    private Gson gson = new Gson();
    private SharedPreferences mPrefs;
    private OnClickMethod ocm = new OnClickMethod();
    private String link;

    public RestController(View progressview, Context mContext, DrawerLayout drawer, String link, HashMap<String, String> data, CallBackFunction cmf) {
        this.mContext = mContext;
        this.progress_form = progressview;
        this.drawer = drawer;
        if (mContext != null)
            mPrefs = PreferenceManager.getDefaultSharedPreferences(mContext);
        //   tp = gson.fromJson(, Travelpost.class);
        mCallback = cmf;
        this.link = link;

    }

    protected void onPreExecute() {
        if (drawer != null)
            drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        showProgress(true);
    }

    @Override
    protected String doInBackground(String... params) {
        String response = "";
        try {
            HashMap<String, String> data = new HashMap<>();
            REST rest = new REST();
            response = rest.ClientData(link, data, "GET");
            Thread.sleep(2000);
        } catch (Exception ex) {
            ex.printStackTrace();
            return "Lost Connectivity";
        }
        return response;
    }

    @Override
    protected void onPostExecute(String result) {
        showProgress(false);
        Log.e("result", result);
        switch (result) {
            case "Server Maintenance":
                if (mContext != null)
                    ab.setAlertDialog(mContext, false, ocm.errorOnClick(mContext), null, "OK", null, "Error", "Server Maintenance").show();
                break;
            case "Lost Connectivity":
                if (mContext != null)
                    ab.setAlertDialog(mContext, false, ocm.errorOnClick(mContext), null, "OK", null, "Error", "Connectivity Problem").show();
                break;
            default:
                if (!result.isEmpty()) {
                    mCallback.done(result);
                } else {
                    ab.setAlertDialog(mContext, false, ocm.errorOnClick(mContext), null, "OK", null, "Error", "Server Maintenance").show();
                }
                break;
        }
    }

    private void showProgress(final boolean show) {
        if (progress_form != null) {
            progress_form.bringToFront();
            progress_form.setVisibility(show ? View.VISIBLE : View.GONE);
            progress_form.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });
        }
        if (drawer != null) {
            if (!show) {
                drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
            } else {
                drawer.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
            }
        }

    }
}
