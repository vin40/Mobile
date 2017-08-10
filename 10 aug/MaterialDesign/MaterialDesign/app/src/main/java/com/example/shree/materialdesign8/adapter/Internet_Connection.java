package com.example.shree.materialdesign8.adapter;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by HP-PC on 8/7/2017.
 */
public class Internet_Connection {
    private Context _context;
    public boolean InterNet_connection;

    public Internet_Connection(Context context) {
        this._context = context;
    }

    public boolean isConnectingToInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) _context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivity.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isAvailable()) {
//InterNet_connection = isInternetAccessible();
            InterNet_connection = true;

            Log.i("Boolean", "true");
// Log.e("TypeName",networkInfo.getTypeName());
//Log.e("Type",String.valueOf(networkInfo.getType()));
        } else {
            InterNet_connection = false;
        }

        return InterNet_connection;
    }

    public boolean isInternetAccessible() {
        try {
            HttpURLConnection urlc = (HttpURLConnection) (new URL("http://www.google.com").openConnection());
            urlc.setRequestProperty("User-Agent", "Test");
            urlc.setRequestProperty("Connection", "close");
            urlc.setConnectTimeout(1500);
            urlc.connect();

            return (urlc.getResponseCode() == 200);

        } catch (IOException e) {
            Log.e("Log ", "Couldn't check internet connection", e);
        }
        return false;
    }


}