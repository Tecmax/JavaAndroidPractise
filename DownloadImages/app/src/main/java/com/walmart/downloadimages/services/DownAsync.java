package com.walmart.downloadimages.services;

import android.os.AsyncTask;

import com.walmart.downloadimages.receiver.DownActInterface;

public class DownAsync extends AsyncTask<Integer, Void, String> {
    private DownActInterface downActInterface;

    public DownAsync(DownActInterface downAct) {
        downActInterface = downAct;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

    }

    @Override
    protected String doInBackground(Integer... integers) {
        downActInterface.onFinishTask("Hello Wordld" + integers);
        return "Hello Wordld" + integers;
    }
}


// Retrofit