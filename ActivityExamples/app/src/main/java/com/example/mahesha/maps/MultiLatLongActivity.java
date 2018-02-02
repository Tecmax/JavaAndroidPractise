package com.example.mahesha.maps;

import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;

import com.example.mahesha.activityexamples.R;

public class MultiLatLongActivity extends AppCompatActivity {
    TextInputEditText lat1;
    TextInputEditText lat2;
    TextInputEditText lat3;
    TextInputEditText lat4;
    TextInputEditText long1;
    TextInputEditText long2;
    TextInputEditText long3;
    TextInputEditText long4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_lat_long);
//        lat1 = (TextInputEditText) findViewById(R.id.tet_lat1);
//        lat2 = (TextInputEditText) findViewById(R.id.tet_lat2);
//        lat3 = (TextInputEditText) findViewById(R.id.tet_lat3);
//        lat4 = (TextInputEditText) findViewById(R.id.tet_lat4);
//        long1 = (TextInputEditText) findViewById(R.id.tet_long1);
//        long2 = (TextInputEditText) findViewById(R.id.tet_long2);
//        long3 = (TextInputEditText) findViewById(R.id.tet_long3);
//        long4 = (TextInputEditText) findViewById(R.id.tet_long4);
//        Button showMaps = (Button) findViewById(R.id.bt_showmaps);
//        showMaps.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent abc = new Intent(MultiLatLongActivity.this, MapsActivity.class);
//                abc.putExtra("lat1", Double.parseDouble(lat1.getText().toString()));
//                abc.putExtra("long1", Double.parseDouble(long1.getText().toString()));
//                startActivity(abc);
//            }
//        });
    }
}
