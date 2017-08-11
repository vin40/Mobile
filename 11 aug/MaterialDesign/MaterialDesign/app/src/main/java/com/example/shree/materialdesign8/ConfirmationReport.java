package com.example.shree.materialdesign8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.shree.materialdesign8.vinod2.labcategory.Thankyou;

public class ConfirmationReport extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmation_report);

        Button b=(Button)findViewById(R.id.thank);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ConfirmationReport.this,Thankyou.class);
                startActivity(i);
            }
        });
    }
}
