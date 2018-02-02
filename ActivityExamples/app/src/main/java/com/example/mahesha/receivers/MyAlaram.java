package com.example.mahesha.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.widget.Toast;

import com.example.mahesha.activityexamples.R;

public class MyAlaram extends BroadcastReceiver {
    MediaPlayer mp;

    public MyAlaram() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        mp = MediaPlayer.create(context, R.raw.ring);
        mp.start();
        Toast.makeText(context, "Alarm....", Toast.LENGTH_LONG).show();
    }
}
