package com.example.shree.materialdesign8.vinod1.alertregistration;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vinod on 5/14/2017.
 */
public class SQLiteHelperAddress extends SQLiteOpenHelper {

    static String DATABASE_NAME="DemoDataBase";

    public static final String KEY_ID="id";

    public static final String TABLE_NAME="Address";


    public static final String KEY_Name="street";

   /* public static final String KEY_PhoneNumber="phone_number";

    public static final String KEY_Subject="subject";*/

    public SQLiteHelperAddress(Context context) {

        super(context, DATABASE_NAME, null, 7);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

         String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+KEY_ID+" INTEGER PRIMARY KEY, "+KEY_Name+" VARCHAR)";
        database.execSQL(CREATE_TABLE);

        database.execSQL("INSERT INTO Address (id,street) VALUES(100,'panvel');");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(db);

    }


    public Cursor getAll()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res=  db.rawQuery("Select * from "+TABLE_NAME,null);

        return res;
    }



}
