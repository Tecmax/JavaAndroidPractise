package com.example.mahesha.zomato.rest;

import com.example.mahesha.zomato.model.CollectionResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface APIInterface {

    @Headers("user-key: d553d21b7e7d78154559d98277b8d1c8")
    @GET("collections")
    Call<CollectionResponse> getCollectionList(@Query("city_id") int CityId);

    @GET("cities")
    Call<CollectionResponse> getCitiesList();

    @GET("categories")
    Call<CollectionResponse> getCategoriesList();

}
