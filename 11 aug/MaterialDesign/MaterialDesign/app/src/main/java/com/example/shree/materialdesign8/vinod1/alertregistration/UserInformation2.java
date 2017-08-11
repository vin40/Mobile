package com.example.shree.materialdesign8.vinod1.alertregistration;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.Toast;

import com.example.shree.materialdesign8.Login;
import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.vinod.navigationdrawer.Dashboard;
import com.example.shree.materialdesign8.vinod4.setfavorite.SetFavorite;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter3;
import com.example.shree.materialdesign8.vinod6.autocompletetextviewjson.SuggestionAdapter33;
import com.maksim88.passwordedittext.PasswordEditText;

public class UserInformation2 extends AppCompatActivity {
    public static final String user = "User";
    SQLiteDatabase SQLITEDATABASE;
    String Dfname,Dlname,Dcity,Dmob;
    final Context c = this;
    Button skip,complete;
    Boolean CheckEditTextEmpty ;
    String SQLiteQuery ;
    EditText Inputuser,Email;
    AutoCompleteTextView acTextView;
    MultiAutoCompleteTextView auto;
    public static final String OTP = "Myotp";
    EditText uname;
    String Name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.addressactivity);

         uname=(EditText)findViewById(R.id.userInputadd);
        final EditText ulastname=(EditText)findViewById(R.id.userInputadd2);
        final EditText uname1=(EditText)findViewById(R.id.userInputaddC);
        final EditText ulastname1=(EditText)findViewById(R.id.userInputaddc2);

        skip=(Button)findViewById(R.id.skip);
        complete=(Button)findViewById(R.id.nextfinal);
        skip.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(UserInformation2.this);
                builder.setTitle("User Information !!");
                builder.setCancelable(false);
                builder.setMessage(getResources().getString(R.string.registration));
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent i = new Intent(UserInformation2.this, Login.class);
                        finish();
                        startActivity(i);
                    }
                });
                builder.setNegativeButton("Cancel", null);
                builder.show();

            }
        });

        complete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (uname.getText().toString().trim().length()== 0) {
                    uname.setError("Please Enter First Name");


                }

                else if (ulastname.getText().toString().trim().length()== 0) {
                    ulastname.setError("Please Enter Last Name");


                }
                else if (uname1.getText().toString().trim().length()== 0) {
                    uname1.setError("Please Enter First Name");


                }

                else if (ulastname1.getText().toString().trim().length()== 0) {
                    ulastname1.setError("Please Enter Last Name");


                }
                else
                {


               // showAlert();
                    DBCreate();

                    SubmitData2SQLiteDB();

                }
            }
        });




    }

    void showAlert()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(UserInformation2.this);
        builder.setTitle("Registration Complete !!");
        builder.setCancelable(false);
        builder.setMessage(getResources().getString(R.string.registration));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(UserInformation2.this, Login.class);
                finish();
                startActivity(i);
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }

    public void DBCreate(){


        SQLITEDATABASE = openOrCreateDatabase("DemoDataBase", Context.MODE_PRIVATE, null);
        //SQLITEDATABASE.execSQL("DROP TABLE IF EXISTS Address ");
        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS Address (id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, street VARCHAR);");
    }

    public void SubmitData2SQLiteDB(){

        Name = uname.getText().toString();

        /*PhoneNumber = GetPhoneNumber.getText().toString();

        Subject = GetSubject.getText().toString();
        */
        CheckEditTextIsEmptyOrNot(Name);

        if(CheckEditTextEmpty == true)
        {


            SQLiteQuery = "INSERT INTO Address (street) VALUES('"+Name+"');";

            SQLITEDATABASE.execSQL(SQLiteQuery);

            Toast.makeText(UserInformation2.this,"Data Submit Successfully", Toast.LENGTH_LONG).show();

            ClearEditTextAfterDoneTask();

        }
        else {

            Toast.makeText(UserInformation2.this,"Please Fill All the Fields", Toast.LENGTH_LONG).show();
        }
    }

    public void CheckEditTextIsEmptyOrNot(String Name){

        if(TextUtils.isEmpty(Name) ){

            CheckEditTextEmpty = false ;

        }
        else {
            CheckEditTextEmpty = true ;
        }
    }

    public void ClearEditTextAfterDoneTask(){

        uname.getText().clear();
       /* GetPhoneNumber.getText().clear();
        GetSubject.getText().clear();auto*/

    }


    void alertshow()
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(UserInformation2.this);
        builder.setTitle("Address Added...!!");
        builder.setCancelable(false);
        builder.setMessage(getResources().getString(R.string.favadd));
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent i = new Intent(UserInformation2.this, SetFavorite.class);
                startActivity(i);
            }
        });
        builder.setNegativeButton("Cancel", null);
        builder.show();
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
