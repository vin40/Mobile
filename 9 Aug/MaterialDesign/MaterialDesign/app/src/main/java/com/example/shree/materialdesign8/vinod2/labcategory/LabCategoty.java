package com.example.shree.materialdesign8.vinod2.labcategory;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.vinod.navigationdrawer.Dashboard;
import com.example.shree.materialdesign8.vinod2.labcategory.rating.MainActivity;

/**
 * Created by Vinod on 4/19/2017.
 */
public class LabCategoty extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_lab_category);



      Button area=(Button)findViewById(R.id.areawiselab);
        area.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent areaintent=new Intent(getApplicationContext(),Area.class);
                startActivity(areaintent);
            }
        });
        Button discount=(Button)findViewById(R.id.discount);
        discount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentdis=new Intent(getApplicationContext(),Discount.class);
                startActivity(intentdis);
            }
        });

        Button ratingintent=(Button)findViewById(R.id.rating);
        ratingintent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentrat=new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intentrat);
            }
        });

        Button timeline=(Button)findViewById(R.id.timeline);
        timeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intenttime=new Intent(getApplicationContext(),TimeLine.class);
                startActivity(intenttime);
            }
        });

        Button b2=(Button)findViewById(R.id.back);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent intentbb=new Intent(getApplicationContext(),Dashboard.class);
                startActivity(intentbb);
            }
        });
    }
}