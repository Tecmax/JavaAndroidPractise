package com.tecmax.henna;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.google.gson.Gson;
import com.tecmax.henna.entities.Profile;
import com.tecmax.henna.maps.LocationActivity;
import com.tecmax.henna.retrofit.ApiInterface;
import com.tecmax.henna.retrofit.BaseClientClass;
import com.tecmax.henna.retrofit.LoginRequest;
import com.tecmax.henna.retrofit.LoginResponse;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    AppCompatEditText username, password;
    AppCompatButton login;
    AppCompatTextView createAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initViews();
    }

    /**
     * Declaration Of Views
     **/
    private void initViews() {
        username = findViewById(R.id.etUsername);
        password = findViewById(R.id.etPassword);
        login = findViewById(R.id.btLogin);
        createAccount = findViewById(R.id.tvCreateAccount);
        initClickListeners();

    }

    /**
     * Declaration Of Click Listners
     **/
    private void initClickListeners() {
        createAccount.setOnClickListener(this);
        login.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btLogin:
                Log.e("Login Page", "Json Handeling");
                handelJson();
                validation();
                break;
            case R.id.tvCreateAccount:
//                Intent intent = new Intent(this, SignUpActivity.class);
                Intent intent = new Intent(this, com.tecmax.henna.dab.SignUpActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void handelJson() {
        Profile profile = new Profile();
        Profile.Address address = profile.new Address();

        List<Profile.PhoneNu> phoneList = new ArrayList<>();
        profile.setName("Harsha");
        profile.setAge(26);
        String[] numbers = {"1234567890", "9876543210", "8310701931"};
        String[] type = {"Home", "Work", "Office"};
        for (int i = 0; i < numbers.length; i++) {
            Profile.PhoneNu phone = profile.new PhoneNu();
            phone.setNumber(numbers[i]);
            phone.setType(type[i]);
            phoneList.add(phone);
        }
        address.setArea("BTM");
        address.setCity("Bang");
        address.setState("KA");
        profile.setAddress(address);
        profile.setPhone(phoneList);
        Gson gson = new Gson();
        String json = gson.toJson(profile);
        System.out.println(json);
        Log.e("Converted JSon", json);
        Gson g = new Gson();
        Profile p = g.fromJson(json, Profile.class);
    }

    /**
     * Validating Username and Password
     **/
    private void validation() {
        String mUsername = username.getText().toString();
        String mPassword = password.getText().toString();
        LoginRequest loginRequest = new LoginRequest();
        loginRequest.setUserName(mUsername);
        loginRequest.setPassword(mPassword);
        ApiInterface apiService = BaseClientClass.getBaseClient()
                .create(ApiInterface.class);
        Call<LoginResponse> call = apiService.authenticateUser(loginRequest);
        call.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                if (response.isSuccessful()) {
                    LoginResponse abc = response.body();
                    Toast.makeText(LoginActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(LoginActivity.this, "Lo8gin Un Successful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Invalid", Toast.LENGTH_SHORT).show();
            }
        });


//        if (mUsername.isEmpty()){
//            Toast.makeText(this, "Enter Valid Username", Toast.LENGTH_SHORT).show();
//        }else if (mPassword.isEmpty()){
//            Toast.makeText(this, "Enter Valid Password", Toast.LENGTH_SHORT).show();
//        }else if (!mUsername.equals(mPassword)){
//            Toast.makeText(this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
//        }else{
//        Intent intent = new Intent(this, HomeActivity.class);
//        startActivity(intent);
//        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_tavcsad, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                startActivity(new Intent(this, WebActivity.class));
                break;
            case R.id.action_settings3:
                startActivity(new Intent(this, LocationActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
