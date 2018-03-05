package com.tecmax.testaksh.example;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.tecmax.testaksh.R;

import java.util.List;
import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private final String TAG = MainActivity.class.getSimpleName();
    private EditText userName;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        userName = findViewById(R.id.n);
        password = findViewById(R.id.pas);
        Button login = findViewById(R.id.btLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validateCredentials();
                Log.d(TAG, "Login Button has Been Clicked");
            }
        });
    }

    private void validateCredentials() {
        String mUserName = userName.getText().toString();
        String mPassword = password.getText().toString();
        Log.i(TAG, "Inside Validating Credentials");
        if (mUserName.isEmpty()) {
            Log.w(TAG, "Username Was Not entered");
            Toast.makeText(this, "Please Enter the Name", Toast.LENGTH_SHORT).show();
        } else if (mPassword.isEmpty()) {
            Log.w(TAG, "Password Was Not entered");
            Toast.makeText(this, "Please Enter the Password", Toast.LENGTH_SHORT).show();
        } else {
            Log.e(TAG, "Login Successful");
            Toast.makeText(this, "un is :" + mUserName + "\nPass is : " + mPassword, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(MainActivity.this, WidgetActivity.class));
        }
    }

    public static boolean isValid(String passwordhere, String confirmhere, List<String> errorList) {

        Pattern specailCharPatten = Pattern.compile("[^a-z0-9 ]", Pattern.CASE_INSENSITIVE);
        Pattern UpperCasePatten = Pattern.compile("[A-Z ]");
        Pattern lowerCasePatten = Pattern.compile("[a-z ]");
        Pattern digitCasePatten = Pattern.compile("[0-9 ]");
        errorList.clear();

        boolean flag=true;

        if (!passwordhere.equals(confirmhere)) {
            errorList.add("password and confirm password does not match");
            flag=false;
        }
        if (passwordhere.length() < 8) {
            errorList.add("Password lenght must have alleast 8 character !!");
            flag=false;
        }
        if (!specailCharPatten.matcher(passwordhere).find()) {
            errorList.add("Password must have atleast one specail character !!");
            flag=false;
        }
        if (!UpperCasePatten.matcher(passwordhere).find()) {
            errorList.add("Password must have atleast one uppercase character !!");
            flag=false;
        }
        if (!lowerCasePatten.matcher(passwordhere).find()) {
            errorList.add("Password must have atleast one lowercase character !!");
            flag=false;
        }
        if (!digitCasePatten.matcher(passwordhere).find()) {
            errorList.add("Password must have atleast one digit character !!");
            flag=false;
        }

        return flag;

    }
}
