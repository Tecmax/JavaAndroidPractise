package com.tecmax.basicappli;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class TempActivity extends AppCompatActivity {
    RecyclerView tempRv;
    RecyclerView.LayoutManager layoutManager;
    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tempRv = findViewById(R.id.tempRv);
        layoutManager = new LinearLayoutManager(this);
        tempRv.setLayoutManager(layoutManager);

        String[] names = {"Harsha", "Priyanka", "Sukanya", "Rahul", "Santosh"};
        String[] lang = {"Harsha", "Priyanka", "Sukanya", "Rahul", "Santosh"};
        String[] cert = {"Harsha", "Priyanka", "Sukanya", "Rahul", "Santosh"};
        String[] rating = {"Harsha", "Priyanka", "Sukanya", "Rahul", "Santosh"};
        String[] old = {"Harsha", "Priyanka", "Sukanya", "Rahul", "Santosh"};
        List<TempEntity> tempEntities = new ArrayList<>();

        for (int i = 0; i < names.length; i++) {
            TempEntity entity = new TempEntity();
            entity.setCertificate(cert[i]);
            entity.setLangu(lang[i]);
            entity.setName(names[i]);
            entity.setOld(old[i]);
            entity.setRating(rating[i]);
            tempEntities.add(entity);
        }

        TempAdapter tempAdapter = new TempAdapter(tempEntities);
        tempRv.setAdapter(tempAdapter);
    }

}
