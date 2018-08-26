package com.walmart.weatherreport.activities;

import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.TextView;

import com.walmart.weatherreport.R;
import com.walmart.weatherreport.adapter.WeatherAdapter;
import com.walmart.weatherreport.model.WeatherImpl;
import com.walmart.weatherreport.model.WeatherResponse;
import com.walmart.weatherreport.presenter.WeatherListPresenter;
import com.walmart.weatherreport.presenter.WeatherPresenter;
import com.walmart.weatherreport.view.WeatherView;

public class WeatherActivity extends AppCompatActivity implements WeatherView {
    private TextInputEditText mCity;
    private TextInputLayout mCityLay;
    private RecyclerView mWeatherList;
    private WeatherPresenter presenter;
    private ConstraintLayout view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        view = findViewById(R.id.top);
        mCity = findViewById(R.id.tetEnterLocation);
        mCityLay = findViewById(R.id.tilPlace);
        mWeatherList = findViewById(R.id.cityWeathers);
        mWeatherList.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        mWeatherList.setLayoutManager(layoutManager);
        presenter = new WeatherImpl(this);
        presenter.getWeatherList("Bangalore");
        mCity.setImeOptions(EditorInfo.IME_ACTION_DONE);
        mCity.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.length() > 3)
                    presenter.getWeatherList(mCity.getText().toString());
            }
        });
        mCity.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    presenter.getWeatherList(mCity.getText().toString());
                    return true;
                }
                return false;
            }
        });
    }

    @Override
    public void weatherResultsSuccess(WeatherResponse response) {
        WeatherAdapter weatherAdapter = new WeatherAdapter(new WeatherListPresenter(response.getWeatherList()));
        mWeatherList.setAdapter(weatherAdapter);
    }

    @Override
    public void weatherResultsFailure() {
        Snackbar.make(view, "Something Is Wrong Please Try Again", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void weatherValidations() {
        mCityLay.setError("Please Enter the City");
    }

    @Override
    public void onUnknownError(String message) {
        Snackbar.make(view, message, Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onTimeout() {
        Snackbar.make(view, "Service is Broken", Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void onNetworkError() {
        Snackbar.make(view, "Please Check the Network again", Snackbar.LENGTH_SHORT).show();
    }
}
