package com.walmart.downloadimages.receiver;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;

import com.walmart.downloadimages.fragment.NetworkFragment;
import com.walmart.downloadimages.services.DownloadService;

public class DownloadReceiver extends ResultReceiver {
    NetworkFragment.NetworkRequestListener requestListener;
    public DownloadReceiver(Handler handler,NetworkFragment.NetworkRequestListener mListener) {
        super(handler);
        requestListener=mListener;
    }

    @Override
    protected void onReceiveResult(int resultCode, Bundle resultData) {
        super.onReceiveResult(resultCode, resultData);
        if (resultCode == DownloadService.UPDATE_PROGRESS) {
            int progress = resultData.getInt("progress");
            requestListener.onRequestProgressUpdate(progress);
            if (progress == 100) {
                requestListener.onRequestFinished("Completed");
            }
        }
    }
}
