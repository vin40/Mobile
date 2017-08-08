package com.example.shree.materialdesign8.vinod1.alertregistration;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.example.shree.materialdesign8.R;


public class Address extends AppCompatActivity {

    SQLiteHelperAddress SQLITEHELPER;
    SQLiteDatabase SQLITEDATABASE;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);
        display();
    }


    private void display() {

        TextView tekst = (TextView) findViewById(R.id.editText1);
        StringBuffer b=new StringBuffer();
        SQLITEHELPER = new SQLiteHelperAddress(getApplicationContext());
        Cursor res=SQLITEHELPER.getAll();
        if (res != null)

            while (res.moveToNext())
            {
                // b.append(res.getString(0));
               /* String emailList=res.getString(1);
                b.append("\n");
                //emailList=emailList.replaceAll(",", "\n");
                b.append(emailList)*/;
                b.append(res.getString(1));
                b.append("\n");
//                   /* String a=res.getString(0);
//                    String b =res.getString(1);*/
            }



        SQLITEHELPER.close();

        Log.d("show",b.toString());
        tekst.setText(b.toString());

               /* Bundle c=new Bundle();
                c.getString("abc",b.toString());
                Intent a=new Intent(ShowDb.this,ConfirmationMassage.class);
                a.putExtras(c);
                startActivity(a);
                Toast.makeText(ShowDb.this,"you "+b.toString(),Toast.LENGTH_LONG).show();*/


    }
}
