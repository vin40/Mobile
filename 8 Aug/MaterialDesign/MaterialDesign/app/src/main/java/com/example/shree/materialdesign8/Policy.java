package com.example.shree.materialdesign8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;

public class Policy extends AppCompatActivity {

    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);

        webView=(WebView)findViewById(R.id.webview);
        webView.loadUrl("file:///android_asset/policy.html");
    }
}
