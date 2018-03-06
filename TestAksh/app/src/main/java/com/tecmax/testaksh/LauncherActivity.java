package com.tecmax.testaksh;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.tecmax.testaksh.example.TecmaxLauncherActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
        Thread timerThread = new Thread() {
            public void run() {
                try {
                    sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    finish();
                    Intent intent = new Intent(LauncherActivity.this,
                            TecmaxLauncherActivity.class);
                    startActivity(intent);
                }
            }
        };
        timerThread.start();
    }
}
