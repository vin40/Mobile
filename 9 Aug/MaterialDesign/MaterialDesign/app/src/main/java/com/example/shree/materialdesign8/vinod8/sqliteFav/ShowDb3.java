package com.example.shree.materialdesign8.vinod8.sqliteFav;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.MultiAutoCompleteTextView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.vinod.SqliteFav.MainActivity;
import com.example.shree.materialdesign8.vinod.SqliteFav.SQLiteHelper;

public class ShowDb3 extends AppCompatActivity {
    MultiAutoCompleteTextView auto;
    SQLiteHelper SQLITEHELPER;
    SQLiteDatabase SQLITEDATABASE;
    EditText rename;
    Button set;
    public static final String Fav3 = "Fav3";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_db3);
        Button b=(Button)findViewById(R.id.editfav1);

        rename=(EditText)findViewById(R.id.rename);
        set=(Button)findViewById(R.id.set1);

         set.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {

                 SharedPreferences.Editor editor1 = getSharedPreferences(Fav3, MODE_PRIVATE).edit();
                 editor1.putString("favrename", rename.getText().toString());
                 editor1.commit();
                 Toast.makeText(ShowDb3.this,"Set Favourite set",Toast.LENGTH_LONG);
             }
         });


        /*auto = (MultiAutoCompleteTextView) findViewById(R.id.rename);

        auto.setTokenizer(new MultiAutoCompleteTextView.CommaTokenizer());
        auto.setThreshold(1);
        auto.setAdapter(new SuggestionAdapter(ShowDb.this, auto.getText().toString()));*/
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(),Fav3.class);
                finish();
                startActivity(intent);

            }
        });
       display();
        //display1();

    }

    private void display() {

        TextView tekst = (TextView) findViewById(R.id.editText1);
        StringBuffer b=new StringBuffer();
        SQLITEHELPER = new SQLiteHelper(getApplicationContext());
        Cursor res=SQLITEHELPER.getAll2();
        if (res != null)

            while (res.moveToNext())
            {
                // b.append(res.getString(0));
                String emailList=res.getString(1);
                emailList=emailList.replaceAll(",", "\n");
                b.append(emailList);
                //b.append(res.getString(1));
                //b.append("\n");
//                   /* String a=res.getString(0);
//                    String b =res.getString(1);*/
            }


        //  String[] text = SQLITEHELPER.getAppCategoryDetail(); //this is the method to query

        SQLITEHELPER.close();
        // set text to your TextView
        // set text to your TextView
        tekst.setText(b.toString());

               /* Bundle c=new Bundle();
                c.getString("abc",b.toString());
                Intent a=new Intent(ShowDb.this,ConfirmationMassage.class);
                a.putExtras(c);
                startActivity(a);
                Toast.makeText(ShowDb.this,"you "+b.toString(),Toast.LENGTH_LONG).show();*/


    }


   /* private void display1() {

        TextView tekst = (TextView) findViewById(R.id.editText2);
        StringBuffer b=new StringBuffer();
        SQLITEHELPER = new SQLiteHelper(getApplicationContext());
        Cursor res=SQLITEHELPER.getAll1();
        if (res != null)

            while (res.moveToNext())
            {
                // b.append(res.getString(0));
                b.append(res.getString(1));
                b.append("\n");
//                   *//* String a=res.getString(0);
//                    String b =res.getString(1);*//*
            }


        //  String[] text = SQLITEHELPER.getAppCategoryDetail(); //this is the method to query

        SQLITEHELPER.close();
        // set text to your TextView
        // set text to your TextView
        tekst.setText(b.toString());

               *//* Bundle c=new Bundle();
                c.getString("abc",b.toString());
                Intent a=new Intent(ShowDb.this,ConfirmationMassage.class);
                a.putExtras(c);
                startActivity(a);
                Toast.makeText(ShowDb.this,"you "+b.toString(),Toast.LENGTH_LONG).show();*//*


    }*/
}
