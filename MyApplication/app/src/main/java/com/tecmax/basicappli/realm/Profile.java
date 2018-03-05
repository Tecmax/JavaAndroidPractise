package com.tecmax.basicappli.realm;

import io.realm.RealmObject;
import io.realm.annotations.Ignore;
import io.realm.annotations.Required;

/**
 * Created by DELL PC on 12-Feb-18.
 */

public class Profile extends RealmObject {
    private int id;
    @Required
    private String userName;
    private String password;
    @Ignore
    private String emailId;


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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
