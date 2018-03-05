package com.walmart.activitylife;

import android.content.CursorLoader;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    private static final String TAG = FirstActivity.class.getSimpleName();
    private static final String PROVIDER_NAME = "sitepoint.contentdemo.images";
    private static final Uri CONTENT_URI = Uri.parse("content://" + PROVIDER_NAME + "/images");
    static final Integer LOCATION = 0x6;
    private ListView listView;
    private SimpleCursorAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);
        Log.d(TAG, "On Create");
//        askForPermission(Manifest.permission.Read, LOCATION);
        findViewById(R.id.hello).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FirstActivity.this, SecondActivity.class));
            }
        });

        listView =  findViewById(R.id.listView);

        adapter = new SimpleCursorAdapter(getBaseContext(),
                R.layout.list_layout,
                null,
                new String[] { "IMAGETITLE", "IMAGEURL", "IMAGEDESC"},
                new int[] { R.id.imgTitle , R.id.imgUrl, R.id.imgDesc }, 0);

        listView.setAdapter(adapter);
        refreshValuesFromContentProvider();
    }


    private void refreshValuesFromContentProvider() {
        CursorLoader cursorLoader = new CursorLoader(getBaseContext(), CONTENT_URI,
                null, null, null, null);
        Cursor c = cursorLoader.loadInBackground();
        adapter.swapCursor(c);
    }
    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "On onStart");
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.d(TAG, "On onConfigurationChanged");
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d(TAG, "On onPostCreate");
    }
    @Override
    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, "On onPostResume");
    }

    @Override
    protected void onUserLeaveHint() {
        super.onUserLeaveHint();
        Log.d(TAG, "On onUserLeaveHint");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "On onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "On onDestroy");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "On onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "On onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "On onRestart");
    }

    private void askForPermission(String permission, Integer requestCode) {
        if (ContextCompat.checkSelfPermission(FirstActivity.this, permission)
                != PackageManager.PERMISSION_GRANTED) {

            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale
                    (FirstActivity.this, permission)) {

                //This is called if user has denied the permission before
                //In this case I am just asking the permission again
                ActivityCompat.requestPermissions(FirstActivity.this,
                        new String[]{permission}, requestCode);

            } else {

                ActivityCompat.requestPermissions(FirstActivity.this,
                        new String[]{permission}, requestCode);
            }
        } else {
            Toast.makeText(this, "" + permission +
                    " is already granted.", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (ActivityCompat.checkSelfPermission(this, permissions[0])
                == PackageManager.PERMISSION_GRANTED) {
            switch (requestCode) {
                //Location
                case 1:
                    break;
            }
            Toast.makeText(this, "Permission granted", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
        }

    }
}
