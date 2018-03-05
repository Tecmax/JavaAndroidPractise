package com.walmart.activitylife;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = SecondActivity.class.getSimpleName();
    private Activity mActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        Log.d(TAG, "Second onCreate");
//        finish();
        mActivity = SecondActivity.this;
        findViewById(R.id.alert).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                open();
            }
        });
//        Button first = findViewById(R.id.first);
//        Button second = findViewById(R.id.second);
//        Button third = findViewById(R.id.third);
//        Button fourth = findViewById(R.id.fourth);
//        first.setOnClickListener(this);
//        second.setOnClickListener(this);
//        third.setOnClickListener(this);
//        fourth.setOnClickListener(this);
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

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "Second onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "Second onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "Second onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "Second onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "Second onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "Second onRestart");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d(TAG, "Second onPostCreate");
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, "Second onPostResume");
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        Log.d(TAG, "Second onUserLeaveHint");
    }

    public void open() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure You wanted to make decision");
        alertDialogBuilder.setTitle("HGellop");
        alertDialogBuilder.setPositiveButton("yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        Toast.makeText(SecondActivity.this, "You clicked yes button", Toast.LENGTH_LONG).show();
                    }
                });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                replaceFragment(new LifeTestkFragment(), LifeTestkFragment.class.getSimpleName(), false);
            }
        });
//        alertDialogBuilder.setNeutralButton("Maybe", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                finish();
//            }
//        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
    private void replaceFragment(Fragment rfdfd, String a, boolean atb) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.gyt, rfdfd, a);
        if (atb)
            ft.addToBackStack(a);
        ft.commit();
    }
}
