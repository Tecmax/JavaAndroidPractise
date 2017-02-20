package com.example.mahesha.widgets;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mahesha.activityexamples.R;
import com.mikhaellopez.circularimageview.CircularImageView;


public class ImageViewActivity extends AppCompatActivity {
    Button button;
    ImageView image;
    CircularImageView circularImageView;
    boolean isClicked;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        addListenerOnButton();
        circularImageView = (CircularImageView) findViewById(R.id.circle_image);
        circularImageView.setBorderColor(getResources().getColor(R.color.blue_grey_700));
        circularImageView.setBorderWidth(10);
        circularImageView.addShadow();
        circularImageView.setShadowRadius(15);
        circularImageView.setShadowColor(Color.RED);
    }

    public void addListenerOnButton() {

        image = (ImageView) findViewById(R.id.imageView1);

        button = (Button) findViewById(R.id.btnChangeImage);

        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                if (isClicked) {
                    isClicked = false;
                    image.setImageResource(R.drawable.nougat);
                } else {
                    isClicked = true;
                    image.setImageResource(R.drawable.thumb1);
                }
//                circularImageView.setImageResource(R.drawable.ic_launcher);
            }

        });
    }
}
