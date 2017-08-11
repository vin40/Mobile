package com.example.shree.materialdesign8;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;


import com.example.shree.materialdesign8.vinod.navigationdrawer.Dashboard;
import com.example.shree.materialdesign8.vinod1.alertregistration.LoginAlert;
import com.example.shree.materialdesign8.vinod1.alertregistration.UserInformation;
import com.example.shree.materialdesign8.vinod1.alertregistration.UserInformation1;
import com.example.shree.materialdesign8.vinod1.alertregistration.UserInformation1a;
import com.example.shree.materialdesign8.vinod1.alertregistration.UserInformation1h;
import com.example.shree.materialdesign8.vinod1.alertregistration.UserInformation1o;
import com.example.shree.materialdesign8.vinod1.alertregistration.UserInformation1s;
import com.example.shree.materialdesign8.vinod1.alertregistration.UserInformation1v;
import com.example.shree.materialdesign8.vinod11.editprofile.RegisterProfile;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.ShowDetailsActivity;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.Specility;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter3;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter33;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter4;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter44;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter5;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter55;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter6;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter66;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter7;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter77;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter8;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter88;
import com.maksim88.passwordedittext.PasswordEditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Otp extends AppCompatActivity {

    String Dfname,Dlname,Dcity,Dmob;
    final Context c = this;
    PasswordEditText pwText,repwText;
    EditText Inputuser,Email;
    AutoCompleteTextView acTextView;
    MultiAutoCompleteTextView auto;
    public static final String OTP = "Myotp";
    public static final String ROOT_URL = "http://35.154.210.22/";

    //public static final String ENAME="ename";
   // public static final String ELNAME="elname";
   // public static final String ECITY="ecity";
   // public static final String EREGISTNUM="registnum";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);



        Button b=(Button) findViewById(R.id.dashboard);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
             /*   Intent i=new Intent(Otp.this, Dashboard.class);
                startActivity(i);*/

/*
                LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialog_box,null);
                final AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

               */
/* final EditText userInputDialogEditText = (EditText) mView.findViewById(R.id.userInputDialog);
                final EditText uname=(EditText)mView.findViewById(R.id.userInputDialog);
                final EditText ulastname=(EditText)mView.findViewById(R.id.userlastname);
                final EditText ucity=(EditText)mView.findViewById(R.id.usercity);
                final EditText uregistration=(EditText)mView.findViewById(R.id.userregistration);
*//*

                alertDialogBuilderUserInput
                        .setCancelable(false)
                        .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogBox, int id) {
                                // ToDo get user input here


                            }
                        })


                        .setNegativeButton("Cancel",
                                new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialogBox, int id) {

                                        dialogBox.cancel();
                                    }
                                });

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();
*/            LayoutInflater layoutInflaterAndroid = LayoutInflater.from(c);
                View mView = layoutInflaterAndroid.inflate(R.layout.user_input_dialog_box2,null);
                final AlertDialog.Builder alertDialogBuilderUserInput = new AlertDialog.Builder(c);
                alertDialogBuilderUserInput.setView(mView);

                final Button uname=(Button)mView.findViewById(R.id.userInputDialog);
                final Button ulastname=(Button)mView.findViewById(R.id.userlastname);

                uname.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        eduction();
                    }
                });

                ulastname.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent i=new Intent(Otp.this, SelectQualification.class);
                        startActivity(i);
                    }
                });
                alertDialogBuilderUserInput
                        .setCancelable(true);

                AlertDialog alertDialogAndroid = alertDialogBuilderUserInput.create();
                alertDialogAndroid.show();



            }


        });

    }


    void eduction()
    {
        final CharSequence[] items = {"Allopathic Doctor", "Ayush Medicine Practitioner","Homeopathy","Siddha Medicine","Vetrinary Doctor","Other"};

        AlertDialog.Builder builder = new AlertDialog.Builder(Otp.this);
        builder.setCancelable(false);
        builder.setTitle("I Am-");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Allopathic Doctor")) {

                    Intent i=new Intent(Otp.this, UserInformation1.class);
                    startActivity(i);

                }




                else if (items[item].equals("Ayush Medicine Practitioner"))
                {
                    Intent i=new Intent(Otp.this, UserInformation1a.class);
                    startActivity(i);



                    //Intent i=new Intent(LoginAlert.this, SpecilityAyush1.class);
                    //startActivity(i);


                }

                else if (items[item].equals("Homeopathy")) {


                    Intent i=new Intent(Otp.this, UserInformation1h.class);
                    startActivity(i);


                }

               /* else if (items[item].equals("Undergraduate Student")) {

                    Intent i=new Intent(Otp.this, SelectQualification.class);
                    startActivity(i);
                }*/
                else if (items[item].equals("Siddha Medicine")) {

                    //Intent i=new Intent(LoginAlert.this, SpecilitySiddha.class);
                    //startActivity(i);

                    Intent i=new Intent(Otp.this, UserInformation1s.class);
                    startActivity(i);


                }
                else if (items[item].equals("Vetrinary Doctor")) {


                    // Intent i=new Intent(LoginAlert.this, SpecilityVetrinary.class);
                    //startActivity(i);
                    Intent i=new Intent(Otp.this, UserInformation1v.class);
                    startActivity(i);


                }
                else if (items[item].equals("Other")) {
                    //dialog.dismiss();
                    Intent i=new Intent(Otp.this, UserInformation1o.class);
                    startActivity(i);

                }
            }
        });
        builder.show();
    }
    void showtoast(String title,String message)
    {
        AlertDialog.Builder b=new AlertDialog.Builder(this);
        b.setCancelable(true);
        b.setMessage(message);
        b.show();
    }
}
