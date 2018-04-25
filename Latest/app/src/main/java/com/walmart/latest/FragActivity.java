package com.walmart.latest;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.walmart.latest.fragm.AmFragment;
import com.walmart.latest.fragm.VmFragment;

public class FragActivity extends AppCompatActivity implements View.OnClickListener {
    Button addA, addB, RemA, Remb, replA, replB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frag);
        addA = findViewById(R.id.addA);
        addB = findViewById(R.id.addb);
        RemA = findViewById(R.id.removeA);
        Remb = findViewById(R.id.remB);
        replA = findViewById(R.id.replacea);
        replB = findViewById(R.id.replaceb);

        addA.setOnClickListener(this);
        addB.setOnClickListener(this);
        RemA.setOnClickListener(this);
        Remb.setOnClickListener(this);
        replA.setOnClickListener(this);
        replB.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        FragmentManager dd = getSupportFragmentManager();

        switch (view.getId()) {
            case R.id.addA:
                FragmentTransaction mFragmentTransaction = dd.beginTransaction();
                mFragmentTransaction.add(R.id.frameCont, new VmFragment(), VmFragment.class.getSimpleName());
                mFragmentTransaction.commit();
                break;
            case R.id.addb:
                FragmentTransaction mFragmentTransaction1 = dd.beginTransaction();
                mFragmentTransaction1.add(R.id.frameCont, new AmFragment(), "e");
                mFragmentTransaction1.commit();
                break;
            case R.id.removeA:
                Fragment ff = dd.findFragmentByTag(VmFragment.class.getSimpleName());
                FragmentTransaction mff = dd.beginTransaction();
                if (ff != null) {
                    mff.remove(ff);
                    mff.commit();
                } else Toast.makeText(this, "No Fragments Added", Toast.LENGTH_SHORT).show();

                break;
            case R.id.remB:
                Fragment ff3 = dd.findFragmentByTag("e");
                FragmentTransaction mfff = dd.beginTransaction();
                if (ff3 != null) {
                    mfff.remove(ff3);
                    mfff.commit();
                } else Toast.makeText(this, "No Fragments Added", Toast.LENGTH_SHORT).show();
                break;
            case R.id.replacea:
                FragmentTransaction mrepl1 = dd.beginTransaction();
                mrepl1.replace(R.id.pasc, new AmFragment(), "e");
                mrepl1.commit();
                break;
            case R.id.replaceb:
                FragmentTransaction sss = dd.beginTransaction();
                sss.replace(R.id.pasc, new VmFragment(), VmFragment.class.getSimpleName());
                sss.commit();
                break;
        }
    }
}
