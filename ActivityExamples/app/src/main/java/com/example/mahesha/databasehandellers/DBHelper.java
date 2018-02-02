package com.example.mahesha.databasehandellers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.mahesha.model.ProfileMaster;

import java.util.ArrayList;
import java.util.List;


/**
 * Created by 9Jeevan on 30-08-2016.
 */
public class DBHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "AndroidData.db";
    public static final int DATABASE_VERSION = 1;
    //profile table of profile in gate db
    public static final String TABLE_PROFILE = "Profile";
    public static final String TABLE_IMAGE = "image";

    public static final String IMAGE_ID = "id";
    public static final String IMAGE = "image";
    // columns for profile table in db
    private static final String KEY_LOGIN_NAME = "username";
    private static final String KEY_CITY = "city";
    private static final String KEY_STATE = "state";
    private static final String KEY_AREA = "area";
    private static final String KEY_OFFERED = "offered";
    private static final String KEY_REQUIRED = "required";
    private static final String KEY_START_TIME = "start_time";
    private static final String KEY_END_TIME = "end_time";
    private static final String KEY_COST = "cost";
    private static final String KEY_DURATION = "duration";
    private static final String KEY_PASSWORD = "password";
    private static final String IMAGES_TABLE = "ImagesTable";
    //common column names
    private static final String KEY_ID = "id";
    private static final String KEY_CREATED_AT = "created_at";
    private static final String KEY_UPDATED_AT = "updated_at";
    private static final String KEY_MOBILE_NO = "mobileNo";
    private static final String KEY_EMAIL = "email";
    /**
     * Create Table query for profile
     */
    private static final String CREATE_TABLE_PROFILE = "CREATE TABLE " + TABLE_PROFILE + "(" + KEY_ID
            + " INTEGER PRIMARY KEY," + KEY_LOGIN_NAME + " TEXT, " + KEY_MOBILE_NO + " TEXT, " + KEY_EMAIL + " TEXT, "
            + KEY_CITY + " TEXT, " + KEY_STATE + " TEXT, " + KEY_AREA + " TEXT, " + KEY_OFFERED + " TEXT, " + KEY_REQUIRED + " TEXT, "
            + KEY_DURATION + " TEXT, " + KEY_COST + " TEXT, " + KEY_START_TIME + " TEXT, " + KEY_END_TIME + " TEXT, "
            + KEY_PASSWORD + " TEXT, " + KEY_CREATED_AT + " DATETIME, " + KEY_UPDATED_AT + " DATETIME" + ")";
    private static final String CREATE_IMAGES_TABLE =
            "CREATE TABLE " + IMAGES_TABLE + " (" +
                    IMAGE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                    + IMAGE + " BLOB NOT NULL );";
    private SQLiteDatabase mDb;

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        SQLiteDatabase db = this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // creating required tables
        db.execSQL(CREATE_IMAGES_TABLE);
        db.execSQL(CREATE_TABLE_PROFILE);
    }

    public void Reset() {
        this.onUpgrade(this.mDb, 1, 1);
    }


    public DBHelper open() throws SQLException {
        mDb = this.getWritableDatabase();
        return this;
    }

    public void close() {
        mDb.close();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // on upgrade drop older tables
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILE);
        db.execSQL("DROP TABLE IF EXISTS " + CREATE_IMAGES_TABLE);
        onCreate(db);
    }

    public void upgradeVersion1(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_PROFILE);
        onUpgrade(db, ++oldVersion, newVersion);
    }

    public long createProfileUser(ProfileMaster userList) {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.e("values inserted", userList + "");
        ContentValues values = new ContentValues();
        values.put(KEY_ID, userList.getUserID());
        values.put(KEY_LOGIN_NAME, userList.getUsername());
        values.put(KEY_MOBILE_NO, userList.getMobile());
        values.put(KEY_EMAIL, userList.getEmail());
        values.put(KEY_CITY, userList.getCity());
        values.put(KEY_STATE, userList.getState());
        values.put(KEY_AREA, userList.getArea());
        values.put(KEY_OFFERED, userList.getOffered());
        values.put(KEY_REQUIRED, userList.getRequired());
        values.put(KEY_COST, userList.getCost());
        values.put(KEY_DURATION, userList.getDuration());
        values.put(KEY_START_TIME, userList.getStartTime());
        values.put(KEY_END_TIME, userList.getEndTime());
        values.put(KEY_CREATED_AT, userList.getCreatedAt().toString());
        values.put(KEY_UPDATED_AT, userList.getUpdatedAt().toString());
        values.put(KEY_PASSWORD, userList.getPassword());

        // insert row
        db.insert(TABLE_PROFILE, null, values);
        return 1;
    }


    // Insert the image to the Sqlite DB
    public void insertImage(byte[] imageBytes) {
        ContentValues cv = new ContentValues();
        cv.put(IMAGE, imageBytes);
        mDb.insert(IMAGES_TABLE, null, cv);
    }

    // Get the image from SQLite DB
    // We will just get the last image we just saved for convenience...
    public byte[] retreiveImageFromDB(int position) {
        String query = "SELECT * FROM " + IMAGES_TABLE + " WHERE "
                + KEY_ID + " = '" + position + "'";
       /* Cursor cur = mDb.query(true, IMAGES_TABLE, new String[]{IMAGE,},
                null, null, null, null,
                IMAGE_ID + " DESC", "1");*/
        Cursor cur = mDb.rawQuery(query,null);
        if (cur.moveToFirst()) {
            byte[] blob = cur.getBlob(cur.getColumnIndex(IMAGE));
            cur.close();
            return blob;
        }
        cur.close();
        return null;
    }

    public void updateImageFromDB(int position,byte[] imageBytes) {
        String query = "SELECT * FROM " + IMAGES_TABLE + " WHERE "
                + KEY_ID + " = '" + position + "'";
        ContentValues cv = new ContentValues();
        cv.put(IMAGE, imageBytes);
        mDb.update(IMAGES_TABLE, cv, (KEY_ID + " = '" +position + "'"), null);
    }

    public long updateLoginUser(ProfileMaster userList) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_ID, userList.getUserID());
        values.put(KEY_LOGIN_NAME, userList.getUsername());
        values.put(KEY_EMAIL, userList.getEmail());
        values.put(KEY_CITY, userList.getCity());
        values.put(KEY_STATE, userList.getState());
        values.put(KEY_AREA, userList.getArea());
        values.put(KEY_OFFERED, userList.getOffered());
        values.put(KEY_REQUIRED, userList.getRequired());
        values.put(KEY_COST, userList.getCost());
        values.put(KEY_DURATION, userList.getDuration());
        values.put(KEY_START_TIME, userList.getStartTime());
        values.put(KEY_END_TIME, userList.getEndTime());
        values.put(KEY_UPDATED_AT, userList.getUpdatedAt().toString());
        values.put(KEY_PASSWORD, userList.getPassword());
        // insert row
        long login_id = db.update(TABLE_PROFILE, values, (KEY_ID + " = '" + userList.getUserID() + "'"), null);

        return login_id;
    }

    public long editProfileUser(ProfileMaster userList) {
        SQLiteDatabase db = this.getWritableDatabase();
        Log.e("values inserted", userList + "");
        ContentValues values2 = new ContentValues();
        values2.put(KEY_ID, userList.getUserID());
        values2.put(KEY_LOGIN_NAME, userList.getUsername());
        values2.put(KEY_MOBILE_NO, userList.getMobile());
        values2.put(KEY_EMAIL, userList.getEmail());
        values2.put(KEY_CITY, userList.getCity());
        values2.put(KEY_STATE, userList.getState());
        values2.put(KEY_AREA, userList.getArea());
        values2.put(KEY_OFFERED, userList.getOffered());
        values2.put(KEY_REQUIRED, userList.getRequired());
        values2.put(KEY_CREATED_AT, userList.getCreatedAt().toString());
        values2.put(KEY_UPDATED_AT, userList.getUpdatedAt().toString());
        values2.put(KEY_PASSWORD, userList.getPassword());
        // insert row
        db.replace(TABLE_PROFILE, null, values2);
        return 1;
    }

    public List<ProfileMaster> getUserDetails(int mobileNo) {
        List<ProfileMaster> userdetail = new ArrayList<ProfileMaster>();
        String selectQuery = "SELECT * FROM " + TABLE_PROFILE + " WHERE "
                + KEY_ID + " = '" + mobileNo + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null && c.getCount() > 0) {
            if (c.moveToFirst()) {
                try {
                    String userName = c.getString(1);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    do {
                        ProfileMaster master = new ProfileMaster();
                        master.setUsername(c.getString(c.getColumnIndex(KEY_LOGIN_NAME)));
                        master.setEmail((c.getString(c.getColumnIndex(KEY_EMAIL))));
                        master.setMobile((c.getString(c.getColumnIndex(KEY_MOBILE_NO))));
                        master.setCity((c.getString(c.getColumnIndex(KEY_CITY))));
                        master.setState((c.getString(c.getColumnIndex(KEY_STATE))));
                        master.setArea((c.getString(c.getColumnIndex(KEY_AREA))));
                        master.setOffered((c.getString(c.getColumnIndex(KEY_OFFERED))));
                        master.setRequired((c.getString(c.getColumnIndex(KEY_REQUIRED))));
                        master.setCost((c.getString(c.getColumnIndex(KEY_COST))));
                        master.setDuration((c.getString(c.getColumnIndex(KEY_DURATION))));
                        master.setStartTime((c.getString(c.getColumnIndex(KEY_START_TIME))));
                        master.setEndTime((c.getString(c.getColumnIndex(KEY_END_TIME))));
                        master.setPassword((c.getString(c.getColumnIndex(KEY_PASSWORD))));
                        userdetail.add(master);
                    } while (c.moveToNext());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return userdetail;
    }


    public List<ProfileMaster> getuserList(String username) {
        List<ProfileMaster> userdetail = new ArrayList<ProfileMaster>();
        String selectQuery = "SELECT * FROM " + TABLE_PROFILE + " WHERE " + KEY_LOGIN_NAME + " = ? '" + username + "'";
//                 "' AND " + KEY_PASSWORD + " = ? '" + Password + "'";
        Log.e("Sql Query", selectQuery);
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                ProfileMaster userdata = new ProfileMaster();
                userdata.setUsername(c.getString((c.getColumnIndex(KEY_LOGIN_NAME))));
//                userdata.setPassword((c.getString(c.getColumnIndex(KEY_PASSWORD))));
                userdetail.add(userdata);
            } while (c.moveToNext());
        }
        return userdetail;
    }

    public String getValidUser1(String userName) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.query(TABLE_PROFILE, null, " username=?", new String[]{userName}, null, null, null);
        if (cursor.getCount() < 1) // UserName Not Exist
        {
            cursor.close();
            return "NOT EXIST";
        }
        cursor.moveToFirst();
        String username = cursor.getString(cursor.getColumnIndex("username"));
        cursor.close();
        return username;
    }//both are same i think


    public List<ProfileMaster> getPassword(String Password) {
        List<ProfileMaster> userdetail = new ArrayList<ProfileMaster>();
        String selectQuery = "SELECT * FROM " + TABLE_PROFILE + " WHERE " + KEY_PASSWORD + " = '" + Password + "'";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (c.moveToFirst()) {
            do {
                ProfileMaster userdata = new ProfileMaster();

                userdata.setUserID(c.getString((c.getColumnIndex(KEY_ID))));
//                userdata.setPassword((c.getString(c.getColumnIndex(KEY_PASSWORD))));

                userdetail.add(userdata);
            } while (c.moveToNext());
        }
        return userdetail;
    }

}
