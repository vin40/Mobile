package com.example.shree.materialdesign8.allocator.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.shree.materialdesign8.R;

public class DoctorRelated extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_related);

        Button allref=(Button)findViewById(R.id.ref);
        allref.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DoctorRelated.this,ActivityCategoryList.class);
                startActivity(i);
            }
        });



        Button todaypatient=(Button)findViewById(R.id.todaypatient);
        todaypatient.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DoctorRelated.this,TodaysPatient.class);
                startActivity(i);
            }
        });

        Button PatientName=(Button)findViewById(R.id.patientName);
        PatientName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(DoctorRelated.this,NamePatient.class);
                startActivity(i);
            }
        });
    }
}
