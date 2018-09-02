package com.tecmax.henna;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.tecmax.henna.adapter.BMSAdapter;
import com.tecmax.henna.entities.Movie;

import java.util.ArrayList;
import java.util.List;

public class TempActivity extends AppCompatActivity {
    RecyclerView bookMyShow;
    RecyclerView.LayoutManager layoutManager;
    GridLayoutManager gridLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        bookMyShow = findViewById(R.id.bms);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(TempActivity.this, TavcsadActivity.class);
                startActivity(intent);
            }
        });
        String[] mNameList = {"MCA", "Mufti", "Thor", "Tiger Zindha Hai", "Premam", "Sathya"};
        String[] mLanguageList = {"Telugu", "Kannada", "English", "Hindi", "Mal", "Tamil"};
        String[] mCertificateList = {"UA", "A", "U", "UA", "U/A", "U"};
        String[] mStatusList = {"New", "Old", "Seen", "New", "Seen", "Old"};
        Integer[] mBannerList = {R.drawable.mca, R.drawable.mufti, R.drawable.thor, R.drawable.tiger,
                R.drawable.premam, R.drawable.satya};

        List<Movie> movieList = new ArrayList<>();
        for (int i = 0; i < mBannerList.length; i++) {
            Movie movie = new Movie();
            movie.setBanner(mBannerList[i]);
            movie.setCertificate(mCertificateList[i]);
            movie.setLanguage(mLanguageList[i]);
            movie.setName(mNameList[i]);
            movie.setOlder(mStatusList[i]);
            movieList.add(movie);
        }
        BMSAdapter bmsAdapter = new BMSAdapter(movieList,this);
        layoutManager = new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
//        gridLayoutManager = new GridLayoutManager(this,2);
        bookMyShow.setLayoutManager(layoutManager);
        bookMyShow.setAdapter(bmsAdapter);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
