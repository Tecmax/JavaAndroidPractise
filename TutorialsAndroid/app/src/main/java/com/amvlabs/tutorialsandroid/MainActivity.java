package com.amvlabs.tutorialsandroid;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button lsd = findViewById(R.id.btLogin);
        final EditText sds = findViewById(R.id.etUserName);
        final EditText adsd = findViewById(R.id.etPassword);
        final TextInputLayout sdf = findViewById(R.id.tilUna);
        final TextInputLayout ssdf = findViewById(R.id.tilPss);


        lsd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uns = sds.getText().toString();
                String sdsuns = adsd.getText().toString();
                if (uns.isEmpty()){
                    sdf.setError("Enter Username");
//                    Toast.makeText(MainActivity.this, "Enter Username", Toast.LENGTH_SHORT).show();
                }else if(sdsuns.isEmpty()){
                    sdf.setError(null);
                    ssdf.setError("Enter Password");
                }else{
                    sdf.setError(null);
                    ssdf.setError(null);
                    Intent intent = new Intent(MainActivity.this, CustViewsActivity.class);
                    startActivity(intent);
                    finish();
                }
            }
        });
    }
}
