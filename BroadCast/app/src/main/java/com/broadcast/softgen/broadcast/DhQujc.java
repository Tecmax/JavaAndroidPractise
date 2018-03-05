package com.broadcast.softgen.broadcast;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mahesh on 29-06-2017.
 */

public class DhQujc extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "sql.db";
    private static final int DATABASE_VERSION = 1;

    private static final String TABLE_PROFILE = "Profile";

    /*PRofile Table columns*/
    private static final String USERNAME = "username";

    public static final String CREATE_TABLE = "CREATE TABLE" + TABLE_PROFILE +
            "(id integer primary key autoincrement, " + USERNAME + " text, password text);";
    public static final String DROP_TABLE = "drop table if exists Profile";

    public DhQujc(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public void saveUserDetails(String username, String Password, SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(USERNAME, username);
        contentValues.put("password", Password);
        sqLiteDatabase.insert(TABLE_PROFILE, null, contentValues);
    }

    public Cursor readFields(SQLiteDatabase sqLiteDatabase) {
        String[] projections = {"id", "username", "password"};
        return (sqLiteDatabase.query(TABLE_PROFILE, projections, null, null, null, null, null));
    }
}
