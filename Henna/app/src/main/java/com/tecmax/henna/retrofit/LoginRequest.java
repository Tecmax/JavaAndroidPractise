package com.tecmax.henna.retrofit;

import com.google.gson.annotations.SerializedName;

/**
 * Created by raheem on 28-01-2017.
 */

public class LoginRequest {
    @SerializedName("username")
    private String userName;
    @SerializedName("password")
    private String password;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
