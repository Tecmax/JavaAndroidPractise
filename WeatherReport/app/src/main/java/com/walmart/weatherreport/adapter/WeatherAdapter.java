package com.walmart.weatherreport.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.walmart.weatherreport.R;
import com.walmart.weatherreport.presenter.WeatherListPresenter;

public class WeatherAdapter extends RecyclerView.Adapter<WeatherHolder> {
    private WeatherListPresenter mWeatherLists;
    private Context context;

    public WeatherAdapter(WeatherListPresenter weatherLists) {
        this.mWeatherLists = weatherLists;
    }

    @Override
    public WeatherHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_weather_list, parent, false);
        return new WeatherHolder(v);
    }

    @Override
    public void onBindViewHolder(WeatherHolder holder, int position) {
        mWeatherLists.onBindRepositoryRowViewAtPosition(position, holder);
    }

    @Override
    public int getItemCount() {
        return mWeatherLists.getWeatherCount();
    }
}
