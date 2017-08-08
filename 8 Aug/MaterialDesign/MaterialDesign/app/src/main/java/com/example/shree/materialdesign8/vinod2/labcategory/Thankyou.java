package com.example.shree.materialdesign8.vinod2.labcategory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.vinod.navigationdrawer.Dashboard;

public class Thankyou extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thankyou);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();


        Intent i=new Intent(Thankyou.this, Dashboard.class);
        startActivity(i);
        this.finish();
    }
}
