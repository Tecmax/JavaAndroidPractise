package com.tecmax.henna.entities;

import java.io.Serializable;

/**
 * Created by DELL PC on 18-Dec-17.
 */

public class Movie implements Serializable {
    private String name;
    private String language;
    private String certificate;
    private String movieDescription;
    private String older;
    private Integer banner;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getCertificate() {
        return certificate;
    }

    public void setCertificate(String certificate) {
        this.certificate = certificate;
    }

    public String getOlder() {
        return older;
    }

    public void setOlder(String older) {
        this.older = older;
    }

    public Integer getBanner() {
        return banner;
    }

    public void setBanner(Integer banner) {
        this.banner = banner;
    }
}
