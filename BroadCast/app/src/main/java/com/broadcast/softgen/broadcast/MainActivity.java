package com.broadcast.softgen.broadcast;

import android.Manifest;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private TextView alertText;
    private RecyclerView.LayoutManager layoutManager;
    private ArrayList<IncomingNumber> arrayList = new ArrayList<>();
    private RecycleAdapter recycleAdapter;
    private BroadcastReceiver broadcastReceiver;
    private static final int REQUEST_CODE_READ_PHONE_STATE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getPermissions(this, REQUEST_CODE_READ_PHONE_STATE);
        recyclerView = (RecyclerView) findViewById(R.id.listRecycle);
        alertText = (TextView) findViewById(R.id.alertText);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recycleAdapter = new RecycleAdapter(arrayList);
        recyclerView.setAdapter(recycleAdapter);
        readFromDb();
        broadcastReceiver = new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                readFromDb();
            }
        };
    }

    private void readFromDb() {
        arrayList.clear();
        DbHelper dbHelper = new DbHelper(this);
        SQLiteDatabase database = dbHelper.getWritableDatabase();
        Cursor cursor = dbHelper.readNumber(database);
        if (cursor.getCount() > 0) {
            while (cursor.moveToNext()) {
                String number;
                int id;
                number = cursor.getString(cursor.getColumnIndex(DbContract.INCOMING_NUMBER));
                id = cursor.getInt(cursor.getColumnIndex("id"));
                arrayList.add(new IncomingNumber(id, number));
            }
            cursor.close();
            dbHelper.close();
            recycleAdapter.notifyDataSetChanged();
            recyclerView.setVisibility(View.VISIBLE);
            alertText.setVisibility(View.GONE);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        registerReceiver(broadcastReceiver, new IntentFilter(DbContract.UPDATE_UI));
    }

    @Override
    protected void onPause() {
        super.onPause();
        unregisterReceiver(broadcastReceiver);
    }

    private void getPermissions(Activity mActivity, int requestCode) {
        String permission = Manifest.permission.READ_PHONE_STATE;
        if (!isPermissionEnabled(permission)) {
            ActivityCompat.requestPermissions(mActivity,
                    new String[]{permission},
                    requestCode);
        }
    }

    private boolean isPermissionEnabled(String permission) {
        return ContextCompat.checkSelfPermission(this,
                permission)
                == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_READ_PHONE_STATE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Read Phone state permission not enabled", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
            }
        }
    }
}
