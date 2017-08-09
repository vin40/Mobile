package com.example.shree.materialdesign8.vinod9.sqliteFav;



import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shree.materialdesign8.R;

/**
 * Created by Vinod on 5/14/2017.
 */
public class EditDataActivity extends Activity {

    Button nextbutton, previousbutton, updatebutton, deletebutton;

    EditText name, phoneNumber, SubJect;

    SQLiteDatabase SQLITEDATABASE, SQLITEDATABASE2 ;

    String GetSQliteQuery, UpdateRecordQuery, DeleteQuery ;

    Cursor cursor, cursorCheckDataIsEmptyOrNot ;

    TextView idtextview;

    Boolean CheckEditTextEmpty;

    String GetName,GetPhoneNumber,GetSubject ;

    int UserID ;

    String ConvertUserID ;

    SQLiteHelper SQLITEHELPER;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_data4);

        nextbutton = (Button)findViewById(R.id.button1);
        previousbutton = (Button)findViewById(R.id.button2);
        updatebutton = (Button)findViewById(R.id.button3);
        deletebutton = (Button)findViewById(R.id.button4);

        name = (EditText)findViewById(R.id.editText1);
		/*phoneNumber = (EditText)findViewById(R.id.editText2);
		SubJect = (EditText)findViewById(R.id.editText3);*/

        idtextview = (TextView)findViewById(R.id.textview1);

        GetSQliteQuery = "SELECT * FROM demoTable19" ;

        SQLITEDATABASE = openOrCreateDatabase("DemoDataBase", Context.MODE_PRIVATE, null);

        cursor = SQLITEDATABASE.rawQuery(GetSQliteQuery, null);

        cursor.moveToFirst();

        GetSQLiteDatabaseRecords();


        nextbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (!cursor.isLast()){

                    cursor.moveToNext();
                }

                GetSQLiteDatabaseRecords();

            }
        });

        previousbutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                if (!cursor.isFirst()){

                    cursor.moveToPrevious();
                }
                GetSQLiteDatabaseRecords();

            }
        });

        updatebutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                GetName = name.getText().toString();
				/*GetPhoneNumber = phoneNumber.getText().toString();
				GetSubject = SubJect.getText().toString();
				*/
                ConvertUserID = idtextview.getText().toString();

                UserID = Integer.parseInt(ConvertUserID);

                UpdateRecordQuery = "UPDATE demoTable19 SET name='" + GetName + "' WHERE id=" + UserID + ";";

                CheckEditTextIsEmptyOrNot(GetName);

                if (CheckEditTextEmpty == false) {

                    SQLITEDATABASE.execSQL(UpdateRecordQuery);

                    cursor = SQLITEDATABASE.rawQuery(GetSQliteQuery, null);

                    cursor.moveToPosition(UserID);

                    Toast.makeText(EditDataActivity.this,"Data Updated Successfully", Toast.LENGTH_LONG).show();

                }else {

                    Toast.makeText(EditDataActivity.this,"Please Fill All the Fields", Toast.LENGTH_LONG).show();

                }


            }
        });

        deletebutton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub

                ConvertUserID = idtextview.getText().toString();

                UserID = Integer.parseInt(ConvertUserID);

                DeleteQuery = "DELETE FROM demoTable19 WHERE id=" + UserID + ";";

                SQLITEDATABASE.execSQL(DeleteQuery);

                Toast.makeText(EditDataActivity.this, "Record Deleted Successfully", Toast.LENGTH_LONG).show();

                cursor = SQLITEDATABASE.rawQuery(GetSQliteQuery, null);

            }
        });
    }

    public void GetSQLiteDatabaseRecords(){

        idtextview.setText(cursor.getString(0));

        name.setText(cursor.getString(1).toString());

		/*	phoneNumber.setText(cursor.getString(2).toString());

			SubJect.setText(cursor.getString(3).toString());*/
    }

    public void CheckEditTextIsEmptyOrNot(String Name){

        if(TextUtils.isEmpty(Name)){

            CheckEditTextEmpty = true ;

        }
        else {
            CheckEditTextEmpty = false ;
        }
    }

}

