package com.example.shree.materialdesign8.vinod.SqliteFav;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Vinod on 5/14/2017.
 */
public class SQLiteHelper extends SQLiteOpenHelper {

    static String DATABASE_NAME="DemoDataBase";

    public static final String KEY_ID="id";

    public static final String TABLE_NAME="demoTable1";
    public static final String TABLE_NAME1="demoTable10";
    public static final String TABLE_NAME2="demoTable13";
    public static final String TABLE_NAME3="demoTable19";
    public static final String TABLE_NAME4="demoTable20";

    public static final String KEY_Name="name";

   /* public static final String KEY_PhoneNumber="phone_number";

    public static final String KEY_Subject="subject";*/

    public SQLiteHelper(Context context) {

        super(context, DATABASE_NAME, null, 7);

    }

    @Override
    public void onCreate(SQLiteDatabase database) {

         String CREATE_TABLE="CREATE TABLE IF NOT EXISTS "+TABLE_NAME+" ("+KEY_ID+" INTEGER PRIMARY KEY, "+KEY_Name+" VARCHAR)";
        database.execSQL(CREATE_TABLE);
        /*String CREATE_TABLE1="CREATE TABLE "+TABLE_NAME1+" ("+KEY_ID+" INTEGER PRIMARY KEY, "+KEY_Name+" VARCHAR)";
        database.execSQL(CREATE_TABLE1);*/
       /* String CREATE_TABLE2="CREATE TABLE "+TABLE_NAME2+" ("+KEY_ID+" INTEGER PRIMARY KEY, "+KEY_Name+" VARCHAR)";
        database.execSQL(CREATE_TABLE2);
        String CREATE_TABLE3="CREATE TABLE "+TABLE_NAME3+" ("+KEY_ID+" INTEGER PRIMARY KEY, "+KEY_Name+" VARCHAR)";
        database.execSQL(CREATE_TABLE3);
        String CREATE_TABLE4="CREATE TABLE "+TABLE_NAME4+" ("+KEY_ID+" INTEGER PRIMARY KEY, "+KEY_Name+" VARCHAR)";
        database.execSQL(CREATE_TABLE4);*/
       // database.execSQL("INSERT INTO demoTable1 (id,name) VALUES(12,'Maleria');");
        database.execSQL("INSERT INTO demoTable1 (id,name) VALUES(100,'');");
       /* database.execSQL("INSERT INTO demoTable10 (id,name) VALUES(1,'Dengu');");*/
       /* database.execSQL("INSERT INTO demoTable13 (id,name) VALUES(1,'Fever');");
        database.execSQL("INSERT INTO demoTable19 (id,name) VALUES(1,'ChikenGuniya');");
        database.execSQL("INSERT INTO demoTable15 (id,name) VALUES(1,'Typhoid');");*/
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
       /* db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME3);
        db.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME4);*/
        onCreate(db);

    }


    public Cursor getAll()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res=  db.rawQuery("Select * from "+TABLE_NAME,null);

        return res;
    }

    public Cursor getAll1()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res=  db.rawQuery("Select * from "+TABLE_NAME1,null);

        return res;
    }

    public Cursor getAll2()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res=  db.rawQuery("Select * from "+TABLE_NAME2,null);

        return res;
    }
    public Cursor getAll3()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res=  db.rawQuery("Select * from "+TABLE_NAME3,null);

        return res;
    }

    public Cursor getAll4()
    {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor res=  db.rawQuery("Select * from "+TABLE_NAME4,null);

        return res;
    }




}
