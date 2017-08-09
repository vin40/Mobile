package com.example.shree.materialdesign8.vinod11.editprofile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.vinod.navigationdrawer.Dashboard;

public class EditProfile extends AppCompatActivity {
    public static final String EDITPROFILE = "EditProfile";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edit_profile);

        //bundle data accept start
        final EditText Dname = (EditText) findViewById(R.id.txtname1);
        final EditText Dlast = (EditText) findViewById(R.id.txtlname1);
        final EditText Dcity = (EditText) findViewById(R.id.txtcity1);
        final EditText Deducation = (EditText) findViewById(R.id.txteducation1);
        final EditText Dregistration = (EditText) findViewById(R.id.txteregnum1);
        final EditText Dspeciality = (EditText) findViewById(R.id.txtspeciality1);
        final EditText Dmobile = (EditText) findViewById(R.id.txtmobile1);

        Intent in = getIntent();
        Bundle b = in.getExtras();

        String named = b.getString("Dname");
        String lastnD = b.getString("Dlname");
        String cityD=b.getString("Dcity");
        String educationD=b.getString("Deducation");
        String registrationD=b.getString("Dregistratin");
        String specialityD=b.getString("Dspeciality");
        String mobileD=b.getString("Dmobile");
        
        Dname.setText(named);
        Dlast.setText(lastnD);
        Dcity.setText(cityD);
        Deducation.setText(educationD);
        Dregistration.setText(registrationD);
        Dspeciality.setText(specialityD);
        Dmobile.setText(mobileD);
        //bundle data accept end.

        Button submit=(Button)findViewById(R.id.txtsubmit1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //shared preference
               /* SharedPreferences.Editor editor = getSharedPreferences(EDITPROFILE, MODE_PRIVATE).edit();
                editor.putString("Doctorname",Dname.getText().toString());
                editor.commit();*/
                Intent i=new Intent(EditProfile.this, Dashboard.class);
                startActivity(i);
                //shared preference
            }
        });
    }
}
