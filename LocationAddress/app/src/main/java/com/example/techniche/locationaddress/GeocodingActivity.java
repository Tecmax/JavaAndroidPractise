package com.example.techniche.locationaddress;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.TextInputEditText;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.techniche.locationaddress.entities.LocationDetails;
import com.example.techniche.locationaddress.rest.ApiClient;
import com.example.techniche.locationaddress.rest.ApiInterface;

import java.net.HttpURLConnection;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static android.content.ContentValues.TAG;


public class GeocodingActivity extends Activity {
    Button addressButton, latlongButton;
    TextView latLongTV;
    TextView tvLatLong;
    private LocationDetails user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_geocoding);
        latLongTV = (TextView) findViewById(R.id.latLongTV);
        tvLatLong = (TextView) findViewById(R.id.tvLatLong);
        addressButton = (Button) findViewById(R.id.addressButton);
        addressButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                TextInputEditText editText = (TextInputEditText) findViewById(R.id.addressET);
                String address = editText.getText().toString();
                getLatitudeLongitude(address.replace(" ", "+"));
            }
        });

        latlongButton = (Button) findViewById(R.id.LatlongButton);
        latlongButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View arg0) {
                TextInputEditText editText = (TextInputEditText) findViewById(R.id.latlong);
                String address = editText.getText().toString();
                getAddress(address.replace(" ", "+"));
            }
        });

    }

    private void getLatitudeLongitude(String address) {
        ApiInterface apiService = ApiClient.getLocationClient().create(ApiInterface.class);
        String key = GeocodingActivity.this.getResources().getString(R.string.web_api_key);
        Call<LocationDetails> call = apiService.getLatLong(address, true, key);
        call.enqueue(new Callback<LocationDetails>() {
            @Override
            public void onResponse(Call<LocationDetails> call, Response<LocationDetails> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    user = response.body();
                    setView();
                } else {
                    Log.e(TAG, "response status:" + response.code() + response.message());
                    Toast.makeText(GeocodingActivity.this, "No Order Details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LocationDetails> call, Throwable t) {
                Log.e(TAG, t.toString());
                Toast.makeText(GeocodingActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void getAddress(String address) {
        ApiInterface apiService = ApiClient.getLocationClient().create(ApiInterface.class);
        String key = GeocodingActivity.this.getResources().getString(R.string.web_api_key);
        Call<LocationDetails> call = apiService.getAddress(address, key);
        call.enqueue(new Callback<LocationDetails>() {
            @Override
            public void onResponse(Call<LocationDetails> call, Response<LocationDetails> response) {
                if (response.code() == HttpURLConnection.HTTP_OK) {
                    user = response.body();
                    setAddressView();
                } else {
                    Log.e(TAG, "response status:" + response.code() + response.message());
                    Toast.makeText(GeocodingActivity.this, "No Order Details", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LocationDetails> call, Throwable t) {
                Log.e(TAG, t.toString());
                Toast.makeText(GeocodingActivity.this, t.toString(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setView() {
        String latLong = "";
        if (user.getAddresses().size() > 0 && user.getAddresses() != null)
            try {
                latLong = user.getAddresses().get(0).getGeometry().getLatLong().getLatitude()
                        + "," + user.getAddresses().get(0).getGeometry().getLatLong().getLongitude();
                latLong += "\n" + user.getAddresses().get(0).getFormattedAddress();
            } catch (Exception e) {
                e.printStackTrace();
            }
        tvLatLong.setText(latLong);
    }

    private void setAddressView() {
        String latLong = "";
        if (user.getAddresses().size() > 0 && user.getAddresses() != null)
            try {
                latLong = user.getAddresses().get(0).getGeometry().getLatLong().getLatitude()
                        + "," + user.getAddresses().get(0).getGeometry().getLatLong().getLongitude();
                latLong += "\n" + user.getAddresses().get(0).getFormattedAddress();
            } catch (Exception e) {
                e.printStackTrace();
            }
        latLongTV.setText(latLong);
    }

    private class GeoCoderHandler extends Handler {
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
            latLongTV.setText(locationAddress);
        }
    }
}