package com.example.techniche.locationaddress;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.AlertDialog;
import android.app.SearchManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.Settings;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements LocationResult {

    Button btnGPSShowLocation;
    Button btnShowAddress;
    Button btnMaps;
    Button btnyoutube;
    private MyLocation myLocation = null;
    TextView tvAddress;
    EditText etSearch;
    Button geoCodeButton;

    private static final String[] INITIAL_PERMS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };

    private static final int INITIAL_REQUEST = 13;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvAddress = (TextView) findViewById(R.id.tvAddress);
        etSearch = (EditText) findViewById(R.id.search);
        myLocation = new MyLocation();
        geoCodeButton = (Button) findViewById(R.id.btngeoCOde);
        btnGPSShowLocation = (Button) findViewById(R.id.btnGPSShowLocation);
        btnMaps = (Button) findViewById(R.id.btnMaps);
        btnyoutube = (Button) findViewById(R.id.btnYoutube);
        btnShowAddress = (Button) findViewById(R.id.btnShowAddress);
        btnGPSShowLocation.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.M)
            @Override
            public void onClick(View arg0) {

                if (!canAccessLocation() || !canAccessCoreLocation()) {
                    requestPermissions(INITIAL_PERMS, INITIAL_REQUEST);

                } else {
                    boolean networkPresent = myLocation.getLocation(MainActivity.this, MainActivity.this);
                    if (!networkPresent) {
                        showSettingsAlert();
                    }
                }

            }
        });

        btnShowAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {

                //you can hard-code the lat & long if you have issues with getting it
                //remove the below if-condition and use the following couple of lines
//                double latitude = 37.422005;
//                double longitude = -122.084095;


            }
        });
        geoCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                startActivity(new Intent(MainActivity.this, GeocodingActivity.class));
            }
        });
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                startActivity(new Intent(MainActivity.this, MapsActivity.class));
            }
        });
        btnyoutube.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                Intent intent = new Intent(Intent.ACTION_SEARCH);
                intent.setPackage("com.google.android.youtube");
                intent.putExtra("query", "Android");
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
            }
        });

    }
    public void onSearchClick(View v)
    {
        try {
            Intent intent = new Intent(Intent.ACTION_WEB_SEARCH);
            String term = etSearch.getText().toString();
            intent.putExtra(SearchManager.QUERY, term);
            startActivity(intent);
        } catch (Exception e) {
            // TODO: handle exception
        }

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions,
                                           int[] grantResults) {

        switch (requestCode) {
            case INITIAL_REQUEST:
                if (canAccessLocation() && canAccessCoreLocation()) {
                    boolean networkPresent = myLocation.getLocation(MainActivity.this, this);
                    if (!networkPresent) {
                        showSettingsAlert();
                    }
                }

                break;


        }
    }

    private boolean canAccessLocation() {
        return (hasPermission(Manifest.permission.ACCESS_FINE_LOCATION));
    }

    private boolean canAccessCoreLocation() {
        return (hasPermission(Manifest.permission.ACCESS_COARSE_LOCATION));
    }

    private boolean hasPermission(String perm) {

        return (PackageManager.PERMISSION_GRANTED == ContextCompat.checkSelfPermission(MainActivity.this, perm));
    }


    public void showSettingsAlert() {
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(
                MainActivity.this);
        alertDialog.setTitle("SETTINGS");
        alertDialog.setMessage("Enable Location Provider! Go to settings menu?");
        alertDialog.setPositiveButton("Settings",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                        MainActivity.this.startActivity(intent);
                    }
                });
        alertDialog.setNegativeButton("Cancel",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
        alertDialog.show();
    }

    @Override
    public void gotLocation(Location location) {

        final double latitude = location.getLatitude();
        final double longitude = location.getLongitude();
        final String result = "Latitude: " + location.getLatitude() +
                " Longitude: " + location.getLongitude();


        MainActivity.this.runOnUiThread(new Runnable() {
            public void run() {
                tvAddress.setText(result);
                LocationAddress locationAddress = new LocationAddress();
                locationAddress.getAddressFromLocation(latitude, longitude,
                        getApplicationContext(), new GeocoderHandler());
            }
        });


    }

    private class GeocoderHandler extends Handler {
        @Override
        public void handleMessage(Message message) {
            String locationAddress;
            switch (message.what) {
                case 1:
                    Bundle bundle = message.getData();
                    locationAddress = bundle.getString("address");
                    break;
                default:
                    locationAddress = null;
            }
            tvAddress.setText(locationAddress);
        }
    }
}
