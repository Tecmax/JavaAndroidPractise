package com.example.mahesha.widgets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.mahesha.activityexamples.R;

public class RadioActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_radio);
    }

    public void onRadioButtonClicked(View view) {
        boolean checked = ((RadioButton) view).isChecked();
        switch (view.getId()) {
            case R.id.radio_pirates:
                if (checked)
                    Toast.makeText(RadioActivity.this, "Meats are the best", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.radio_ninjas:
                if (checked)
                    Toast.makeText(RadioActivity.this, "Cheese are the best", Toast.LENGTH_SHORT).show();
                    break;
            case R.id.radio_male:
                if (checked)
                    Toast.makeText(RadioActivity.this, "Male are the best", Toast.LENGTH_SHORT).show();
                break;
            case R.id.radio_female:
                if (checked)
                    Toast.makeText(RadioActivity.this, "Female are the best", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
