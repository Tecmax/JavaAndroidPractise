package com.example.mahesha.receivers;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mahesha.activityexamples.R;

public class AkshBindActivity extends AppCompatActivity implements View.OnClickListener {
    EditText fName, lName, password;
    TextView forgetPassword;
    Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.linexlayout);
        fName = (EditText) findViewById(R.id.ak_username);
        lName = (EditText) findViewById(R.id.ak_lastname);
        password = (EditText) findViewById(R.id.ak_password);
        forgetPassword = (TextView) findViewById(R.id.ak_forgetPassword);
        login = (Button) findViewById(R.id.ak_login);
        login.setOnClickListener(this);
        forgetPassword.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ak_login:
                String fiName = fName.getText().toString();
                String laName = lName.getText().toString();
                String pass = password.getText().toString();
                if (fiName.isEmpty() || laName.isEmpty()) {
                    Toast.makeText(this, "Please Enter Valid Name", Toast.LENGTH_SHORT).show();
                } else if (pass.isEmpty()) {
                    Toast.makeText(this, "Please Enter Valid Password", Toast.LENGTH_SHORT).show();
                } else if (pass.length() < 8) {
                    Toast.makeText(this, "Password should be atleast 8 char", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Button Clicked", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.ak_forgetPassword:
                Toast.makeText(this, "Forget Clicked", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    void validateCredentials() {
        String fiName = fName.getText().toString();
        String laName = lName.getText().toString();
        String pass = password.getText().toString();
    }
}
