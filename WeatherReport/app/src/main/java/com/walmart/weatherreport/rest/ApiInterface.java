package com.walmart.weatherreport.rest;

/**
 * Created by raheem on 28-01-2017.
 */

import com.walmart.weatherreport.model.WeatherResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {


//    @GET("/data/2.5/find")
//    Observable<WeatherResponse> sendRequest(@Query("q") String place, @Query("appid") String appID);


    @GET("/data/2.5/find")
    Call<WeatherResponse> sendRequest(@Query("q") String place, @Query("appid") String appID);

}