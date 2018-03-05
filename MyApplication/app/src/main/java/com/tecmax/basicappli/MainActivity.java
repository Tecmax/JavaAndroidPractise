package com.tecmax.basicappli;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.PopupMenu;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.tecmax.basicappli.map.GoogleActivity;
import com.tecmax.basicappli.navagation.HomeActivity;
import com.tecmax.basicappli.realm.RealmDbActivity;

import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    RelativeLayout relativeLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = findViewById(R.id.parentPanel);
        final Button su = findViewById(R.id.signUp);
        TextView we = findViewById(R.id.tvWelcome);
        su.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, SignUpActivity.class));
            }
        });
        ImageView sus = findViewById(R.id.logo);
        sus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, AmazonProductsActivity.class));
            }
        });
        we.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                PopupMenu popup = new PopupMenu(MainActivity.this, su);
                //Inflating the Popup using xml file
                popup.getMenuInflater().inflate(R.menu.settings_menu, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.privacy:
                                startActivity(new Intent(MainActivity.this,
                                        GoogleActivity.class));
                                break;
                            case R.id.rateUs:
                                startActivity(new Intent(MainActivity.this,
                                        TempActivity.class));
                                break;
                        }
                        return false;
//                        return true;
                    }
                });

                popup.show();//showing popup menu
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.settings_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.privacy:
                startActivityForResult(new Intent(this, HomeActivity.class),
                        1);
                Snackbar.make(relativeLayout, "DSDS", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.rateUs:
                startActivity(new Intent(this, TempActivity.class));
                break;
            case R.id.contactUs:
                startActivity(new Intent(this, RealmDbActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1) {
            String message = data.getStringExtra("MESSAGE");
            Log.d(TAG, message);
        }
    }
}
