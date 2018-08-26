package com.walmart.weatherreport.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherList {
    @SerializedName("id")
    private Integer id;
    @SerializedName("name")
    private String name;
    @SerializedName("coord")
    private LatitudeLongitude latitudeLongitude;
    @SerializedName("main")
    private Temperature temperature;
    @SerializedName("dt")
    private Integer dt;
    @SerializedName("wind")
    private Wind wind;
    @SerializedName("sys")
    private Country country;
    @SerializedName("rain")
    private Object rain;
    @SerializedName("snow")
    private Object snow;
    @SerializedName("clouds")
    private Clouds clouds;
    @SerializedName("weather")
    private java.util.List<Weather> weather = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LatitudeLongitude getLatitudeLongitude() {
        return latitudeLongitude;
    }

    public void setLatitudeLongitude(LatitudeLongitude latitudeLongitude) {
        this.latitudeLongitude = latitudeLongitude;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Integer getDt() {
        return dt;
    }

    public void setDt(Integer dt) {
        this.dt = dt;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country sys) {
        this.country = sys;
    }

    public Object getRain() {
        return rain;
    }

    public void setRain(Object rain) {
        this.rain = rain;
    }

    public Object getSnow() {
        return snow;
    }

    public void setSnow(Object snow) {
        this.snow = snow;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public List<Weather> getWeather() {
        return weather;
    }

    public void setWeather(List<Weather> weather) {
        this.weather = weather;
    }
}
