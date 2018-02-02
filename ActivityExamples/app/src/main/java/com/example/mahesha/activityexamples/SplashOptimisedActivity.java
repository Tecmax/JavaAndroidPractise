package com.example.mahesha.activityexamples;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class SplashOptimisedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
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
