package com.tecmax.basicappli.db;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.tecmax.basicappli.R;

import java.util.List;

public class LogDbActivity extends AppCompatActivity {
    EditText una, pas;
    MyDb db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_db);
        una = findViewById(R.id.una);
        pas = findViewById(R.id.pas);
        db = new MyDb(this);
        List<Usere> ffv = db.getUsers();
        ffv.size();
    }

    public void login(View view) {
        Usere user = new Usere();
        user.setUsername(una.getText().toString());
        user.setPassword(pas.getText().toString());
        if (db.insertUser(user) > 0) {
            Toast.makeText(this, "Inserted Successfully",
                    Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Inserted Failed",
                    Toast.LENGTH_SHORT).show();
        }
    }


}
