package com.example.mahesha.activityexamples;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by mahesha on 20-11-16.
 */

public class TestActivityClicks extends AppCompatActivity implements View.OnClickListener {
    private Context mActivity;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_click);
        mActivity = TestActivityClicks.this;
        Button login = (Button) findViewById(R.id.login_button);
        TextView signup = (TextView) findViewById(R.id.tv_sign_up);
        String sg = signup.getText().toString();
        login.setOnClickListener(this);
        signup.setOnClickListener(this);
//        login.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent nex = new Intent(mActivity, AnotherTestActivity.class);
//                startActivity(nex);
//            }
//        });
//        signup.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent nex = new Intent(mActivity, AnotherTestActivity.class);
//                startActivity(nex);
//            }
//        });
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.login_button:
                Intent nex = new Intent(mActivity, AnotherTestActivity.class);
                startActivity(nex);
                break;
            case R.id.tv_sign_up:
                Intent nex1 = new Intent(mActivity, AnotherTestActivity.class);
                startActivity(nex1);
                break;
        }
    }
}
