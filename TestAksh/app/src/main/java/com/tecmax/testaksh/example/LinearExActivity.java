package com.tecmax.testaksh.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.tecmax.testaksh.R;
import com.tecmax.testaksh.default_templets.BasicActivity;
import com.tecmax.testaksh.default_templets.FaceActivity;

public class LinearExActivity extends AppCompatActivity implements View.OnClickListener {
    Button basic, bottom, master, login, fullScreen, navigation, settings, scrolling, tabbed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_linear_ex);
        basic = findViewById(R.id.basicAct);
        bottom = findViewById(R.id.bottomNavagation);
        master = findViewById(R.id.master);
        login = findViewById(R.id.loginAct);
        fullScreen = findViewById(R.id.fullScreen);
        navigation = findViewById(R.id.navAct);
        settings = findViewById(R.id.settingsAct);
        scrolling = findViewById(R.id.scrollingAct);
        tabbed = findViewById(R.id.tabAct);


        basic.setOnClickListener(this);
        bottom.setOnClickListener(this);
        master.setOnClickListener(this);
        login.setOnClickListener(this);
        fullScreen.setOnClickListener(this);
        navigation.setOnClickListener(this);
        settings.setOnClickListener(this);
        scrolling.setOnClickListener(this);
        tabbed.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.basicAct:
                startActivity(new Intent(this, BasicActivity.class));
                break;
            case R.id.bottomNavagation:
                startActivity(new Intent(this, FaceActivity.class));
                break;
        }
    }
}
