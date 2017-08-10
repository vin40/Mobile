package com.example.shree.materialdesign8.spinnerFav;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.shree.materialdesign8.R;

public class FavName3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fav_name3);
        Button next3=(Button)findViewById(R.id.next);
        next3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inext3=new Intent(getApplicationContext(),FavNameT3.class);
                startActivity(inext3);
            }
        });
    }
}
