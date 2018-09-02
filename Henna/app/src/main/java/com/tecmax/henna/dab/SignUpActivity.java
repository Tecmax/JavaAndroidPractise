package com.tecmax.henna.dab;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.tecmax.henna.R;

import java.util.List;

public class SignUpActivity extends AppCompatActivity {
    EditText un, pa, mob, email, addre;
    Button signUp, getDetails;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up2);
        final DbHelper dbIn = new DbHelper(this);
        un = findViewById(R.id.dbUn);
        pa = findViewById(R.id.dbPA);
        mob = findViewById(R.id.dbMobile);
        email = findViewById(R.id.dbeM);
        addre = findViewById(R.id.dbADD);
        signUp = findViewById(R.id.signUp);
        getDetails = findViewById(R.id.getAll);
        signUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UserDetails userDetails = new UserDetails();
                userDetails.setPassword(pa.getText().toString());
                userDetails.setMobile(mob.getText().toString());
                userDetails.setEmail(email.getText().toString());
                userDetails.setAddress(addre.getText().toString());
                userDetails.setUsername(un.getText().toString());
                dbIn.addUser(userDetails);
            }
        });

        getDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                List<UserDetails> details = dbIn.getAllUsers();
                for (UserDetails details1 : details) {
                    Log.e("GetDetails", details1.getUsername() + "");
                    Log.e("GetDetails1", details1.getAddress() + "");
                    Log.e("GetDetails2", details1.getEmail() + "");
                    Log.e("GetDetails3", details1.getPassword() + "");
                }

            }
        });
    }
}
