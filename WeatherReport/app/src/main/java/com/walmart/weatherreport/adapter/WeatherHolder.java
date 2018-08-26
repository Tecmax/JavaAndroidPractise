package com.walmart.weatherreport.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.walmart.weatherreport.R;
import com.walmart.weatherreport.view.WeatherAdapterView;

public class WeatherHolder extends RecyclerView.ViewHolder implements WeatherAdapterView {
    TextView tempArea;
    TextView tempMin;
    TextView tempDescription;
    Context mContext;

    public WeatherHolder(View itemView) {
        super(itemView);
        mContext = itemView.getContext();
        tempArea = itemView.findViewById(R.id.tempArea);
        tempMin = itemView.findViewById(R.id.tempMin);
        tempDescription = itemView.findViewById(R.id.tempType);
    }

    @Override
    public void setTempType(String main, String type) {
        String description = mContext.getResources().getString(R.string.temp_desc, main, type);
        tempDescription.setText(description);
    }

    @Override
    public void setLocation(String location) {
        tempArea.setText(location);
    }

    @Override
    public void setTemperature(double minTemperature, double maxTemperature) {
        String temperature = mContext.getResources().getString(R.string.temp_min, String.format("%.2f", minTemperature), String.format("%.2f", minTemperature));
        tempMin.setText(temperature);
    }
}
