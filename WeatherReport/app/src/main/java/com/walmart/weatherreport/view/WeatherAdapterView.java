package com.walmart.weatherreport.view;

public interface WeatherAdapterView {

    void setTempType(String main,String type);

    void setLocation(String location);

    void setTemperature(double minTemperature,double maxTemperature);

}
