package com.example.mahesha.model;

import android.util.Log;

import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by Raheemuddin.Syed on 10-11-2016.
 */

public class User implements Serializable {
    private  long uid;
    private String name;
    private String mail;
    private String status="1";
    private String token;

    public  User(){}

    public User(long uid, String name, String mail) {
        this.uid = uid;
        this.name = name;
        this.mail = mail;
    }

    public User(String token,JSONObject jsonObject){
        try {
            this.token=token;
            this.uid = jsonObject.getInt("uid");
            this.name = jsonObject.getString("name");
            this.mail = jsonObject.getString("mail");
            this.status = jsonObject.getString("status");
        }catch (Exception ex){
            Log.e(this.getClass().getSimpleName(),"Json Parse Error:"+ex.getCause());
            ex.printStackTrace();
        }
    }

    public long getUid() {
        return uid;
    }

    public void setUid(long uid) {
        this.uid = uid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}