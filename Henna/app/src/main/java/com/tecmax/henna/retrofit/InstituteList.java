package com.tecmax.henna.retrofit;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class InstituteList {
    @SerializedName("id")
    private String id;
    @SerializedName("title")
    private String title;
    @SerializedName("logo")
    private String logo;
    @SerializedName("banner")
    private List<String> banner = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public List<String> getBanner() {
        return banner;
    }

    public void setBanner(List<String> banner) {
        this.banner = banner;
    }
}
