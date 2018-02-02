package com.example.mahesha.activityexamples;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;

import com.example.mahesha.databasehandellers.DBHelper;
import com.example.mahesha.utility.Utils;

import java.io.IOException;
import java.io.InputStream;

public class SelectImageActivity extends AppCompatActivity implements View.OnClickListener {


    private static final int SELECT_PICTURE = 100;
    private static final String TAG = "MainActivity";

    CoordinatorLayout coordinatorLayout;
    FloatingActionButton btnSelectImage;
    AppCompatImageView imgView;
    TextInputEditText position;
    DBHelper dbHelper;
    Uri selectedImageUri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_image);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Find the views...
        coordinatorLayout = (CoordinatorLayout) findViewById(R.id.coordinatorLayout);
        btnSelectImage = (FloatingActionButton) findViewById(R.id.btnSelectImage);
        imgView = (AppCompatImageView) findViewById(R.id.imgView);
        position = (TextInputEditText) findViewById(R.id.position);
        btnSelectImage.setOnClickListener(this);
        position.setText("1");
        // Create the Database helper object
        dbHelper = new DBHelper(this);
        loadImageFromDB();


    }

    // Show simple message using SnackBar
    void showMessage(String message) {
        Snackbar snackbar = Snackbar.make(coordinatorLayout, message, Snackbar.LENGTH_LONG);
        snackbar.show();
    }

    // Choose an image from Gallery
    void openImageChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Select Picture"), SELECT_PICTURE);
    }

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == SELECT_PICTURE) {

                selectedImageUri = data.getData();

                if (null != selectedImageUri) {

                    // Saving to Database...
                    if (saveImageInDB(selectedImageUri)) {
                        showMessage("Image Saved in Database...");
                        imgView.setImageURI(selectedImageUri);
                    }

                    // Reading from Database after 3 seconds just to show the message
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (loadImageFromDB()) {
                                showMessage("Image Loaded from Database...");
                            }
                        }
                    }, 3000);
                }

            }
        }
    }

    @Override
    public void onClick(View v) {
        openImageChooser();
    }

    // Save the
    Boolean saveImageInDB(Uri selectedImageUri) {

        try {
            dbHelper.open();
            InputStream iStream = getContentResolver().openInputStream(selectedImageUri);
            byte[] inputData = Utils.getBytes(iStream);
            dbHelper.insertImage(inputData);
            dbHelper.close();
            return true;
        } catch (IOException ioe) {
            Log.e(TAG, "<saveImageInDB> Error : " + ioe.getLocalizedMessage());
            dbHelper.close();
            return false;
        }

    }

    Boolean updateImageInDB(int position, Uri selectedImageUri) {

        try {
            dbHelper.open();
            InputStream iStream = getContentResolver().openInputStream(selectedImageUri);
            byte[] inputData = Utils.getBytes(iStream);
            dbHelper.updateImageFromDB(position, inputData);
            dbHelper.close();
            return true;
        } catch (IOException ioe) {
            Log.e(TAG, "<updateImageInDB> Error : " + ioe.getLocalizedMessage());
            dbHelper.close();
            return false;
        }

    }

    Boolean loadImageFromDB() {
        try {
            dbHelper.open();
            if (position.getText().toString() != null && !position.getText().toString().isEmpty()) {
                byte[] bytes = dbHelper.retreiveImageFromDB(Integer.parseInt(position.getText().toString()));
                dbHelper.close();
                // Show Image from DB in ImageView
                imgView.setImageBitmap(Utils.getImage(bytes));
                return true;
            } else {
                return false;
            }

        } catch (Exception e) {
            Log.e(TAG, "<loadImageFromDB> Error : " + e.getLocalizedMessage());
            showMessage("No Images on this location");
            dbHelper.close();
            return false;
        }
    }

    public void loadImage(View view) {
        switch (view.getId()) {
            case R.id.retrieveImage:
                loadImageFromDB();
                break;
            case R.id.updateImage:
                if (null != selectedImageUri) {

                    // Saving to Database...
                    if (updateImageInDB(Integer.parseInt(position.getText().toString()), selectedImageUri)) {
                        showMessage("Image Updated in Database...");
                        imgView.setImageURI(selectedImageUri);
                    }

                    // Reading from Database after 3 seconds just to show the message
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (loadImageFromDB()) {
                                showMessage("Image Loaded from Database...");
                            }
                        }
                    }, 3000);
                }
                break;
        }

    }
}
