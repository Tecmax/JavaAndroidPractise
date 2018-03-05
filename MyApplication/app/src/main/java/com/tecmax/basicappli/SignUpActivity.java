package com.tecmax.basicappli;

import android.content.Context;
import android.graphics.PorterDuff;
import android.graphics.drawable.LayerDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SwitchCompat;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.ToggleButton;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class SignUpActivity extends AppCompatActivity {
    SeekBar bar;
    RatingBar rateClass;
    SwitchCompat wifi;
    Spinner country;
    ListView countrys;
    ToggleButton bye;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        bar = findViewById(R.id.seek);
        rateClass = findViewById(R.id.rateClass);
        final LayerDrawable stars = (LayerDrawable) rateClass.getProgressDrawable();
        stars.getDrawable(2).setColorFilter(getResources().getColor(android.R.color.holo_orange_dark), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(1).setColorFilter(getResources().getColor(android.R.color.holo_green_dark), PorterDuff.Mode.SRC_ATOP);
        stars.getDrawable(0).setColorFilter(getResources().getColor(android.R.color.holo_blue_light), PorterDuff.Mode.SRC_ATOP);        wifi = findViewById(R.id.wifiSwitch);
        bye = findViewById(R.id.bye);
        country = findViewById(R.id.country);
        countrys = findViewById(R.id.list);
        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int count = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int position, boolean b) {
                count = position;
                Log.d("seekbar", "Progress Tracking pos is " + count);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.i("seekbar", "start Tracking Started");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.e("seekbar", "Stop Tracking pos is " + count);
                Toast.makeText(SignUpActivity.this, "postion is " + count,
                        Toast.LENGTH_SHORT).show();
            }
        });

        rateClass.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean b) {
                if (rating==0.5){
                    stars.getDrawable(2).setColorFilter(getResources().getColor(android.R.color.holo_red_dark), PorterDuff.Mode.SRC_ATOP);
                }else if (rating==1){
                    stars.getDrawable(2).setColorFilter(getResources().getColor(android.R.color.holo_blue_dark), PorterDuff.Mode.SRC_ATOP);
                }
                Toast.makeText(SignUpActivity.this, "Rated is " + rating, Toast.LENGTH_SHORT).show();
            }
        });
        Toast.makeText(SignUpActivity.this, "State is " + wifi.isChecked(), Toast.LENGTH_SHORT).show();

        bye.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                Toast.makeText(SignUpActivity.this, "State is " + b, Toast.LENGTH_SHORT).show();
            }
        });
        String[] countryList = {"India", "Aus", "Eng", "SL"};
        ArrayAdapter<String> countryAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, countryList);
        country.setAdapter(countryAdapter);
        countrys.setAdapter(countryAdapter);
        country.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String s = adapterView.getItemAtPosition(i).toString();
                Toast.makeText(SignUpActivity.this, ""+s, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
