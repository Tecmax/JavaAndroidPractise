package com.walmart.downloadimages.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import com.walmart.downloadimages.R;
import com.walmart.downloadimages.fragment.NetworkFragment;

public class DownloadActivity extends AppCompatActivity {

    private static FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download);
        fragmentManager = getSupportFragmentManager();
        replaceFragment(new NetworkFragment(), NetworkFragment.class.getSimpleName(), false);
    }

    public static void replaceFragment(Fragment fragment, String tag, boolean isBackStack) {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragCont, fragment, tag);
        if (isBackStack)
            fragmentTransaction.addToBackStack(tag);
        fragmentTransaction.commit();
    }
}
