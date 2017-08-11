package com.example.shree.materialdesign8.vinod11.editprofile;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shree.materialdesign8.Login;
import com.example.shree.materialdesign8.Main4Activity;
import com.example.shree.materialdesign8.Otp;
import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.login.MainActivity;
import com.example.shree.materialdesign8.vinod1.alertregistration.Address1;
import com.example.shree.materialdesign8.vinod1.alertregistration.LoginAlert;

public class RegisterProfile extends AppCompatActivity {

    String Dfname;
    String Dlname;
    String Dcity;
    String Dmob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.register_profile);

        Toolbar toolbar = (Toolbar)findViewById(R.id.toolbar);
        toolbar.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        toolbar.setNavigationIcon(getResources().getDrawable(R.drawable.backk));
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ib1=new Intent(RegisterProfile.this,Login.class);
                startActivity(ib1);
            }
        });

        Button  editprofile=(Button)findViewById(R.id.txtsubmit);
        Button  addmoreadd1=(Button)findViewById(R.id.txtaddress);



        final TextView textName=(TextView)findViewById(R.id.txtname);
        final TextView textLast=(TextView)findViewById(R.id.txtlname);
        final TextView textcity=(TextView)findViewById(R.id.txtcity);
        final TextView textmobile=(TextView)findViewById(R.id.txtmobile);


        SharedPreferences prefs = getSharedPreferences(LoginAlert.OTP, MODE_PRIVATE);
        String restoredText = prefs.getString("text", null);
        Dfname = prefs.getString("name1", null);
        Dlname = prefs.getString("lastname",null);
        Dcity =prefs.getString("city",null);
        Dmob =prefs.getString("mobile",null);


        textName.setText(Dfname);
        textLast.setText(Dlname);
        textcity.setText(Dcity);
        textmobile.setText(Dmob);

        editprofile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                TextView textna=(TextView)findViewById(R.id.txtname);
                TextView textLa=(TextView)findViewById(R.id.txtlname);
                TextView textci=(TextView)findViewById(R.id.txtcity);
                EditText EditEd=(EditText)findViewById(R.id.txteducation);
                TextView textreg=(TextView)findViewById(R.id.txteregnum);
                EditText textsp=(EditText) findViewById(R.id.txtspeciality);
                TextView textMo=(TextView) findViewById(R.id.txtmobile);


                String textDname = textna.getText().toString();
                String textDlname = textLa.getText().toString();
                String textDCity = textci.getText().toString();
                String textDEducation = EditEd.getText().toString();
                String textDregistration =textreg.getText().toString();
                String textDspeciality = textsp.getText().toString();
                String textDmobilenum = textMo.getText().toString();

                if (textna.getText().toString().length() == 0 && textLa.getText().toString().length() == 0 && textci.getText().toString().length() == 0 && EditEd.getText().toString().length() == 0 && textreg.getText().toString().length() == 0 && textsp.getText().toString().length() == 0 && textMo.getText().toString().length() == 0)
                {
                    Toast.makeText(getApplicationContext(), "plz enter all details", Toast.LENGTH_SHORT).show();
                } else {

                    //Converting phnumber to long type
                    //long phno = Long.parseLong(phnumber1);
                    //Creating Bundle object
                    Bundle buD = new Bundle();

                    //Storing data into bundle
                    buD.putString("Dname", textDname);
                    buD.putString("Dlname", textDlname);
                    buD.putString("Dcity", textDCity);
                    buD.putString("Deducation", textDEducation);
                    buD.putString("Dregistratin", textDregistration);
                    buD.putString("Dspeciality", textDspeciality);
                    buD.putString("Dmobile", textDmobilenum);
                    //Creating Intent object
                    Intent Regp = new Intent(RegisterProfile.this, EditProfile.class);
                    //Storing bundle object into intent
                    Regp.putExtras(buD);
                    startActivity(Regp);

                    //Intent editp = new Intent(RegisterProfile.this, EditProfile.class);
                    //startActivity(editp);
                }
            }
        });

        addmoreadd1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Intent addmore = new Intent(RegisterProfile.this, MainActivity.class);
                //startActivity(addmore);

                Intent addmore = new Intent(RegisterProfile.this,Address1.class);
                startActivity(addmore);
            }
        });
    }
}
