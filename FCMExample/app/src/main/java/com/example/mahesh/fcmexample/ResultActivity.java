package com.example.mahesh.fcmexample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    private TextView textView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dynamic_activity);
        TextView header = (TextView) findViewById(R.id.header);
        TextView body = (TextView) findViewById(R.id.body);
        String av = getIntent().getStringExtra("Body");
        String titl = getIntent().getStringExtra("title");
        header.setText(av);
        body.setText(titl);
//        textView = (TextView)findViewById(R.id.textView1);
//        textView.setText("Welcome to the Result Activity");

    }
}
