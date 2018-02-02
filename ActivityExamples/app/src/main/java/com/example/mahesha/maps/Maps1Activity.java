package com.example.mahesha.maps;

import android.Manifest;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.FragmentActivity;

import com.example.mahesha.activityexamples.R;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

import static com.example.mahesha.activityexamples.R.id.map;


public class Maps1Activity extends FragmentActivity implements OnMapReadyCallback,
        GoogleMap.OnMapClickListener, GoogleMap.OnMapLongClickListener, GoogleMap.OnMarkerClickListener {
    private GoogleMap googleMap;
    private ArrayList<LatLng> arrayPoints = null;
    PolylineOptions polylineOptions;
    private boolean checkClick = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        arrayPoints = new ArrayList<LatLng>();
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(Maps1Activity.this);
    }


    @Override
    public void onMapReady(GoogleMap googleMap) {
        Maps1Activity.this.googleMap = googleMap;
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        Maps1Activity.this.googleMap.setMyLocationEnabled(true);
        Maps1Activity.this.googleMap.setOnMapClickListener(this);
        Maps1Activity.this.googleMap.setOnMapLongClickListener(this);
        Maps1Activity.this.googleMap.setOnMarkerClickListener(this);

    }


    @Override
    public void onMapClick(LatLng latLng) {
        if (checkClick == false) {
            googleMap.addMarker(new MarkerOptions().position(latLng).icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
            arrayPoints.add(latLng);
        }

    }

    @Override
    public void onMapLongClick(LatLng latLng) {
        googleMap.clear();
        arrayPoints.clear();
        checkClick = false;
    }

    public void countPolygonPoints() {
        if (arrayPoints.size() >= 3) {
            checkClick = true;
            PolygonOptions polygonOptions = new PolygonOptions();
            polygonOptions.addAll(arrayPoints);
            polygonOptions.strokeColor(Color.BLUE);
            polygonOptions.strokeWidth(7);
            polygonOptions.fillColor(Color.CYAN);
            Polygon polygon = googleMap.addPolygon(polygonOptions);
        }
    }

    @Override
    public boolean onMarkerClick(Marker marker) {
        System.out.println("Marker lat long=" + marker.getPosition());
        System.out.println("First postion check" + arrayPoints.get(0));
        System.out.println("**********All arrayPoints***********" + arrayPoints);
        if (arrayPoints.get(0).equals(marker.getPosition())) {
            System.out.println("********First Point choose************");
            countPolygonPoints();
        }

        return false;
    }
}
