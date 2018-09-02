package com.tecmax.henna;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
    SeekBar sb;
    RatingBar ratingBar;
    Button button;
    Spinner state;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        sb = findViewById(R.id.sbSeek);
        button = findViewById(R.id.btAlert);
        state = findViewById(R.id.spState);
        sb.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int count = 0;

            @Override
            public void onProgressChanged(SeekBar seekBar, int position, boolean b) {
                count = position;
                Toast.makeText(HomeActivity.this, "Positions on Progress " + count, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(HomeActivity.this, "Positions on Start " + count, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(HomeActivity.this, "Positions on Stop " + count, Toast.LENGTH_SHORT).show();
            }
        });
        ratingBar = findViewById(R.id.rbstar);
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {
                Toast.makeText(HomeActivity.this, "rated " + ratingBar.getRating(), Toast.LENGTH_SHORT).show();

            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showPopUp();
            }
        });

        /**Spinner Data Inserting**/
        String[] stateList = {"KA", "TN", "TS", "AP", "UP", "DL", "KL"};
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, stateList);
        state.setAdapter(adapter);

        state.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String selectedValue = adapterView.getItemAtPosition(position).toString();
                Toast.makeText(HomeActivity.this, "Selected is  " + selectedValue, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void showPopUp() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Caution");
        builder.setMessage("Hello Buddies");
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Intent intent = new Intent(HomeActivity.this, TempActivity.class);
                startActivity(intent);
                Toast.makeText(HomeActivity.this, "Clicked Yes", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(HomeActivity.this, "Clicked No", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(false);
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}
