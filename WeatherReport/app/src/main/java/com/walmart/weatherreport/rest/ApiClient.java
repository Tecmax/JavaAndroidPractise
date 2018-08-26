package com.walmart.weatherreport.rest;

/**
 * Created by raheem on 28-01-2017.
 */

import android.util.Log;

import java.io.IOException;

import okhttp3.Dispatcher;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    public static final String BASE_URL = "http://api.openweathermap.org/";
    private static Retrofit retrofitEndPointHeaders = null;
    private static Retrofit retrofitEndPointNoHeaders = null;
    private static Retrofit retrofitSms = null;
    private static Dispatcher mDispatcher = new Dispatcher();
    private static OkHttpClient mHttpClient;

    public static Retrofit getBaseClient(boolean isHeadersRequired) {
        if (isHeadersRequired) {
            if (retrofitEndPointHeaders == null) {
                retrofitEndPointHeaders = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .client(getHttpClient(isHeadersRequired))
                        .build();
            }
            return retrofitEndPointHeaders;
        } else {
            if (retrofitEndPointNoHeaders == null) {
                retrofitEndPointNoHeaders = new Retrofit.Builder()
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
            }
            return retrofitEndPointNoHeaders;
        }

    }


    public static Dispatcher getDispatcher() {
        if (mDispatcher == null)
            mDispatcher = new Dispatcher();
        return mDispatcher;
    }

    public static OkHttpClient getHttpClient(boolean isHeadersRequired) {
        if (mHttpClient == null) {
            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(
                    new HttpLoggingInterceptor.Logger() {
                        @Override
                        public void log(String message) {
                            Log.i("ApiClient", message);
                        }
                    }
            );
            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
            httpClient.addInterceptor(loggingInterceptor);
            httpClient.dispatcher(getDispatcher());
            httpClient.addInterceptor(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Request original = chain.request();

                    Request.Builder builder = original.newBuilder();
//                    if (AppPrefSettings.getActiveUser() != null)
//                        builder.header("Cookie", AppPrefSettings.getActiveUser().getCookieToken())
//                                .header("X-CSRF-TOKEN", AppPrefSettings.getActiveUser().getXcsrfToken());

                    Request request = builder
                            .method(original.method(), original.body())
                            .build();

                    return chain.proceed(request);
                }
            });
            mHttpClient = httpClient.build();
        }
        return mHttpClient;
    }

}