package com.example.techniche.locationaddress.rest;

/**
 * Created by raheem on 28-01-2017.
 */

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {
    public static final String LOCATION_BASE_URL = "https://maps.googleapis.com/";
    public static final String DIRECTION_BASE_URL = "https://www.google.com/maps/dir";
    private static Retrofit retrofitLocation = null;

    public static Retrofit getLocationClient() {
        if (retrofitLocation == null) {
            retrofitLocation = new Retrofit.Builder()
                    .baseUrl(LOCATION_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofitLocation;
    }


//    public static OkHttpClient getHttpClient(boolean isHeadersRequired) {
//        if (mHttpClient == null) {
//            HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(
//                    new HttpLoggingInterceptor.Logger() {
//                        @Override
//                        public void log(String message) {
//                            Log.i("KiranaApiClient", message);
//                        }
//                    }
//            );
//            loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
//
//            OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
//            httpClient.addInterceptor(loggingInterceptor);
//            httpClient.dispatcher(getDispatcher());
//            httpClient.addInterceptor(new Interceptor() {
//                @Override
//                public Response intercept(Chain chain) throws IOException {
//                    Request original = chain.request();
//
//                    Request.Builder builder = original.newBuilder();
//                    if (AppPrefSettings.getActiveUser() != null)
//                        builder.header("Cookie", AppPrefSettings.getActiveUser().getCookieToken())
////                                .header("Content-Type", "application/json")
//                                .header("X-CSRF-TOKEN", AppPrefSettings.getActiveUser().getXcsrfToken());
//
//                    Request request = builder
//                            .method(original.method(), original.body())
//                            .build();
//
//                    return chain.proceed(request);
//                }
//            });
//            mHttpClient = httpClient.build();
//        }
//        return mHttpClient;
//    }
}