package com.example.mahesha.activityexamples;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.mahesha.utility.SharedUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {
    @BindView(R.id.tet_suser_name)
    TextInputEditText mUserName;
    @BindView(R.id.tet_sPassword)
    TextInputEditText mPassword;
    @BindView(R.id.cb_sRememberMe)
    CheckBox mRememberMe;
    @BindView(R.id.bt_sLogin)
    Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        if (SharedUtils.isRememberMe(this)){
            mUserName.setText(SharedUtils.getUserName(this));
            mPassword.setText(SharedUtils.getPassword(this));
            mRememberMe.setChecked(true);
        }
    }

    @OnClick(R.id.bt_sLogin)
    void login() {
        if (validCredentials()) {
            if (mRememberMe.isChecked()) {
                SharedUtils.saveRememberMe(this, true);
                SharedUtils.storeUserName(this, mUserName.getText().toString());
                SharedUtils.storePasword(this, mPassword.getText().toString());

            } else {
                SharedUtils.saveRememberMe(this, false);
            }
            finish();
            startActivity(new Intent(this,MainActivity.class));
        }

    }

    boolean validCredentials() {
        boolean isValid = false;
        if (mUserName.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter Vaild UserName", Toast.LENGTH_SHORT).show();
        } else if (mPassword.getText().toString().isEmpty()) {
            Toast.makeText(this, "Enter Vaild Pasword", Toast.LENGTH_SHORT).show();
        } else {
            isValid = true;
        }
        return isValid;
    }
}
