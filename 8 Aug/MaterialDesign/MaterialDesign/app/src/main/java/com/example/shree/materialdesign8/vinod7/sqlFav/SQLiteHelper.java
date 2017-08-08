package com.example.shree.materialdesign8.vinod7.sqlFav;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Vinod on 5/14/2017.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME="DemoDataBase";

    public static final String KEY_ID="id";

    public static final String TABLE_NAME="demoTable10";

    public static final String KEY_Name="name";
    private String LOGCAT;

   /* public static final String KEY_PhoneNumber="phone_number";

    public static final String KEY_Subject="subject";*/

    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 7);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

        String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+KEY_ID+" INTEGER PRIMARY KEY, "+KEY_Name+" VARCHAR)";
        database.execSQL(CREATE_TABLE);

     /*  String SQLiteQuery = "INSERT INTO demoTable10 (name) VALUES('raj');";

        database.execSQL(SQLiteQuery);
*/     /*database.execSQL("INSERT INTO " + TABLE_NAME +" VALUES (10 ,'Mumbai')");
        Log.d(LOGCAT, "INSERTED2");*/


        //database.execSQL("INSERT INTO " + TABLE_NAME+ "(id, name) VALUES (10,'mumbai');");
      //  database.execSQL("INSERT INTO"+ TABLE_NAME +" VALUES (10, 'hello');");
       database.execSQL("INSERT INTO demoTable10 (id,name) VALUES(1,'Dengu');");
        Log.d(LOGCAT, "INSERTED2");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }


    public void insertDatum (int id, String name) {
        SQLiteDatabase db =this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_ID, id);
        contentValues.put(KEY_Name, name);

        db.insert(TABLE_NAME, null, contentValues);
    }

}
