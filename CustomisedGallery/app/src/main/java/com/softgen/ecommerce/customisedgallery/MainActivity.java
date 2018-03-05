package com.softgen.ecommerce.customisedgallery;

import android.Manifest;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private LinearLayout lnrImages;
    private Button btnAddPhots;
    private Button btnSaveImages;
    private ArrayList<String> imagesPathList;
    private Bitmap yourbitmap;
    private Bitmap resized;
    private final int PICK_IMAGE_MULTIPLE = 1;
    private static final int REQUEST_CODE_READ_PHONE_STATE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lnrImages = (LinearLayout) findViewById(R.id.lnrImages);
        btnAddPhots = (Button) findViewById(R.id.btnAddPhots);
        btnSaveImages = (Button) findViewById(R.id.btnSaveImages);
        btnAddPhots.setOnClickListener(this);
        btnSaveImages.setOnClickListener(this);
        if (Utils.isMarshmallow())
            getPermissions(this, REQUEST_CODE_READ_PHONE_STATE);
        else printIp();
    }

    private void printIp() {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnAddPhots:
                Intent intent = new Intent(MainActivity.this, CustomPhotoGalleryActivity.class);
                startActivityForResult(intent, PICK_IMAGE_MULTIPLE);
                break;
            case R.id.btnSaveImages:
                if (imagesPathList != null) {
                    if (imagesPathList.size() > 1) {
                        Toast.makeText(MainActivity.this, imagesPathList.size() + " no of images are selected", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, imagesPathList.size() + " no of image are selected", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, " no images are selected", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == PICK_IMAGE_MULTIPLE) {
                imagesPathList = new ArrayList<String>();
                String[] imagesPath = data.getStringExtra("data").split("\\|");
                try {
                    lnrImages.removeAllViews();
                } catch (Throwable e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < imagesPath.length; i++) {
                    imagesPathList.add(imagesPath[i]);
                    yourbitmap = BitmapFactory.decodeFile(imagesPath[i]);
                    ImageView imageView = new ImageView(this);
                    imageView.setImageBitmap(yourbitmap);
                    imageView.setAdjustViewBounds(true);
                    lnrImages.addView(imageView);
                }
            }
        }

    }


    private void getPermissions(Activity mActivity, int requestCode) {
        String permission = Manifest.permission.READ_EXTERNAL_STORAGE;
        if (!isPermissionEnabled(permission)) {
            ActivityCompat.requestPermissions(mActivity,
                    new String[]{permission},
                    requestCode);
        } else
            printIp();
    }

    private boolean isPermissionEnabled(String permission) {
        return ContextCompat.checkSelfPermission(this,
                permission)
                == PackageManager.PERMISSION_GRANTED;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case REQUEST_CODE_READ_PHONE_STATE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    printIp();
                } else {
                    Toast.makeText(this, "Read Phone state permission not enabled", Toast.LENGTH_SHORT).show();
                    finish();
                    //Utils.alertBox(mActivity, "You will get OTP in your inbox soon. Read and give here manually!");
                }
                break;
            }
        }
    }

}
