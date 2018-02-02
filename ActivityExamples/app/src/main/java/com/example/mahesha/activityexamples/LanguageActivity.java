package com.example.mahesha.activityexamples;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.mahesha.utility.Session;

import java.util.Locale;

public class LanguageActivity extends AppCompatActivity {
    private Session session;
    Locale myLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language);
        session = new Session(LanguageActivity.this);
        findViewById(R.id.login_lang).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                session.setLogin(true);
                Intent i = new Intent(LanguageActivity.this,
                        MainActivity.class);
                startActivity(i);
                finish();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_language, menu);
        return true;
    }


    public void setLocale(String lang) {
        myLocale = new Locale(lang);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);
        finish();
        Intent refresh = new Intent(this, MainActivity.class);
        startActivity(refresh);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.telugu:
                setLocale("te");
                break;
            case R.id.tamil:
                setLocale("ta");
                break;
            case R.id.hindi:
                setLocale("hi");
                break;
            case R.id.english:
                setLocale("uk");
                break;
        }
        return true;
    }

}
