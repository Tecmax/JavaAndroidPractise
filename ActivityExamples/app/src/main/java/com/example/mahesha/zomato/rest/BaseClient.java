package com.example.mahesha.zomato.rest;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseClient {
    private static final String BASE_URL = "https://developers.zomato.com/api/v2.1/";//Dev
    private static Retrofit retrofitEndPoint = null;

    public static Retrofit getBaseClient() {

        if (retrofitEndPoint == null) {
            retrofitEndPoint = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitEndPoint;
    }
}
