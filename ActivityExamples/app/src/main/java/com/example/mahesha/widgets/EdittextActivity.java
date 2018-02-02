package com.example.mahesha.widgets;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mahesha.activityexamples.R;

public class EdittextActivity extends AppCompatActivity {
    private EditText latitude;
    private EditText longitude;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edittext);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        String lat= getIntent().getStringExtra("lati");
        String longi= getIntent().getStringExtra("longi");
        latitude = (EditText) findViewById(R.id.et_latitude);
        longitude = (EditText) findViewById(R.id.et_longitude);
        latitude.setText(lat);
        longitude.setText(longi);
        Button submit = (Button) findViewById(R.id.bt_submit);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String longi = longitude.getText().toString();
                Toast.makeText(EdittextActivity.this, latitude.getText().toString(), Toast.LENGTH_SHORT).show();
                Toast.makeText(EdittextActivity.this, longi, Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return false;
            default:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
