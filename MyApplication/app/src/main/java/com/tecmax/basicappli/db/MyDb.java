package com.tecmax.basicappli.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by DELL PC on 09-Feb-18.
 */

public class MyDb extends SQLiteOpenHelper {

    private final static int version = 1;
    private final static String db_Name = "my.db";

    // User Table Columns
    public static final String KEY_USERNAME = "username";
    public static final String KEY_PASSWORD = "password";

    // Tables In Db
    private static final String TABLE_USER = "user";


    //SQL Queries
    private static final String CREATE_USER = " CREATE TABLE " + TABLE_USER
            + " (" + KEY_USERNAME + " TEXT, "
            + KEY_PASSWORD + " TEXT " + ");";

    public MyDb(Context context) {
        super(context, db_Name, null, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion == 0) {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);
            onCreate(db);
        }
    }

    public long insertUser(Usere user) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(KEY_USERNAME, user.getUsername());
        contentValues.put(KEY_PASSWORD, user.getPassword());
        return database.insert(TABLE_USER, null, contentValues);
    }


    public List<Usere> getUsers() {
        SQLiteDatabase database = this.getReadableDatabase();
        List<Usere> usereList = new ArrayList<>();
        Cursor c = database.rawQuery("Select * FROM " + TABLE_USER,null);
        if (c.moveToFirst()){
            do {
                Usere ff= new Usere();
                ff.setUsername(c.getString(c.getColumnIndex(KEY_USERNAME)));
                ff.setPassword(c.getString(c.getColumnIndex(KEY_PASSWORD)));
                usereList.add(ff);
            }while (c.moveToNext());
        }
        return usereList;
    }
}
