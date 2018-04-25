package com.walmart.latest;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class BasicActivity extends AppCompatActivity {
    Button sds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_basic);
        sds= findViewById(R.id.alett);
        sds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showAler();
            }
        });
    }

    private void showAler() {
        AlertDialog.Builder abs= new AlertDialog.Builder(this);
        abs.setTitle("Select An Action");
        abs.setMessage("Hello How are you");
        abs.setCancelable(false);
        abs.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        abs.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        abs.setNeutralButton("Dono", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog c= abs.create();
        c.show();
    }
}
