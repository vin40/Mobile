package com.example.shree.materialdesign8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MedicineActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_medicine);

    }
    @Override
    public void onBackPressed() {

        Intent i=new Intent(MedicineActivity.this,Main4Activity.class);
        startActivity(i);
        this.finish();
    }

}
