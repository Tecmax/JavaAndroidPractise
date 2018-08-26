package com.walmart.weatherreport.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherResponse {
    @SerializedName("message")
    private String message;
    @SerializedName("cod")
    private String cod;
    @SerializedName("count")
    private Integer count;
    @SerializedName("list")
    private List<WeatherList> list = null;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public List<WeatherList> getWeatherList() {
        return list;
    }

    public void setWeatherList(List<WeatherList> list) {
        this.list = list;
    }
}
