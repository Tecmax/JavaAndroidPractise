package com.tecmax.henna.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by DELL PC on 31-Dec-17.
 */

public interface ApiInterface {

    @POST("kirana11_api/user/login")
    Call<LoginResponse> authenticateUser(@Body LoginRequest loginRequest);

    @GET("api/get_institute_list")
    Call<List<InstituteList>> getInstituteList();

}

