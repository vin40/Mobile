package com.example.shree.materialdesign8.vinod1.alertregistration;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Patterns;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.example.shree.materialdesign8.Otp;
import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.SelectQualification;
import com.example.shree.materialdesign8.LoginWithDiff;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.Specility;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SpecilityAyush1;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SpecilityHomopathic;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SpecilitySiddha;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SpecilityVetrinary;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter;
import com.hbb20.CountryCodePicker;
import com.maksim88.passwordedittext.PasswordEditText;

public class LoginAlert extends AppCompatActivity {

    final Context c = this;
    CountryCodePicker ccp;
    EditText mobile;
    String TAG;
    String code;

    public static final String OTP = "NameLastCity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_alert);
        ccp = (CountryCodePicker) findViewById(R.id.ccp);

        ccp.setOnCountryChangeListener(new CountryCodePicker.OnCountryChangeListener() {
            @Override
            public void onCountrySelected() {
            //  Toast.makeText(LoginAlert.this, "You Slected " + ccp.getSelectedCountryName(), Toast.LENGTH_SHORT).show();

               // Toast.makeText(LoginAlert.this, "You Slected " + ccp.getSelectedCountryCodeWithPlus(), Toast.LENGTH_SHORT).show();

                Log.d(TAG, "changes: " + ccp.getSelectedCountryName());
                //String countryname = ccp.getDefaultCountryCodeWithPlus().toString();
                //EditText editmobcode=(EditText)findViewById(R.id.mobilewithcode);
               // editmobcode.setText(countryname.toString());
                //mobile.setText(ccp.getDefaultCountryCode().toString());

            }
        });

        final EditText mobile=(EditText)findViewById(R.id.mobilewithcode);


        Button getsatart=(Button)findViewById(R.id.getstarted);
        getsatart.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                SharedPreferences.Editor editor1 = getSharedPreferences(OTP, MODE_PRIVATE).edit();
                editor1.putString("mobile", mobile.getText().toString());
                editor1.commit();

                String m = mobile.getText().toString().trim();
                if (m.isEmpty() || !isValidMobile(m) || mobile.getText().toString().toString().length() < 10 || m.length() > 13) {
                    mobile.setError("Please Enter Valid Mobile Number");


                } else {

                    Intent I=new Intent(LoginAlert.this,UserInformation.class);
                    startActivity(I);

                }
            }

        });

        LinearLayout regvtru=(LinearLayout) findViewById(R.id.registervTrue);
        regvtru.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
              Intent regv=new Intent(getApplicationContext(),LoginWithDiff.class);
                startActivity(regv);

            }
        });

    }
    private static boolean isValidMobile(String mobile)
    {
        return !TextUtils.isEmpty(mobile)&& Patterns.PHONE.matcher(mobile).matches();
    }
}
