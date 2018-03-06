package com.tecmax.testaksh;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Lincoln on 05/05/16.
 */
public class PrefManager {
    SharedPreferences pref;
    SharedPreferences.Editor editor;
    Context _context;

    // shared pref mode
    int PRIVATE_MODE = 0;

    // Shared preferences file name
    private static final String PREF_NAME = "androidhive-welcome";

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String USERNAME = "username";

    public PrefManager(Context context) {
        this._context = context;
        pref = _context.getSharedPreferences(PREF_NAME, PRIVATE_MODE);
        editor = pref.edit();
    }

    public void setRememberMe(boolean isFirstTime) {
        editor.putBoolean(IS_FIRST_TIME_LAUNCH, isFirstTime);
        editor.apply();
    }

    public boolean isRememberMe() {
        return pref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    public void setUserName(String isFirstTime) {
        editor.putString(USERNAME, isFirstTime);
        editor.apply();
    }

    public String getUserName() {
        return pref.getString(USERNAME, "");
    }

}
