package com.example.mahesha.activityexamples.practsie;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.mahesha.activityexamples.R;
import com.example.mahesha.activityexamples.WidgetsActivity;

public class WidgetAllActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widget_all);
    }

    public void onTestClicked(View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.cb_hello:
                if (checked)
                    Toast.makeText(this, "Hello checked", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "No Hello", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cb_world:
                if (checked)
                    Toast.makeText(this, "World checked", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "No World", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cb_terms:
                if (checked)
                    Toast.makeText(this, "Terms checked", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(this, "No Terms", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void onTermsClicked(View view) {
        startActivity(new Intent(this, WidgetsActivity.class));
    }

    public void onGenderClicked(View view) {
        switch (view.getId()) {
            case R.id.rb_male:
                Toast.makeText(this, "Male Selected", Toast.LENGTH_SHORT).show();
                break;
            case R.id.rb_female:
                Toast.makeText(this, "FeMale Selected", Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
