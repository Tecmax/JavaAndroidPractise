package com.walmart.weatherreport.presenter;

import com.walmart.weatherreport.model.WeatherList;
import com.walmart.weatherreport.view.WeatherAdapterView;

import java.util.List;

public class WeatherListPresenter {

    private List<WeatherList> repositories;

    public WeatherListPresenter(List<WeatherList> repositories){
       this.repositories = repositories;
    }

    public void onBindRepositoryRowViewAtPosition(int position, WeatherAdapterView rowView) {
        WeatherList weather = repositories.get(position);
        double tempMin, tempMax;
        tempMin = weather.getTemperature().getTempMin() - 273.0;
        tempMax = weather.getTemperature().getTempMax() - 273.0;
        if (weather.getWeather().size() != 0) {
            rowView.setTempType(weather.getWeather().get(0).getMain(),
                    weather.getWeather().get(0).getDescription());
        }
        rowView.setLocation(weather.getName());
        rowView.setTemperature(tempMin, tempMax);

    }

    public int getWeatherCount() {
        return repositories.size();
    }
}
