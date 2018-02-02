package com.example.mahesha.databasehandellers;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Mahesh on 2/9/2017.
 */

public class DbHandler extends SQLiteOpenHelper{

    public DbHandler(Context context) {
        super(context, "henna.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
