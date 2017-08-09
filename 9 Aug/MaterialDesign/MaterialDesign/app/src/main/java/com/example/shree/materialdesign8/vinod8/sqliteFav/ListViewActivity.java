package com.example.shree.materialdesign8.vinod8.sqliteFav;





import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.shree.materialdesign8.R;
import com.example.shree.materialdesign8.vinod.SqliteFav.MainActivity;

import java.util.ArrayList;

/**
 * Created by Vinod on 5/14/2017.
 */
public class ListViewActivity extends Activity {

    SQLiteHelper SQLITEHELPER;
    SQLiteDatabase SQLITEDATABASE;
    Cursor cursor;
    SQLiteListAdapter ListAdapter ;

    ArrayList<String> ID_ArrayList = new ArrayList<String>();
    ArrayList<String> NAME_ArrayList = new ArrayList<String>();
    /* ArrayList<String> PHONE_NUMBER_ArrayList = new ArrayList<String>();
     ArrayList<String> SUBJECT_ArrayList = new ArrayList<String>();*/
    ListView LISTVIEW;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view2);

        LISTVIEW = (ListView) findViewById(R.id.listView1);


        SQLITEHELPER = new SQLiteHelper(this);

        Button b=(Button)findViewById(R.id.next3);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Fav3.class);
                startActivity(i);
            }
        });

    }

    @Override
    protected void onResume() {

        ShowSQLiteDBdata() ;

        super.onResume();
    }

    private void ShowSQLiteDBdata() {

        SQLITEDATABASE = SQLITEHELPER.getWritableDatabase();

        cursor = SQLITEDATABASE.rawQuery("SELECT * FROM demoTable13", null);

        ID_ArrayList.clear();
        NAME_ArrayList.clear();
        /*PHONE_NUMBER_ArrayList.clear();
        SUBJECT_ArrayList.clear();*/

        if (cursor.moveToFirst()) {
            do {
                ID_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_ID)));

                NAME_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_Name)));

            	/*PHONE_NUMBER_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_PhoneNumber)));

            	SUBJECT_ArrayList.add(cursor.getString(cursor.getColumnIndex(SQLiteHelper.KEY_Subject)));*/

            } while (cursor.moveToNext());
        }
        LISTVIEW.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        ListAdapter = new SQLiteListAdapter(ListViewActivity.this,

                ID_ArrayList,
                NAME_ArrayList
        	/*	PHONE_NUMBER_ArrayList,
        		SUBJECT_ArrayList*/

        );
        //set multiple selection mode

        LISTVIEW.setAdapter(ListAdapter);
        LISTVIEW.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ListViewActivity.this, "You Clicked"+NAME_ArrayList.get(position), Toast.LENGTH_SHORT).show();
            }
        });
        cursor.close();
    }
}
