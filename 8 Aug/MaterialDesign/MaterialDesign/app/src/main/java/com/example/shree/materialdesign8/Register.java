package com.example.shree.materialdesign8;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class Register extends AppCompatActivity implements View.OnClickListener {
    //Declaring views
    private EditText editTextName;
    private EditText editTextMobile;
    private EditText editTextUsername;
    private EditText editTextPassword;
    private EditText editTextEmail;
    private EditText editTextQulification;
    private EditText editTextMCI;
    private EditText editTextRUStudent;


    private Button buttonRegister;
    private Button clr;

    private CheckBox checkBox;
    private TextView trcond;

    private Button Gplus;



    private AutoCompleteTextView AutoCompleteTv;
    String[] speciality;
    private AutoCompleteTextView AutoCompleteTv1;
    String[] speciality1;

    //This is our root url
    public static final String ROOT_URL = "http://ec2-35-154-210-22.ap-south-1.compute.amazonaws.com/";

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_register);

        //Initializing Views
        editTextName = (EditText) findViewById(R.id.user);
        editTextMobile=(EditText)findViewById(R.id.mobile);
        editTextUsername = (EditText) findViewById(R.id.uname);
        editTextPassword = (EditText) findViewById(R.id.password);
        editTextEmail = (EditText) findViewById(R.id.email);
        editTextQulification = (EditText) findViewById(R.id.qulification);
        editTextMCI = (EditText) findViewById(R.id.mci);



        AutoCompleteTv=(AutoCompleteTextView)findViewById(R.id.speciality);
        speciality = getResources().getStringArray(R.array.Speciality);

        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.simple_list_item_1,speciality);
        AutoCompleteTv.setThreshold(1);
        AutoCompleteTv.setAdapter(adapter);
        //AutoCompleteTv.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());

        AutoCompleteTv1=(AutoCompleteTextView)findViewById(R.id.subspeciality);
        speciality1 = getResources().getStringArray(R.array.Speciality1);
        ArrayAdapter adapter1=new ArrayAdapter(this,android.R.layout.simple_list_item_1,speciality1);
        AutoCompleteTv1.setThreshold(1);
        AutoCompleteTv1.setAdapter(adapter1);


        editTextRUStudent=(EditText)findViewById(R.id.areyoustudent);
        editTextRUStudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                       /*  EditText text=(EditText)view;
                if(text.length()==0)

                    return;*/
                    Intent rus=new Intent(Register.this,SelectQualification.class);
                    startActivity(rus);



            }
        });

        trcond=(TextView)findViewById(R.id.terms);
        trcond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent trs=new Intent(Register.this,Policy.class);
                startActivity(trs);

            }
        });

        checkBox=(CheckBox)findViewById(R.id.policychecked);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /*Intent chk=new Intent(Register.this,Policy.class);
                chk.putExtra("check",false);
                startActivity(chk);*/
            }
        });


        buttonRegister = (Button) findViewById(R.id.register);
        clr=(Button)findViewById(R.id.clear);

        //Adding listener to button
        buttonRegister.setOnClickListener(this);

        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.clear);
                editTextName.setText("");
                editTextMobile.setText("");
                editTextUsername.setText("");


                editTextPassword.setText("");
                editTextEmail.setText("");
                editTextQulification.setText("");
                editTextMCI.setText("");
                AutoCompleteTv.setText("");
                AutoCompleteTv1.setText("");
                editTextRUStudent.setText("");
                if (checkBox.isChecked()) {
                    checkBox.setChecked(false);
                }
            }
        });






    }
    private void insertUser(){
        //Here we will handle the http request to insert user to mysql db
        //Creating a RestAdapter
        RestAdapter adapter = new RestAdapter.Builder()
                .setEndpoint(ROOT_URL)
                //Setting the Root URL
                .build();
        //Finally building the adapter

        //Creating object for our interface
        RegisterAPI api = adapter.create(RegisterAPI.class);

        //Defining the method insertuser of our interface
        api.insertUser(
                //Passing the values by getting it from editTexts
                editTextName.getText().toString(),
                editTextMobile.getText().toString(),
                editTextUsername.getText().toString(),
                editTextPassword.getText().toString(),
                editTextEmail.getText().toString(),
                editTextQulification.getText().toString(),
                editTextMCI.getText().toString(),
                AutoCompleteTv.getText().toString(),
                AutoCompleteTv1.getText().toString(),

                //Creating an anonymous callback
                new Callback<Response>() {
                    @Override
                    public void success(Response result, Response response) {
                        //On success we will read the server's output using bufferedreader
                        //Creating a bufferedreader object
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
                        Toast.makeText(Register.this, output, Toast.LENGTH_LONG).show();
                        Intent I=new Intent(Register.this,Login.class);
                        startActivity(I);
                    }

                    @Override
                    public void failure(RetrofitError error) {
                        //If any error occured displaying the error as toast
                        Toast.makeText(Register.this, error.toString(),Toast.LENGTH_LONG).show();
                    }
                });
    }

    //Overriding onclick method
    @Override
    public void onClick(View view) {
        if( editTextName.getText().toString().equalsIgnoreCase("")) {
            editTextName.setError("Enter FirstName");
            editTextName.requestFocus();
        }


        else if(editTextMobile.getText().toString().length()==0) {
            editTextMobile.setError("Enter Phone Number");
            editTextMobile.requestFocus();
        }
        else if(editTextMobile.getText().toString().length()<10) {
            editTextMobile.setError("Enter valid number");
            editTextMobile.requestFocus();
        }

        else if(TextUtils.isEmpty(editTextMobile.getText().toString()))
        {
            editTextMobile.setError("wrong number");
            editTextMobile.requestFocus();

        }
        else  if(  editTextUsername.getText().toString().equalsIgnoreCase("")) {
            editTextUsername.setError("Enter UserName");
            editTextUsername.requestFocus();
        }

        else if(editTextPassword.getText().toString().trim().equalsIgnoreCase("")) {
            editTextPassword.setError("Enter Password");
            editTextPassword.requestFocus();
        }
        else if(editTextPassword.getText().toString().length()<4) {
            editTextPassword.setError("please enter atleast 4 digit password");
        }
        else if(editTextEmail.getText().toString().trim().equalsIgnoreCase("")) {
            editTextEmail.setError("Enter Email Id");
            editTextEmail.requestFocus();
        }
        else if(!android.util.Patterns.EMAIL_ADDRESS.matcher(editTextEmail.getText().toString()).matches())
        {
            //Validation for Invalid Email Address
            Toast.makeText(getApplicationContext(), "Invalid Email", Toast.LENGTH_LONG).show();
            editTextEmail.setError("Invalid Email");
            return;
        }

        else if(AutoCompleteTv.getText().toString().trim().equalsIgnoreCase("")) {
            AutoCompleteTv.setError("Enter Email Id");
            AutoCompleteTv.requestFocus();
        }
        else {
            insertUser();
             finish();
        }
    }
}
