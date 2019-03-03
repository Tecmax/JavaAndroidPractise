package com.example.mahesha.activityexamples;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashOptimisedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_splash_optimised);
        new Handler().postDelayed(new Runnable() {

            @SuppressLint("PrivateResource")
            @Override
            public void run() {
                startActivity(new Intent(SplashOptimisedActivity.this, LauncherActivity.class));
                finish();
            }

        }, 4000);

    }
}
