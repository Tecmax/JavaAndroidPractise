package com.walmart.weatherreport.view;

import com.walmart.weatherreport.model.WeatherResponse;

public interface WeatherView {
    void weatherResultsSuccess(WeatherResponse response);

    void weatherResultsFailure();

    void weatherValidations();

    void onUnknownError(String message);

    void onTimeout();

    void onNetworkError();
}
