package com.example.mahesha.searchimp;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.example.mahesha.activityexamples.R;

public class SearchCountryActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_country);

        Button btn = (Button) findViewById(R.id.btn_search);

        btn.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                onSearchRequested();
            }
        });
    }
}
