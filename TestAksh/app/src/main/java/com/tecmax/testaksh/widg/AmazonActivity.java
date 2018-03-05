package com.tecmax.testaksh.widg;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.widget.Toast;

import com.tecmax.testaksh.R;
import com.tecmax.testaksh.recycleAdap.PractoAdap;
import com.tecmax.testaksh.recycleAdap.PractoTablet;

import java.util.ArrayList;
import java.util.List;

public class AmazonActivity extends AppCompatActivity {
    RecyclerView az;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amazon);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        az = findViewById(R.id.amazon);
        String named = getIntent().getStringExtra("myName");
        Toast.makeText(this, named, Toast.LENGTH_SHORT).show();
        String[] name = {"MSSS", "DDD","MSSS", "DDD"};
        String[] cn = {"DD", "dddddd","DD", "dddddd"};
        String[] des = {"dsgf", "dsfdsf","dsgf", "dsfdsf"};
        double[] mrp = {55, 88,55, 88};
        double[] sp = {35, 77,35, 77};
        double[] dis = {10, 15,10, 15};
        List<PractoTablet> tablets = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            PractoTablet an = new PractoTablet();
            an.setTabCompany(cn[i]);
            an.setTabName(name[i]);
            an.setTabDescription(des[i]);
            an.setTabDiscount(dis[i]);
            an.setTabMrp(mrp[i]);
            an.setTabSp(sp[i]);
            tablets.add(an);
        }
        layoutManager= new LinearLayoutManager(this);
        az.setLayoutManager(layoutManager);
        PractoAdap cc= new PractoAdap(tablets);
        az.setAdapter(cc);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
