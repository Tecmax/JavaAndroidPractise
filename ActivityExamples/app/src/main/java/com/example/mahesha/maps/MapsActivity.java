package com.example.mahesha.maps;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.Toast;

import com.example.mahesha.activityexamples.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;

import java.text.DecimalFormat;
import java.util.ArrayList;

import static com.example.mahesha.activityexamples.R.id.map;

public class MapsActivity extends FragmentActivity implements OnMapReadyCallback, GoogleMap.OnPolygonClickListener {

    private GoogleMap mMap;
    LatLng abc;
    private double radius;
    private Circle circle;
    private CircleOptions circleOptions;
    private Polygon polygon1;
    private PolygonOptions polyogonOp;
    ArrayList<LatLng> bca;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        SeekBar sk = (SeekBar) findViewById(R.id.seek_Radius);
        double lat1 = getIntent().getDoubleExtra("lat1", 0);
        double long1 = getIntent().getDoubleExtra("long1", 0);
        abc = new LatLng(lat1, long1);
        bca = new ArrayList<>();

        LatLng a = new LatLng(-27.457, 153.040),
                b = new LatLng(-33.852, 151.211),
                c = new LatLng(-37.813, 144.962),
                e = new LatLng(-35.813, 128.962),
                d = new LatLng(-34.928, 138.599);
        bca.add(a);
        bca.add(b);
        bca.add(c);
        bca.add(d);
        bca.add(e);
//        bca.add(abc);
        radius = 1 * 500;

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        final SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(map);
        mapFragment.getMapAsync(MapsActivity.this);
        sk.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            float progressChangedValue = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                progressChangedValue = i;
                Toast.makeText(MapsActivity.this, "Seek Bar Progress is : " + progressChangedValue, Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                radius = progressChangedValue * 500;
                Toast.makeText(MapsActivity.this, "Radius is : " + (progressChangedValue / 2) + " KM", Toast.LENGTH_SHORT).show();
                circle.setRadius(radius);
                mapFragment.getMapAsync(MapsActivity.this);
            }
        });
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        mMap.setOnMapClickListener(new GoogleMap.OnMapClickListener() {
            @Override
            public void onMapClick(LatLng latLng) {
                bca.add(latLng);
//                List<LatLng> points= polygon1.getPoints();
//                points.add(latLng);
                polygon1.setPoints(bca);
//                polyogonOp.getPoints().add(latLng);
            }
        });
        if (circle != null) {
            circle.remove();
        }
        // Add a marker in Sydney and move the camera
//        LatLng sydney = new LatLng(-34, 151);
//        mMap.addMarker(new MarkerOptions().position(sydney).title("Marker in Sydney"));
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney));
//        circle = mMap.addCircle(circleOptions);

        MarkerOptions marker = new MarkerOptions().position(new LatLng(12.913026, 77.609995)).title("Softgen Infotech ");
//        MarkerOptions marker = new MarkerOptions().position(abc).title("Softgen Infotech ");
// adding marker
        mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);
//        mMap.moveCamera(CameraUpdateFactory.newLatLng(abc));
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(-27.457, 153.040), 10));
        marker.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN));

        circleOptions = new CircleOptions()
                .center(new LatLng(12.913026, 77.609995))   //set center
                .radius(radius)   //set radius in meters
                .fillColor(Color.TRANSPARENT)  //default
                .strokeColor(Color.RED)
                .strokeWidth(5);
        circle = mMap.addCircle(circleOptions);
//        polyogonOp = new PolygonOptions()
//                .clickable(true)
//                .fillColor(Color.TRANSPARENT)
//                .strokeColor(Color.RED)
//                .strokeWidth(5);
//        for (int i = 0; i < bca.size(); i++) {
//            polyogonOp.add(bca.get(i));
//        }
//        polygon1 = mMap.addPolygon(polyogonOp);
// Store a data object with the polygon, used here to indicate an arbitrary type.
//        polygon1.setTag("alpha");
        mMap.addMarker(marker);
//        mMap.setOnPolygonClickListener(this);


// GREEN color icon
        MarkerOptions marker1 = new MarkerOptions().position(new LatLng(12.920787, 77.614407)).title("Mahesh Home");
        mMap.getUiSettings().setRotateGesturesEnabled(true);
        mMap.getUiSettings().setZoomControlsEnabled(true);
        mMap.getUiSettings().setZoomGesturesEnabled(true);
        mMap.getUiSettings().setCompassEnabled(true);
        mMap.animateCamera(CameraUpdateFactory.newLatLng(new LatLng(12.920787, 77.614407)));
        marker1.icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_MAGENTA));
        mMap.addMarker(marker1);
//        CalculationByDistance(new LatLng(12.920787, 77.614407), new LatLng(12.913026, 77.609995));

    }

    public double CalculationByDistance(LatLng StartP, LatLng EndP) {
        int Radius = 6371;// radius of earth in Km
        double lat1 = StartP.latitude;
        double lat2 = EndP.latitude;
        double lon1 = StartP.longitude;
        double lon2 = EndP.longitude;
        double dLat = Math.toRadians(lat2 - lat1);
        double dLon = Math.toRadians(lon2 - lon1);
        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(Math.toRadians(lat1))
                * Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2)
                * Math.sin(dLon / 2);
        double c = 2 * Math.asin(Math.sqrt(a));
        double valueResult = Radius * c;
        double km = valueResult / 1;
        DecimalFormat newFormat = new DecimalFormat("####");
        int kmInDec = Integer.valueOf(newFormat.format(km));
        double meter = valueResult % 1000;
        int meterInDec = Integer.valueOf(newFormat.format(meter));
        Log.i("Radius Value", "" + valueResult + "   KM  " + kmInDec
                + " Meter   " + meterInDec);

        return Radius * c;
    }


    @Override
    public void onPolygonClick(Polygon polygon) {
        polygon.getPoints();
//        Toast.makeText(this, "Points Are " + polyline.getPoints(), Toast.LENGTH_SHORT).show();
    }

}
