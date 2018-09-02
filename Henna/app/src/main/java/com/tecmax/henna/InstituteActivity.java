package com.tecmax.henna;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.tecmax.henna.adapter.InstituteListAdapter;
import com.tecmax.henna.retrofit.ApiInterface;
import com.tecmax.henna.retrofit.BaseClientClass;
import com.tecmax.henna.retrofit.InstituteList;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InstituteActivity extends AppCompatActivity {
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_institute);
        recyclerView = findViewById(R.id.recu);
        RecyclerView.LayoutManager inflater = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(inflater);
        dsfsd();
    }


    private void dsfsd() {
        ApiInterface apiService = BaseClientClass.getBaseClient().create(ApiInterface.class);
        Call<List<InstituteList>> call = apiService.getInstituteList();


        call.enqueue(new Callback<List<InstituteList>>() {
            @Override
            public void onResponse(Call<List<InstituteList>> call, Response<List<InstituteList>> response) {
                if (response.isSuccessful()) {
                    List<InstituteList> abc = response.body();
                    setAdap(abc);
                    Toast.makeText(InstituteActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(InstituteActivity.this, "Lo8gin Un Successful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<List<InstituteList>> call, Throwable t) {
                Toast.makeText(InstituteActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
            }
        });


    }

    public void setAdap(List<InstituteList> adap) {
        InstituteListAdapter listAdapter = new InstituteListAdapter(adap);
        recyclerView.setAdapter(listAdapter);
    }
}
