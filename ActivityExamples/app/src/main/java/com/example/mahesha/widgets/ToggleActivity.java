package com.example.mahesha.widgets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.example.mahesha.activityexamples.R;

public class ToggleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle);
        ToggleButton toggle = (ToggleButton) findViewById(R.id.togglebutton);
        toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    Toast.makeText(ToggleActivity.this, "The toggle is enabled", Toast.LENGTH_SHORT).show();
                    // The toggle is enabled
                } else {
                    Toast.makeText(ToggleActivity.this, "The toggle is disabled", Toast.LENGTH_SHORT).show();
                    // The toggle is disabled
                }
            }
        });
    }
}
