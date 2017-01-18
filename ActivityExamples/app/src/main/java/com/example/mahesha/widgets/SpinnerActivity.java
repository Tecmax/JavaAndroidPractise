package com.example.mahesha.widgets;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.mahesha.activityexamples.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import static com.example.mahesha.utility.Utils.loadJSONFromAsset;

public class SpinnerActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    private static final String TAG ="SpinnerActivity" ;
    private Context mCon;
    RelativeLayout actSpi;
    EditText phoneNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);
        actSpi = (RelativeLayout) findViewById(R.id.activity_spinner);
        mCon = SpinnerActivity.this;
        phoneNo = (EditText) findViewById(R.id.phoneNo);
        Button call = (Button) findViewById(R.id.call);
        Button message = (Button) findViewById(R.id.message);
        ArrayList<String> list = new ArrayList<String>();
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(getApplicationContext()));
            JSONArray jsonArray = obj.getJSONArray("services");
            if (jsonArray != null) {
                int len = jsonArray.length();
                for (int i=0;i<len;i++){
                    list.add(jsonArray.get(i).toString());
                }
            }
            Log.d(TAG, "onCreate: "+list);
        } catch (JSONException e) {
            e.printStackTrace();
        }



        // Spinner element
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        // Spinner click listener
        spinner.setOnItemSelectedListener(SpinnerActivity.this);
        // Spinner Drop down elements
        List<String> categories = new ArrayList<String>();
        categories.add("Automobile");
        categories.add("Business Services");
        categories.add("Computers");
        categories.add("Education");
        categories.add("Personal");
        categories.add("Travel");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter <String>(this, android.R.layout.simple_spinner_item, list);
        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item);
        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);




        call.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent callIntent = new Intent(Intent.ACTION_CALL);
                    if (!String.valueOf(phoneNo.getText()).trim().isEmpty()) {
                        callIntent.setData(Uri.parse("tel:+91"+ String.valueOf(phoneNo.getText())));
                    } else {
                        Snackbar.make(v, "please enter your phone no", Snackbar.LENGTH_SHORT).show();
                    }
                    if (ActivityCompat.checkSelfPermission(mCon, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
                        if (ActivityCompat.shouldShowRequestPermissionRationale(SpinnerActivity.this,
                                Manifest.permission.CALL_PHONE)) {
                        } else {
                            ActivityCompat.requestPermissions(SpinnerActivity.this,
                                    new String[]{Manifest.permission.CALL_PHONE},
                                    1);

                        }
                    }
                    Snackbar.make(v, "Call Selected", Snackbar.LENGTH_SHORT).show();
                    mCon.startActivity(callIntent);
                } catch (Exception e) {
                    Snackbar.make(v, "Your call has failed...", Snackbar.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        });
        message.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent msgIntent = new Intent(Intent.ACTION_VIEW);
//                msgIntent.putExtra("sms_body", "default content");
//                msgIntent.setType("vnd.android-dir/mms-sms");
//                msgIntent.putExtra("address",String.valueOf(phoneNo.getText()));
//                msgIntent.putExtra("sms_body", "Test ");
//                if (ContextCompat.checkSelfPermission(SpinnerActivity.this,
//                        Manifest.permission.SEND_SMS)
//                        != PackageManager.PERMISSION_GRANTED) {
//                    if (ActivityCompat.shouldShowRequestPermissionRationale(SpinnerActivity.this,
//                            Manifest.permission.SEND_SMS)) {
//                    } else {
//                        ActivityCompat.requestPermissions(SpinnerActivity.this,
//                                new String[]{Manifest.permission.SEND_SMS},
//                                2);
//                    }
//                }
//                startActivity(msgIntent);
                sendSMS();
                Snackbar.make(v, "Message Selected", Snackbar.LENGTH_SHORT).show();
            }
        });
    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String item = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), "Selected: " + item, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    protected void sendSMS() {
        Log.i("Send SMS", "");
        Intent smsIntent = new Intent(Intent.ACTION_VIEW);

        smsIntent.setData(Uri.parse("smsto:"));
        smsIntent.setType("vnd.android-dir/mms-sms");
        smsIntent.putExtra("address"  , new String ("012343543554"));
        smsIntent.putExtra("sms_body"  , "Test ");

        try {
            startActivity(smsIntent);
            finish();
            Log.i("Finished sending SMS...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(SpinnerActivity.this,
                    "SMS faild, please try again later.", Toast.LENGTH_SHORT).show();
        }
    }
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case 1: {

                // If request is cancelled, the result arrays are empty.
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    Snackbar.make(actSpi, "Permission granted",
                            Snackbar.LENGTH_SHORT).show();
                    // permission was granted, yay! Do the
                    // contacts-related task you need to do.
                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.
                    Toast.makeText(mCon, "Permission denied to read your External storage", Toast.LENGTH_SHORT).show();
                    return;
                }
                break;
            }
            case 2:{
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(String.valueOf(phoneNo.getText()), null, "HEllo", null, null);
                    Toast.makeText(getApplicationContext(), "SMS sent.",
                            Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(getApplicationContext(),
                            "SMS faild, please try again.", Toast.LENGTH_LONG).show();
                    return;
                }
            }
                break;
        }
    }


}
