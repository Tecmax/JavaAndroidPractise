package com.example.mahesha.activityexamples;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.example.mahesha.utility.Session;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;

public class LauncherActivity extends AppCompatActivity {
    private Session session;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_launcher);
        session = new Session(LauncherActivity.this);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//        Thread timerThread = new Thread(){
//            public void run(){
//                try{
//                    sleep(3000);
//                }catch(InterruptedException e){
//                    e.printStackTrace();
//                }finally{
//                    finish();
//                    Intent intent = new Intent(LauncherActivity.this,MainActivity.class);
//                    startActivity(intent);
//                }
//            }
//        };
//        timerThread.start();
        new Handler().postDelayed(new Runnable() {

            @SuppressLint("PrivateResource")
            @Override
            public void run() {
                if (session.getLoggedIn()) {
                    Intent i = new Intent(LauncherActivity.this,
                            MainActivity.class);
                    startActivity(i);
                    finish();
                } else {
                    Intent i = new Intent(LauncherActivity.this,
                            LanguageActivity.class);
                    startActivity(i);
                    finish();
                }

            }

        }, 4000);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

}
