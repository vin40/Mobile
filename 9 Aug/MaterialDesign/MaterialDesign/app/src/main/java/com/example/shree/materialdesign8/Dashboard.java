package com.example.shree.materialdesign8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class Dashboard extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        Intent intent = getIntent();
        String username = intent.getStringExtra(Login.USER_NAME);

        TextView textView = (TextView) findViewById(R.id.textView3);

        textView.setText("Welcome " + username);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
         finish();
        Intent i=new Intent(Dashboard.this,Login.class);
        startActivity(i);

    }

  }