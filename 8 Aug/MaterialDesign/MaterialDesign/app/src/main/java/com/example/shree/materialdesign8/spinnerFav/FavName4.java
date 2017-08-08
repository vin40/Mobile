package com.example.shree.materialdesign8.spinnerFav;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.shree.materialdesign8.R;

public class FavName4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fav_name4);

        Button next4=(Button)findViewById(R.id.next);
        next4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inext4=new Intent(getApplicationContext(),FavNameT4.class);
                startActivity(inext4);
            }
        });
    }
}
