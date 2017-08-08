package com.example.shree.materialdesign8.vinod3.selectTestDisease;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shree.materialdesign8.R;

public class SelectTestDisease extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_test_disease);

        Button test=(Button)findViewById(R.id.selecttest);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent testi=new Intent(getApplicationContext(),SelectDTest.class);
                startActivity(testi);
            }
        });

        Button disease=(Button)findViewById(R.id.selectdisease);
        disease.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent diseasei=new Intent(getApplicationContext(),SelectDisease.class);
                startActivity(diseasei);
            }
        });
    }
}
