package com.tecmax.henna.retrofit;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by DELL PC on 31-Dec-17.
 */

public class BaseClientClass {

//    public static final String BASE_URL = "https://dev.kirana11.com/";//Dev
    public static final String BASE_URL = "http://admin.awsrulers.com";//Dev
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
