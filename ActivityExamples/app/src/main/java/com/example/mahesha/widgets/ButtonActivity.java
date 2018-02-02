package com.example.mahesha.widgets;

import android.app.ProgressDialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.DigitalClock;
import android.widget.TextClock;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mahesha.activityexamples.R;
import com.example.mahesha.googlelogin.GoogleService;

import java.io.IOException;
import java.util.List;
import java.util.Locale;

public class ButtonActivity extends AppCompatActivity implements LocationListener {
    private static final int REQUEST_PERMISSIONS = 100;
    AnalogClock clk;
    LocationManager locationManager;
    Double latitude, longitude;
    Geocoder geocoder;
    TextView tvlatitude, tvlongitude;
    String mprovider;
    SharedPreferences mPref;
    SharedPreferences.Editor medit;
    boolean boolean_permission;
    private ProgressDialog progress;
    private BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {

            latitude = Double.valueOf(intent.getStringExtra("latutide"));
            longitude = Double.valueOf(intent.getStringExtra("longitude"));
            tvlongitude.setText(longitude + "");
            tvlatitude.setText(latitude + "");

            List<Address> addresses = null;

            try {
                addresses = geocoder.getFromLocation(latitude, longitude, 1);
                String cityName = addresses.get(0).getAddressLine(0);
                String stateName = addresses.get(0).getAddressLine(1);
                String countryName = addresses.get(0).getAddressLine(2);

//                tv_area.setText(addresses.get(0).getAdminArea());
//                tv_locality.setText(stateName);
//                tv_address.setText(countryName);


            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    };

    private void fn_permission() {
        if ((ContextCompat.checkSelfPermission(getApplicationContext(), android.Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED)) {

            if ((ActivityCompat.shouldShowRequestPermissionRationale(ButtonActivity.this, android.Manifest.permission.ACCESS_FINE_LOCATION))) {


            } else {
                ActivityCompat.requestPermissions(ButtonActivity.this, new String[]{android.Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_PERMISSIONS);

            }
        } else {
            boolean_permission = true;
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        switch (requestCode) {
            case REQUEST_PERMISSIONS: {
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    boolean_permission = true;

                } else {
                    Toast.makeText(getApplicationContext(), "Please allow the permission", Toast.LENGTH_LONG).show();

                }
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, new IntentFilter(GoogleService.str_receiver));

    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);
        clk = (AnalogClock) findViewById(R.id.analogClock1);
        tvlatitude = (TextView) findViewById(R.id.latitude);
        tvlongitude = (TextView) findViewById(R.id.longitude);
        final TextView tvexa = (TextView) findViewById(R.id.tv_exap);
        Button dyn_tv = (Button) findViewById(R.id.bt_tv);
        DigitalClock dc = (DigitalClock) findViewById(R.id.digitalClock1);
        TextClock tc = (TextClock) findViewById(R.id.simpleDigitalClock);
        geocoder = new Geocoder(this, Locale.getDefault());
        mPref = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        medit = mPref.edit();
        clk.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "This is Static AnalogClock",
                        Toast.LENGTH_SHORT).show();
                download(v);
            }
        });
        dyn_tv.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               tvexa.setText("Mahesh");
            }
        });

//        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
//        Criteria criteria = new Criteria();

//        mprovider = locationManager.getBestProvider(criteria, false);
        fn_permission();
//        if (mprovider != null && !mprovider.equals("")) {
//            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                return;
//            }
//            Location location = locationManager.getLastKnownLocation(mprovider);
//            locationManager.requestLocationUpdates(mprovider, 15000, 1, this);
//
//            if (location != null)
//                onLocationChanged(location);
//            else
//                Toast.makeText(getBaseContext(), "No Location Provider Found Check Your Code", Toast.LENGTH_SHORT).show();
//        }
        tc.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(), "This is Static Text",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void open(View view) {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure You wanted to make decision");
        alertDialogBuilder.setTitle("HGellop");
        alertDialogBuilder.setPositiveButton("yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        if (boolean_permission) {

                            if (mPref.getString("service", "").matches("")) {
                                medit.putString("service", "service").commit();

                                Intent intent = new Intent(getApplicationContext(), GoogleService.class);
                                startService(intent);

                            } else {
                                Toast.makeText(getApplicationContext(), "Service is already running", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "Please enable the gps", Toast.LENGTH_SHORT).show();
                        }
                        Toast.makeText(ButtonActivity.this, "You clicked yes button", Toast.LENGTH_LONG).show();
                    }
                });

        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish();
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

    public void download(View view) {
        progress = new ProgressDialog(this);
        progress.setMessage("Downloading Music");
        progress.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        progress.setIndeterminate(false);
        progress.setTitle("Hello Mahesh");
        progress.setCancelable(false);
        progress.setProgress(0);
        progress.show();

        final int totalProgressTime = 100;
        final Thread t = new Thread() {
            @Override
            public void run() {
                int jumpTime = 0;

                while (jumpTime < totalProgressTime) {
                    try {
                        sleep(200);
                        jumpTime += 5;
                        progress.setProgress(jumpTime);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                if (jumpTime == totalProgressTime) {
                    try {
                        sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    progress.dismiss();
                }
            }
        };
        t.start();
    }

    @Override
    public void onLocationChanged(Location location) {
//        tvlongitude.setText("Current Longitude:" + location.getLongitude());
//        tvlatitude.setText("Current Latitude:" + location.getLatitude());
    }

    @Override
    public void onStatusChanged(String s, int i, Bundle bundle) {

    }

    @Override
    public void onProviderEnabled(String s) {

    }

    @Override
    public void onProviderDisabled(String s) {

    }
}
