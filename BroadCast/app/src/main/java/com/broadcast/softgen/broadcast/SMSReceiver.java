package com.broadcast.softgen.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsMessage;

public class SMSReceiver extends BroadcastReceiver {
    private static SmsListener mListener;

    @Override
    public void onReceive(Context context, Intent intent) {
        Bundle data = intent.getExtras();

        Object[] pdus = (Object[]) data.get("pdus");

        for (int i = 0; i < pdus.length; i++) {
            SmsMessage smsMessage = SmsMessage.createFromPdu((byte[]) pdus[i]);

            String sender = smsMessage.getDisplayOriginatingAddress();
            //Check the sender to filter messages which we require to read

            if (sender.equals("97385")) {
                String messageBody = smsMessage.getMessageBody();
                //Pass the message text to interface
                mListener.messageReceived(messageBody);
                mListener.senderAddress(sender);

            }
        }

    }

    public static void bindListener(SmsListener listener) {
        mListener = listener;
    }
}
