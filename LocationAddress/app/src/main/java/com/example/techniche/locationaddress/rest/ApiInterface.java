package com.example.techniche.locationaddress.rest;

/**
 * Created by raheem on 28-01-2017.
 */

import com.example.techniche.locationaddress.entities.LocationDetails;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface ApiInterface {

    @GET("maps/api/geocode/json")
    Call<LocationDetails> getLatLong(@Query("address") String address, @Query("sensor") boolean sensor,@Query("key") String key);

    @GET("maps/api/geocode/json")
    Call<LocationDetails> getAddress(@Query("latlng") String address,@Query("key") String key);
}