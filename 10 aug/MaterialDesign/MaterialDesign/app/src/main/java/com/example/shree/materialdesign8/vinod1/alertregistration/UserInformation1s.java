package com.example.shree.materialdesign8.vinod1.alertregistration;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.RegisterAPI2;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter3;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter33;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter6;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter66;
import com.maksim88.passwordedittext.PasswordEditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class UserInformation1s extends AppCompatActivity {
    public static final String user = "User";

    String Dfname,Dlname,Dcity,Dmob;
    final Context c = this;
    PasswordEditText pwText,repwText;
    EditText Inputuser,Email,mci;
    AutoCompleteTextView acTextView;
    MultiAutoCompleteTextView auto;
    public static final String OTP = "Myotp";
    public static final String ROOT_URL = "http://35.154.210.22/";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.siddha);

        Inputuser =(EditText)findViewById(R.id.userInputUname);
        Email =(EditText)findViewById(R.id.userInputemail);
        mci =(EditText)findViewById(R.id.mci);
        pwText = (PasswordEditText) findViewById(R.id.input_password);
        repwText = (PasswordEditText) findViewById(R.id.input_password2);
        acTextView = (AutoCompleteTextView) findViewById(R.id.userInputDialog);
        acTextView.setAdapter(new SuggestionAdapter6(UserInformation1s.this, acTextView.getText().toString()));
                            /*AutoCompleteTextView acTextView = (AutoCompleteTextView) findViewById(R.id.userInputDialog);
                            acTextView.setAdapter(new SuggestionAdapter(Otp.this,acTextView.getText().toString()));
*/
        auto = (MultiAutoCompleteTextView)findViewById(R.id.subspeciality);

        auto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        auto.setThreshold(1);
        auto.setAdapter(new SuggestionAdapter66(UserInformation1s.this, auto.getText().toString()));


        Button btnnext1=(Button)findViewById(R.id.btnnext1);
        btnnext1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (Inputuser.getText().toString().trim().length()== 0) {
                    Inputuser.setError("Please Enter Username");


                }
                else if ( mci.getText().toString().trim().length()== 0) {
                    mci.setError("Please Enter Mci/Register No");


                }
               else if ( pwText.getText().toString().trim().length()== 0) {
                    pwText.setError("Please Enter Password");


                }
                else if (repwText.getText().toString().trim().length()== 0) {
                    repwText.setError("Please Enter Re password");


                }
                else  {

                    SharedPreferences prefs = getSharedPreferences(LoginAlert.OTP, MODE_PRIVATE);
                    String restoredText = prefs.getString("text", null);

                    Dmob = prefs.getString("mobile", null);

                    SharedPreferences prefs1 = getSharedPreferences(UserInformation.user, MODE_PRIVATE);
                    String restoredText1 = prefs1.getString("text", null);
                    Dfname = prefs1.getString("name1", null);
                    Dlname = prefs1.getString("lastname", null);
                    Dcity = prefs1.getString("city", null);





                    AlertDialog.Builder builder = new AlertDialog.Builder(UserInformation1s.this);
                    builder.setTitle("User Information !!");
                    builder.setCancelable(true);
                    builder.setMessage(getResources().getString(R.string.userinform));
                    builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            insertuser();
                            Intent i = new Intent(UserInformation1s.this, UserInformation2.class);
                            startActivity(i);
                        }
                    });
                    builder.setNegativeButton("Cancel", null);
                    builder.show();





                }

            }

            private void insertuser() {

                RestAdapter adapter = new RestAdapter.Builder()
                        .setEndpoint(ROOT_URL) //Setting the Root URL
                        .build(); //Finally building the adapter

                //Creating object for our interface
                RegisterAPI2 api = adapter.create(RegisterAPI2.class);
//Hi
                api.insertUser(Dfname.toString(),
                        Dlname.toString(),
                        Dmob.toString(),
                        Dcity.toString(),
                        mci.getText().toString(),
                        "Sidhha",
                        acTextView.getText().toString(),
                        auto.getText().toString(),
                        Inputuser.getText().toString(),
                        Email.getText().toString(),
                        pwText.getText().toString(),
                        repwText.getText().toString(),
                        //
                        new Callback<Response>() {
                            @Override
                            public void success(Response result, Response response2) {
                                BufferedReader reader = null;

                                //An string to store output from the server
                                String output = "";

                                try {
                                    //Initializing buffered reader
                                    reader = new BufferedReader(new InputStreamReader(result.getBody().in()));

                                    //Reading the output in the string
                                    output = reader.readLine();
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                //Displaying the output as a toast
                                Toast.makeText(UserInformation1s.this, output, Toast.LENGTH_LONG).show();

                            }

                            @Override
                            public void failure(RetrofitError error) {
                                Toast.makeText(UserInformation1s.this, error.toString(), Toast.LENGTH_LONG).show();
                            }
                        });

            }


        });



    }
}
