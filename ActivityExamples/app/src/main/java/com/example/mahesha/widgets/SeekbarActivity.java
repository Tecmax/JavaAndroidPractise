package com.example.mahesha.widgets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.mahesha.activityexamples.R;

public class SeekbarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);
        SeekBar sk = (SeekBar) findViewById(R.id.simpleseekbar);
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int progressChangedValue = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressChangedValue = i;
//                Toast.makeText(SeekbarActivity.this, "Seek Bar Progress is : " + progressChangedValue, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(SeekbarActivity.this, "Seek Bar Progress is : " + progressChangedValue, Toast.LENGTH_SHORT).show();
            }
        });
    }
}
