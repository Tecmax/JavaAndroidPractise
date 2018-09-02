package com.tecmax.henna.retrofit;


import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

public class User {
    @SerializedName("uid")
    private long userId;
    @SerializedName("name")
    private String mobile;
    @SerializedName("mail")
    private String email;
    @SerializedName("picture")
    private String profilePicture;
    @SerializedName("created")
    private String userSince;
    @SerializedName("login")
    private String lastLogin;
    @SerializedName("access")
    private String lastAccessed;
    @SerializedName("status")
    private String activeStatus;
    private String cookieToken;
    private String xcsrfToken;
    private boolean tokenSentToServer;
    private boolean notificationEnabled = true;
    @SerializedName("roles")
    private LinkedTreeMap<String, String> roles;

    public User() {
    }

    public String getXcsrfToken() {
        return xcsrfToken;
    }

    public void setXcsrfToken(String xcsrfToken) {
        this.xcsrfToken = xcsrfToken;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    public String getUserSince() {
        return userSince;
    }

    public void setUserSince(String userSince) {
        this.userSince = userSince;
    }

    public String getLastLogin() {
        return lastLogin;
    }

    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin;
    }

    public String getLastAccessed() {
        return lastAccessed;
    }

    public void setLastAccessed(String lastAccessed) {
        this.lastAccessed = lastAccessed;
    }

    public String getActiveStatus() {
        return activeStatus;
    }

    public void setActiveStatus(String activeStatus) {
        this.activeStatus = activeStatus;
    }

    public String getCookieToken() {
        return cookieToken;
    }

    public void setCookieToken(String cookieToken) {
        this.cookieToken = cookieToken;
    }

    public boolean isTokenSentToServer() {
        return tokenSentToServer;
    }

    public void setTokenSentToServer(boolean tokenSentToServer) {
        this.tokenSentToServer = tokenSentToServer;
    }

    public boolean isNotificationEnabled() {
        return notificationEnabled;
    }

    public void setNotificationEnabled(boolean notificationEnabled) {
        this.notificationEnabled = notificationEnabled;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (userId != user.userId)
            return false;
        if (mobile != null ? !mobile.equals(user.mobile) : user.mobile != null)
            return false;
        return true;

    }

    @Override
    public int hashCode() {
        int result = (int) (userId ^ (userId >>> 32));
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    public LinkedTreeMap<String, String> getRoles() {
        return roles;
    }

    public void setRoles(LinkedTreeMap<String, String> roles) {
        this.roles = roles;
    }
}
