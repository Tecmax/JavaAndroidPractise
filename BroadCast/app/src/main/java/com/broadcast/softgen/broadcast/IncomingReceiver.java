package com.broadcast.softgen.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.telephony.TelephonyManager;

/**
 * Created by Mahesh on 14-06-2017.
 */

public class IncomingReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);
        if (state.equals(TelephonyManager.EXTRA_STATE_RINGING)) {
            String number = intent.getExtras().getString
                    (TelephonyManager.EXTRA_INCOMING_NUMBER);
            DbHelper dbHelper = new DbHelper(context);
            SQLiteDatabase database = dbHelper.getWritableDatabase();
            dbHelper.saveNumber(number, database);
            dbHelper.close();
        }
        Intent intent1 = new Intent(DbContract.UPDATE_UI);
        context.sendBroadcast(intent1);
    }
}
