package com.example.mahesha.fragmentexamples;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.example.mahesha.activityexamples.R;

public class TTFragmentActivity extends AppCompatActivity {
    FragmentManager fm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ttfragment);
        fm = getSupportFragmentManager();
    }

    public void addSignUp(View view) {
        TestFragment fragmentA = new TestFragment();

        FragmentTransaction transaction = fm.beginTransaction();
        transaction.add(R.id.freg_cont, fragmentA, "signup");
        transaction.commit();
    }

    public void removeSignUp(View view) {
        TestFragment fragmentA = (TestFragment) fm.findFragmentByTag("signup");
        FragmentTransaction transaction = fm.beginTransaction();

        if (fragmentA != null) {
            transaction.remove(fragmentA);
            transaction.commit();
        } else {
            Toast.makeText(this, "Fragment A not Found", Toast.LENGTH_SHORT).show();
        }
    }
}
