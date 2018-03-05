package com.tecmax.basicappli.navagation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.tecmax.basicappli.R;
import com.tecmax.basicappli.fragment.BlankFragment;
import com.tecmax.basicappli.fragment.InterFragment;
import com.tecmax.basicappli.fragment.InterFragment.OnFragmentInteractionListener;
import com.tecmax.basicappli.fragment.SugFragment;
import com.tecmax.basicappli.tabActivity.WhatsAppActivity;

public class HomeActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, BlankFragment.onfragmentChange, OnFragmentInteractionListener {
    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragmentManager = getSupportFragmentManager();
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Welcome", new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Toast.makeText(HomeActivity.this, "Hello", Toast.LENGTH_SHORT).show();
                            }
                        }).show();
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        Intent intent = new Intent();
        intent.putExtra("MESSAGE", "received");
        setResult(1, intent);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            startActivity(new Intent(this, AlertActivity.class));
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {
            Log.e("Santosh", "Fragment Open");
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

            Bundle bundle = new Bundle();
            bundle.putString("edttext", "Data to be Transferred");
            // set Fragment class Arguments
            BlankFragment fragment = new BlankFragment();
            fragment.setArguments(bundle);
            fragmentTransaction.replace(R.id.con, fragment, BlankFragment.class.getSimpleName());
            fragmentTransaction.addToBackStack("dd");
            fragmentTransaction.commit();
        } else if (id == R.id.nav_slideshow) {
            replaceFragment(new InterFragment(), InterFragment.class.getSimpleName());
        } else if (id == R.id.nav_manage) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.replace(R.id.con, new SugFragment(), "d");
            fragmentTransaction.addToBackStack("dd");
            fragmentTransaction.commit();

        } else if (id == R.id.nav_share) {
            startActivity(new Intent(this, WhatsAppActivity.class));
        } else if (id == R.id.nav_send) {
            startActivity(new Intent(this, VegetableActivity.class));
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void onFragmentInteraction(String name, Uri uri) {
        Toast.makeText(this, "Just Change " + name, Toast.LENGTH_SHORT).show();
    }

    public static void replaceFragment(Fragment fragment, String tag) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.con, fragment, tag);
        fragmentTransaction.commit();
    }

    @Override
    public void sendFragment(Fragment fragment, String tag) {
        replaceFragment(fragment, tag);
    }
}
