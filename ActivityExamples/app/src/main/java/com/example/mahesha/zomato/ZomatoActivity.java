package com.example.mahesha.zomato;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.mahesha.activityexamples.R;
import com.example.mahesha.zomato.model.CollectionResponse;
import com.example.mahesha.zomato.rest.APIInterface;
import com.example.mahesha.zomato.rest.BaseClient;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ZomatoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zomato);
        final EditText cityId = findViewById(R.id.cityId);
        Button getColle = findViewById(R.id.getCollection);
        getColle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getLatestCollection(Integer.parseInt(cityId.getText().toString()));
            }
        });
    }

    private void getLatestCollection(int cityId) {
        APIInterface apiService = BaseClient.getBaseClient().create(APIInterface.class);
        Call<CollectionResponse> call = apiService.getCollectionList(cityId);
        call.enqueue(new Callback<CollectionResponse>() {
            @Override
            public void onResponse(Call<CollectionResponse> call, Response<CollectionResponse> response) {
                if (response.isSuccessful()) {
                    Toast.makeText(ZomatoActivity.this, "Response Received", Toast.LENGTH_SHORT).show();
                    CollectionResponse abd = response.body();
                    Gson gson = new Gson();
                    Log.e("Response", gson.toJson(abd));
                } else {
                    Toast.makeText(ZomatoActivity.this, "Unsuccessful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<CollectionResponse> call, Throwable t) {
                Toast.makeText(ZomatoActivity.this, "Please Try Again Later", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
