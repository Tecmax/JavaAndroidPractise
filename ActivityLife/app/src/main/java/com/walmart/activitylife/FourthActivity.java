package com.walmart.activitylife;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FourthActivity extends AppCompatActivity implements View.OnClickListener {
    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        Button first = findViewById(R.id.first);
        Button second = findViewById(R.id.second);
        Button third = findViewById(R.id.third);
        Button fourth = findViewById(R.id.fourth);
        first.setOnClickListener(this);
        second.setOnClickListener(this);
        third.setOnClickListener(this);
        fourth.setOnClickListener(this);
        mActivity = FourthActivity.this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.first:
                startActivity(new Intent(mActivity, FirstActivity.class));
                break;
            case R.id.second:
                startActivity(new Intent(mActivity, SecondActivity.class));
                break;
            case R.id.third:
                startActivity(new Intent(mActivity, ThirdActivity.class));
                break;
            case R.id.fourth:
                startActivity(new Intent(mActivity, FourthActivity.class));
                break;
        }
    }
}
