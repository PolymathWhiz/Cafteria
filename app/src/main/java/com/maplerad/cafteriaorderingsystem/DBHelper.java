package com.maplerad.cafteriaorderingsystem;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by Polygod on 5/17/18.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "cafetee.db";
    public static final String TABLE_NAME = "user_table";

    public static final String COL_1 = "fname";
    public static final String COL_2 = "email";
    public static final String COL_3 = "mobile_number";
    public static final String COL_4 = "password";


    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, 1); // create the database

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + " (id integer primary key autoincrement, fname text,  email text, " +
                "mobile_number text, password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public boolean insertdata(String Fname, String Email, String Password){

        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_1, Fname);
        contentValues.put(COL_2, Email);
        contentValues.put(COL_4, Password);

        long result = db.insert(TABLE_NAME,null, contentValues);

        if (result == -1){
            return false;
        }
        else {
            return true;
        }
    }

    public boolean signInGetData(String em, String pas){

        boolean isPresent = false;

        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select " +COL_2+", "+COL_4+" from " + TABLE_NAME + " where " +COL_2 + " = '" + em + "' AND " +COL_4+ " = '" + pas + "'";
        Cursor res = db.rawQuery(query, null);

        if (res.getCount()>=1){
            isPresent = true;
            Log.d("login", "authenticated");
        }else{
            isPresent = false;
            Log.d("login", "failed");
        }
        return isPresent;
    }
}
