package com.tecmax.henna.retrofit;

import com.google.gson.annotations.SerializedName;

public class LoginResponse {
    @SerializedName("sessid")
    private String sessId;
    @SerializedName("session_name")
    private String sessionName;
    @SerializedName("token")
    private String accessToken;
    @SerializedName("user")
    private User user;

    public String getSessId() {
        return sessId;
    }

    public void setSessId(String sessId) {
        this.sessId = sessId;
    }

    public String getSessionName() {
        return sessionName;
    }

    public void setSessionName(String sessionName) {
        this.sessionName = sessionName;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        LoginResponse user = (LoginResponse) o;
        if (accessToken != null ? !accessToken.equals(user.accessToken) : user.accessToken != null)
            return false;
        return true;

    }
}
