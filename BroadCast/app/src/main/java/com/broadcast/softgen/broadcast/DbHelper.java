package com.broadcast.softgen.broadcast;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mahesh on 14-06-2017.
 */

public class DbHelper extends SQLiteOpenHelper {
    public static final String CREATE_TABLE = "CREATE TABLE " + DbContract.TABLE_NAME +
            "(id integer primary key autoincrement," + DbContract.INCOMING_NUMBER + " text);";
    public static final String DROP_TABLE = "drop table if exists " + DbContract.TABLE_NAME;

    public DbHelper(Context context) {
        super(context, DbContract.DATABASE_NAME, null, DbContract.DATABASE_VERSION);
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

    public void saveNumber(String number, SQLiteDatabase sqLiteDatabase) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbContract.INCOMING_NUMBER, number);
        sqLiteDatabase.insert(DbContract.TABLE_NAME, null, contentValues);
    }

    public Cursor readNumber(SQLiteDatabase sqLiteDatabase) {
        String[] projections = {"id", DbContract.INCOMING_NUMBER};
        return (sqLiteDatabase.query(DbContract.TABLE_NAME, projections, null, null, null, null, null));
    }
}
