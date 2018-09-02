package com.tecmax.henna.dab;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * Created by DELL PC on 30-Dec-17.
 */

public class DbHelper extends SQLiteOpenHelper {


    private static final String USERNAME = "username";

    public DbHelper(Context context) {
        super(context, "henna.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE "
                + "USER" + "(" + "id" + " INTEGER PRIMARY KEY," + DbHelper.USERNAME
                + " TEXT," + "mobile"
                + " TEXT," + "email"
                + " TEXT," + "address"
                + " TEXT," + "password"
                + " TEXT," + "createdat"
                + " DATETIME" + ")");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + "USER");
        onCreate(sqLiteDatabase);
    }

    public void addUser(UserDetails userDetails) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DbHelper.USERNAME, userDetails.getUsername());
        contentValues.put("mobile", userDetails.getMobile());
        contentValues.put("email", userDetails.getEmail());
        contentValues.put("address", userDetails.getAddress());
        contentValues.put("password", userDetails.getPassword());
        contentValues.put("createdat", getDateTime());
        database.insert("USER", null, contentValues);
    }


    public List<UserDetails> getAllUsers() {
        List<UserDetails> userDetails = new ArrayList<UserDetails>();
        String selectQuery = "SELECT  * FROM " + "USER";

        Log.e("DB Query", selectQuery);

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                UserDetails t = new UserDetails();
                t.setUsername(c.getString((c.getColumnIndex(DbHelper.USERNAME))));
                t.setAddress(c.getString(c.getColumnIndex("address")));
                t.setEmail(c.getString(c.getColumnIndex("email")));
                t.setPassword(c.getString(c.getColumnIndex("password")));
                t.setMobile(c.getString(c.getColumnIndex("mobile")));

                // adding to tags list
                userDetails.add(t);
            } while (c.moveToNext());
        }
        return userDetails;
    }

    /**
     * get datetime
     */
    private String getDateTime() {
        SimpleDateFormat dateFormat = new SimpleDateFormat(
                "yyyy-MM-dd HH:mm:ss", Locale.getDefault());
        Date date = new Date();
        return dateFormat.format(date);
    }
}
