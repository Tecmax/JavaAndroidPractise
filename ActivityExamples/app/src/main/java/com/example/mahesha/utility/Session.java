package com.example.mahesha.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.example.mahesha.model.User;

/**
 * Created by Syed Raheem Udin on 10/11/2016.
 */
public class Session {
    private SharedPreferences sp;
    private SharedPreferences.Editor spEditor;

    public Session(Context context) {
        sp = PreferenceManager.getDefaultSharedPreferences(context);

    }

    public void removeLoggedUser(){
        spEditor = sp.edit();
        spEditor.remove("uid");
        spEditor.remove("username");
        spEditor.remove("email");
        spEditor.commit();
    }

    public void setLoggedUser(User user){
        spEditor = sp.edit();
        spEditor.putLong("uid", user.getUid());
        spEditor.putString("username", ""+user.getName());
        spEditor.putString("email", ""+user.getMail());
        spEditor.commit();
    }

    public User getLoggedUser(){
        User user=new User(sp.getLong("uid",0),sp.getString("username",""),sp.getString("email",""));
        return user;
    }

    public boolean setLogin(boolean status) {
        spEditor = sp.edit();
        spEditor.putBoolean("is_logged_in1", status);
        spEditor.commit();
        if(status==false)
            removeLoggedUser();
        return true;
    }

    public boolean getLoggedIn() {
        return sp.getBoolean("is_logged_in1", false);
    }
}
