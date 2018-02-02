package com.example.mahesha.activityexamples.practsie;

import android.content.ContentResolver;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.SeekBar;
import android.widget.TextView;
import android.provider.Settings.System;

import com.example.mahesha.activityexamples.R;

public class RealTimeActivity extends AppCompatActivity {
    //    SeekBar seekbar;
//    TextView progress;
//    Context context;
//    int Brightness;
    private SeekBar brightbar;

    //Variable to store brightness value
    private int brightness;
    //Content resolver used as a handle to the system's settings
    private ContentResolver cResolver;
    //Window object, that will store a reference to the current window
    private Window window;

    TextView txtPerc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_real_time);
//        seekbar = (SeekBar) findViewById(R.id.seekBar1);
//        progress = (TextView) findViewById(R.id.textView1);
//        context = getApplicationContext();
//
//        //Getting Current screen brightness.
//        Brightness = Settings.System.getInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, 0);
//
//        //Setting up current screen brightness to seekbar;
//        seekbar.setProgress(Brightness);
//
//        //Setting up current screen brightness to TextView;
//        progress.setText("Screen Brightness : " + Brightness);
//
//        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
//            @Override
//            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
//
//                progress.setText("Screen Brightness : " + i);
//
//                //Changing Brightness on seekbar movement.
//
//                Settings.System.putInt(context.getContentResolver(), Settings.System.SCREEN_BRIGHTNESS, i);
//            }
//
//            @Override
//            public void onStartTrackingTouch(SeekBar seekBar) {
//
//            }
//
//            @Override
//            public void onStopTrackingTouch(SeekBar seekBar) {
//
//            }
//        });

        //Instantiate seekbar object
        brightbar = (SeekBar) findViewById(R.id.seekBar1);

        txtPerc = (TextView) findViewById(R.id.textView1);

        //Get the content resolver
        cResolver = getContentResolver();

        //Get the current window
        window = getWindow();

        //Set the seekbar range between 0 and 255
        brightbar.setMax(255);
        //Set the seek bar progress to 1
        brightbar.setKeyProgressIncrement(1);

        try {
            //Get the current system brightness
            brightness = System.getInt(cResolver, System.SCREEN_BRIGHTNESS);
        } catch (Settings.SettingNotFoundException e) {
            //Throw an error case it couldn't be retrieved
            Log.e("Error", "Cannot access system brightness");
            e.printStackTrace();
        }

        //Set the progress of the seek bar based on the system's brightness
        brightbar.setProgress(brightness);

        //Register OnSeekBarChangeListener, so it can actually change values
        brightbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            public void onStopTrackingTouch(SeekBar seekBar) {
                //Set the system brightness using the brightness variable value
                System.putInt(cResolver, System.SCREEN_BRIGHTNESS, brightness);
                //Get the current window attributes
                WindowManager.LayoutParams layoutpars = window.getAttributes();
                //Set the brightness of this window
                layoutpars.screenBrightness = brightness / (float) 255;
                //Apply attribute changes to this window
                window.setAttributes(layoutpars);
            }

            public void onStartTrackingTouch(SeekBar seekBar) {
                //Nothing handled here
            }

            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //Set the minimal brightness level
                //if seek bar is 20 or any value below
                if (progress <= 20) {
                    //Set the brightness to 20
                    brightness = 20;
                } else //brightness is greater than 20
                {
                    //Set brightness variable based on the progress bar
                    brightness = progress;
                }
                //Calculate the brightness percentage
                float perc = (brightness / (float) 255) * 100;
                //Set the brightness percentage
                txtPerc.setText((int) perc + " %");
            }
        });
    }
}
