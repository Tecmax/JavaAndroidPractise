package com.tecmax.henna;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends AppCompatActivity {
    @BindView(R.id.etUN)
    AppCompatEditText mUserName;
    @BindView(R.id.etEM)
    AppCompatEditText mEmail;
    @BindView(R.id.etMB)
    AppCompatEditText mMobile;
    @BindView(R.id.rbML)
    RadioButton mMale;
    @BindView(R.id.rbFL)
    RadioButton mFemale;
    @BindView(R.id.etPA)
    AppCompatEditText mPassword;
    @BindView(R.id.etCPA)
    AppCompatEditText mConfirmPassword;
    @BindView(R.id.cbTC)
    CheckBox mTermsConditions;
    @BindView(R.id.btSU)
    AppCompatButton mSignUp;
    @BindView(R.id.tvLG)
    AppCompatTextView mLogin;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        ButterKnife.bind(this);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @OnClick(R.id.btSU)
    public void signUp() {
        validateFields();
    }

    private void validateFields() {
        String un = mUserName.getText().toString();
        String em = mEmail.getText().toString();
        String mb = mMobile.getText().toString();
        String pa = mPassword.getText().toString();
        String cpa = mConfirmPassword.getText().toString();
        String mes = "";
        if (un.isEmpty()) {
            mes = "Enter valid Name";
            mUserName.setError(mes);
        } else if (em.isEmpty()) {
            mes = "Enter valid Email";
        } else if (mb.isEmpty()) {
            mes = "Enter valid Mobile";
        } else if (mb.length() < 10) {
            mes = "Mobile Number Invalid";
        } else if (!mMale.isChecked() && !mFemale.isChecked()) {
            mes = "Select your Gender";
        } else if (pa.isEmpty()) {
            mes = "Enter valid Password";
        } else if (pa.length() < 4) {
            mes = "Password too short";
        } else if (cpa.isEmpty()) {
            mes = "Enter valid Confirm Password";
        } else if (!pa.equals(cpa)) {
            mes = "Password doesn't Match";
        } else if (!mTermsConditions.isChecked()) {
            mes = "Please Accept Terms and Conditions";
        } else {
            mes = "SignUp Successful";
            Intent intent = new Intent(this, HomeActivity.class);
            startActivity(intent);
        }
        Toast.makeText(this, mes, Toast.LENGTH_SHORT).show();
    }

    @OnClick(R.id.tvLG)
    public void login() {
        Toast.makeText(this, "rupa", Toast.LENGTH_SHORT).show();
    }
}
