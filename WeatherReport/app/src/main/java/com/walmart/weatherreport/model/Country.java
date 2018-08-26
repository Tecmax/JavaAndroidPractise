package com.walmart.weatherreport.model;

import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("country")
    private String country;

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
