package com.broadcast.softgen.broadcast;

/**
 * Created by DELL PC on 11-Mar-18.
 */

public interface SmsListener {
     void messageReceived(String messageText);
     void senderAddress(String messageText);
}
