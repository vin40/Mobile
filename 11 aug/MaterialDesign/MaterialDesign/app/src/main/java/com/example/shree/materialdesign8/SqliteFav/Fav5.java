package com.example.shree.materialdesign8.SqliteFav;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.spinnerFav.FavEdit4;
import com.example.shree.materialdesign8.spinnerFav.FavName4;
import com.example.shree.materialdesign8.vinod9.sqliteFav.*;

public class Fav5 extends AppCompatActivity {

    EditText GetName,GetPhoneNumber,GetSubject;
    Button Submit, EditData, DisplayData;
    SQLiteDatabase SQLITEDATABASE;
    String Name, PhoneNumber, Subject ;
    Boolean CheckEditTextEmpty ;
    String SQLiteQuery ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fav5);

       /* Button edit4=(Button)findViewById(R.id.button_edit);

        edit4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent7=new Intent(getApplicationContext(),FavEdit4.class);
                startActivity(intent7);
            }
        });

        Button name4=(Button)findViewById(R.id.button_change);

        name4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent8=new Intent(getApplicationContext(),FavName4.class);
                startActivity(intent8);}
        });*/
        GetName = (EditText)findViewById(R.id.editText1);

      /*  GetPhoneNumber = (EditText)findViewById(R.id.editText2);

        GetSubject = (EditText)findViewById(R.id.editText3);*/

        Submit = (Button)findViewById(R.id.button1);

        EditData = (Button)findViewById(R.id.button2);

        DisplayData = (Button)findViewById(R.id.button3);

        Submit.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                DBCreate();

                SubmitData2SQLiteDB();

            }
        });

        EditData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(Fav5.this,EditDataActivity.class);
                startActivity(intent);

            }
        });

        DisplayData.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                Intent intent = new Intent(Fav5.this, ListViewActivity.class);
                startActivity(intent);

            }
        });

    }

    public void DBCreate(){

        SQLITEDATABASE = openOrCreateDatabase("DemoDataBase", Context.MODE_PRIVATE, null);

        SQLITEDATABASE.execSQL("CREATE TABLE IF NOT EXISTS demoTable(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, name VARCHAR);");
    }

    public void SubmitData2SQLiteDB(){

        Name = GetName.getText().toString();

        /*PhoneNumber = GetPhoneNumber.getText().toString();

        Subject = GetSubject.getText().toString();
        */
        CheckEditTextIsEmptyOrNot(Name);

        if(CheckEditTextEmpty == true)
        {

            SQLiteQuery = "INSERT INTO demoTable (name) VALUES('"+Name+"');";

            SQLITEDATABASE.execSQL(SQLiteQuery);

            Toast.makeText(Fav5.this,"Data Submit Successfully", Toast.LENGTH_LONG).show();

            ClearEditTextAfterDoneTask();

        }
        else {

            Toast.makeText(Fav5.this,"Please Fill All the Fields", Toast.LENGTH_LONG).show();
        }
    }

    public void CheckEditTextIsEmptyOrNot(String Name)
    {

        if(TextUtils.isEmpty(Name) )
        {

            CheckEditTextEmpty = false ;

        }
        else
        {
            CheckEditTextEmpty = true ;
        }
    }

    public void ClearEditTextAfterDoneTask()
    {

        GetName.getText().clear();
       /* GetPhoneNumber.getText().clear();
        GetSubject.getText().clear();*/
    }
}
