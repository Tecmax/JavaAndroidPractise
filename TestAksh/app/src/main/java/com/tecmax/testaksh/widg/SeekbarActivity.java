package com.tecmax.testaksh.widg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import com.tecmax.testaksh.R;

import java.util.ArrayList;

public class SeekbarActivity extends AppCompatActivity {

    private static final String TAG = SeekbarActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);
        SeekBar bar = findViewById(R.id.music);
        RatingBar bar1 = findViewById(R.id.rateIT);
        ListView lv = findViewById(R.id.lv);
        final Spinner counstry = findViewById(R.id.country);

        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int pod = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                pod = i;
                Log.d(TAG, "onProgressChanged " + pod);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStartTrackingTouch");
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Log.d(TAG, "onStopTrackingTouch " + pod);
            }
        });

        bar1.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Log.d(TAG, "onRatingChanged " + v);
            }
        });


        ArrayList<String> ctrLis = new ArrayList<>();
        ctrLis.add("Select Country");
        ctrLis.add("IN");
        ctrLis.add("CA");
        ctrLis.add("US");
        ctrLis.add("UK");
        ctrLis.add("AU");
        ArrayAdapter<String> dd = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item,
                ctrLis);
        counstry.setAdapter(dd);
        counstry.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view,
                                       int i, long l) {
                  Toast.makeText(SeekbarActivity.this,"Selected is "+
                          counstry.getItemAtPosition(i), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        lv.setAdapter(dd);
    }
}
