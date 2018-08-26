package com.walmart.weatherreport.model;

import android.text.TextUtils;
import android.util.Log;

import com.walmart.weatherreport.presenter.WeatherPresenter;
import com.walmart.weatherreport.rest.ApiClient;
import com.walmart.weatherreport.rest.ApiInterface;
import com.walmart.weatherreport.view.WeatherView;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.walmart.weatherreport.utils.WeatherConstants.APP_ID;

public class WeatherImpl implements WeatherPresenter {

    private static final String TAG = WeatherImpl.class.getSimpleName();
    WeatherView mWeatherView;

    public WeatherImpl(WeatherView weatherView) {
        this.mWeatherView = weatherView;
    }

    @Override
    public void getWeatherList(String place) {
        if (TextUtils.isEmpty(place)) {
            mWeatherView.weatherValidations();
        } else {
            getWeatherDetails(place);
        }
    }

    private void getWeatherDetails(String place) {
        ApiInterface apiService = ApiClient.getBaseClient(false).create(ApiInterface.class);
        Call<WeatherResponse> call = apiService.sendRequest(place, APP_ID);
        call.enqueue(new Callback<WeatherResponse>() {
            @Override
            public void onResponse(Call<WeatherResponse> call, Response<WeatherResponse> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    mWeatherView.weatherResultsSuccess(response.body());
                } else {
                    mWeatherView.weatherResultsFailure();
                }
                Log.e(TAG, "Response Code " + response.message());
            }

            @Override
            public void onFailure(Call<WeatherResponse> call, Throwable t) {
                Log.e(TAG, "Error Due To " + t.toString());
                mWeatherView.weatherResultsFailure();
            }
        });

    }
}
