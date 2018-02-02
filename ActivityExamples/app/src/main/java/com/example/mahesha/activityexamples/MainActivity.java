package com.example.mahesha.activityexamples;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.crashlytics.android.Crashlytics;
import com.example.mahesha.animations.AnimationsActivity;
import com.example.mahesha.databasehandellers.DBHelper;
import com.example.mahesha.fragmentexamples.TTFragmentActivity;
import com.example.mahesha.jsonHandeling.JsonActivity;
import com.example.mahesha.maps.MapsActivity;
import com.example.mahesha.maps.TestMapsActivity;
import com.example.mahesha.model.ProfileMaster;
import com.example.mahesha.networkRV.AndroidGridLayoutActivity;
import com.example.mahesha.notificatons.EffectiveNavagationActivity;
import com.example.mahesha.notificatons.NotificaionActivity;
import com.example.mahesha.recyclerview.RecyclerActivity;
import com.example.mahesha.services.PermissionsActivity;
import com.example.mahesha.tabs.TabsActivity;
import com.example.mahesha.widgets.AlaramActivity;
import com.example.mahesha.widgets.GoogleActivity;

import java.util.Locale;

import io.fabric.sdk.android.Fabric;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Locale myLocale;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Fabric.with(this, new Crashlytics());
        setContentView(R.layout.activity_main);
        DBHelper db = new DBHelper(this);
//        Toast.makeText(this, "On Create", Toast.LENGTH_SHORT).show();
        Button fragments = (Button) findViewById(R.id.bt_fragments);
        Button maps = (Button) findViewById(R.id.bt_maps);
        Button widgets = (Button) findViewById(R.id.bt_widgets);
        ProfileMaster obj = new ProfileMaster();
        obj.setUsername("Mahesh");
        obj.setMobile("8114446564");
        obj.setEmail("Mahesh@nals");
        obj.setCity("Bangalore");
        obj.setState("Ktaka");
        obj.setArea("Bang");
        obj.setPassword("Mahesh30");
//        db.createProfileUser(obj);
        fragments.setOnClickListener(this);
        maps.setOnClickListener(this);
        widgets.setOnClickListener(this);
        findViewById(R.id.bt_Animations).setOnClickListener(this);
        findViewById(R.id.bt_Notifications).setOnClickListener(this);
        findViewById(R.id.bt_Recycler).setOnClickListener(this);
        findViewById(R.id.bt_Navagations).setOnClickListener(this);
        findViewById(R.id.bt_Alaram).setOnClickListener(this);
        findViewById(R.id.bt_music_palyer).setOnClickListener(this);
        findViewById(R.id.bt_tabs).setOnClickListener(this);
        findViewById(R.id.bt_bootom_bar).setOnClickListener(this);
        findViewById(R.id.bt_permissions).setOnClickListener(this);
        findViewById(R.id.bt_languages).setOnClickListener(this);
        findViewById(R.id.grid_lay).setOnClickListener(this);
        findViewById(R.id.bt_navagation).setOnClickListener(this);
        findViewById(R.id.bt_realtime).setOnClickListener(this);
        findViewById(R.id.bt_json).setOnClickListener(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.e("MainActivity", "on restart");
//        Toast.makeText(this, "onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
//        Toast.makeText(this, "onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
//        Toast.makeText(this, "onResume", Toast.LENGTH_SHORT).show();
        // The activity has become visible (it is now "resumed").
    }

    @Override
    protected void onPause() {
        super.onPause();
//        Toast.makeText(this, "onPause", Toast.LENGTH_SHORT).show();
        // Another activity is taking focus (this activity is about to be "paused").
    }

    @Override
    protected void onStop() {
        super.onStop();
//        Toast.makeText(this, "onStop", Toast.LENGTH_SHORT).show();
        // The activity is no longer visible (it is now "stopped")
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
//        Toast.makeText(this, "onDestroy", Toast.LENGTH_SHORT).show();
        // The activity is about to be destroyed.
    }

    public void nextAct(View view) {
        finish();
//        Intent nex = new Intent(this, SelectImageActivity.class);
//        Intent nex = new Intent(this, AnotherTestActivity.class);
        Intent nex = new Intent(this, LoginActivity.class);
        startActivity(nex);
    }

    public void nextActici(View view) {
//        Intent nex = new Intent(this, LinearActivity.class);
//        Intent nex = new Intent(this, AkshBindActivity.class);
        Intent nex = new Intent(this, TestMapsActivity.class);
        startActivity(nex);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.grid_lay:
                startActivity(new Intent(this, AndroidGridLayoutActivity.class));
                break;
            case R.id.bt_fragments:
//                startActivity(new Intent(this, FragmentTestActivity.class));
                startActivity(new Intent(this, TTFragmentActivity.class));
                break;
            case R.id.bt_maps:
                startActivity(new Intent(this, MapsActivity.class));
//                startActivity(new Intent(this, Maps1Activity.class));
//                startActivity(new Intent(this, MultiLatLongActivity.class));
                break;
            case R.id.bt_widgets:
                startActivity(new Intent(this, WidgetsActivity.class));
                break;
            case R.id.bt_Animations:
//                startActivity(new Intent(this, AnimationsDemoMain.class));
                startActivity(new Intent(this, AnimationsActivity.class));
                break;
            case R.id.bt_Notifications:
                startActivity(new Intent(this, NotificaionActivity.class));
                break;
            case R.id.bt_Navagations:
                startActivity(new Intent(this, EffectiveNavagationActivity.class));
                break;
            case R.id.bt_Recycler:
                startActivity(new Intent(this, RecyclerActivity.class));
                break;
            case R.id.bt_Alaram:
                startActivity(new Intent(this, AlaramActivity.class));
                break;
            case R.id.bt_music_palyer:
                startActivity(new Intent(this, MusicPlayerActivity.class));
                break;
            case R.id.bt_tabs:
                startActivity(new Intent(this, TabsActivity.class));
                break;
            case R.id.bt_bootom_bar:
                startActivity(new Intent(this, TabsActivity.class));
                break;
            case R.id.bt_permissions:
                startActivity(new Intent(this, PermissionsActivity.class));
                break;
            case R.id.bt_languages:
                startActivity(new Intent(this, LanguageActivity.class));
                break;
            case R.id.bt_navagation:
                startActivity(new Intent(this, HomePageActivity.class));
                break;
            case R.id.bt_realtime:
                startActivity(new Intent(this, GoogleActivity.class));
                break;
            case R.id.bt_json:
                startActivity(new Intent(this, JsonActivity.class));
                break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        new MenuInflater(this).inflate(R.menu.menu_language, menu);
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
