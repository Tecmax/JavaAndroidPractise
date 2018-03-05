package com.tecmax.testaksh.example;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.tecmax.testaksh.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class TestActivity extends AppCompatActivity {
    private EditText fromDate;
    private EditText toDate;
    private DatePickerDialog datePickerDialog;
    private DatePickerDialog datePickerDialog1;
    TextView time;
    TimePicker simpleTimePicker;
    int fromDay, fromMonth, fromYear;
    private String selDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        // initiate the date picker and a button
        fromDate = findViewById(R.id.fromDate);
        toDate = findViewById(R.id.toDate);
        // perform click event on edit text
        fromDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calender class's instance and get current date , month and year from calender
                final Calendar c = Calendar.getInstance();
                int mYear = c.get(Calendar.YEAR); // current year
                fromYear = mYear;
                int mMonth = c.get(Calendar.MONTH); // current month
                fromMonth = mMonth;
                int mDay = c.get(Calendar.DAY_OF_MONTH); // current day
                fromDay = mDay;
                // date picker dialog
                datePickerDialog = new DatePickerDialog(TestActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                fromDate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);
                                fromDay = dayOfMonth + 1;
                                fromMonth = monthOfYear;
                                fromYear = year;
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
                datePickerDialog.show();

            }
        });
        toDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialog1 = new DatePickerDialog(TestActivity.this,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                // set day of month , month and year value in the edit text
                                toDate.setText(dayOfMonth + "/"
                                        + (monthOfYear + 1) + "/" + year);

                            }
                        }, fromYear, fromMonth, fromDay);
                Date cc = convertStringToDate(fromDay + "/" + (fromMonth + 1) + "/" + fromYear);
                datePickerDialog1.getDatePicker().setMinDate(cc.getTime());
//                datePickerDialog1.getDatePicker().setMaxDate(cc.getTime());
                datePickerDialog1.show();
            }
        });
        inItDate();
    }

    private void inItDate() {
        time = findViewById(R.id.time);
        simpleTimePicker = findViewById(R.id.simpleTimePicker);
        simpleTimePicker.setIs24HourView(false); // used to display AM/PM mode
        // perform set on time changed listener event
        simpleTimePicker.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                // display a toast with changed values of time picker
                Toast.makeText(getApplicationContext(), hourOfDay + "  " + minute, Toast.LENGTH_SHORT).show();
                time.setText("Time is :: " + hourOfDay + " : " + minute); // set the current time in text view
            }
        });
    }

    Date convertStringToDate(String selDate) {
        DateFormat format = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Date date = null;
        try {
            date = format.parse(selDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return date;
    }
}
