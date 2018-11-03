package com.example.hackathon2018.happytravel.DataHandler;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import com.example.hackathon2018.happytravel.Function.ConvertFunction;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

/**
 * Created by Benix on 17/11/2018.
 */
public class REST {

    public String ClientData(String link, HashMap<String, String> data, String methodtype, Context mContext) throws IOException {

        String response = "";
        ConvertFunction cf = new ConvertFunction();
        if (!isOnline(mContext)) {
            return "Lost Connectivity";
        }
        if (!ResponseCodeCheck(link)) {
            return "Server Maintenance";
        }
        try {

            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod(methodtype);
            conn.setConnectTimeout(3000);
            if (!methodtype.equals("GET")) {
                conn.setDoOutput(true);
            }
            OutputStreamWriter wr = new OutputStreamWriter(
                    conn.getOutputStream());
            wr.write(cf.encodeHashMap(data));
            wr.flush();
            BufferedReader reader = null;
            reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
            StringBuilder sb = new StringBuilder();
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            response = sb.toString();
            conn.disconnect();
            wr.close();
            return response;

        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return response;
    }


    private boolean isOnline(Context mContext) {
        ConnectivityManager cm =
                (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        return netInfo != null && netInfo.isConnectedOrConnecting();
    }


    private boolean ResponseCodeCheck(String link) throws IOException {

        URL url = new URL(link);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(3000);
        connection.connect();

        int code = connection.getResponseCode();
        if (code == 200) {
            connection.disconnect();
            return true;
        }
        connection.disconnect();
        return false;
    }
}


