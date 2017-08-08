package com.example.shree.materialdesign8.vinod2.labcategory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shree.materialdesign8.R;

public class Rating extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_rating);

        Button next=(Button)findViewById(R.id.next);
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
                Intent nxt=new Intent(getApplicationContext(),Thankyou.class);
                startActivity(nxt);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
        Intent nxt=new Intent(getApplicationContext(),LabCategoty.class);
        startActivity(nxt);

    }
}
