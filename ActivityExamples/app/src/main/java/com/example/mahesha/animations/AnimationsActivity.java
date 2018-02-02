package com.example.mahesha.animations;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.mahesha.activityexamples.R;

public class AnimationsActivity extends AppCompatActivity {
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animations);
        image = (ImageView) findViewById(R.id.imageView);
        Button clockwise = (Button) findViewById(R.id.button2);
        clockwise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ImageView image = (ImageView) findViewById(R.id.imageView);
                Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
                image.startAnimation(animation);
            }
        });
    }
////    public void clockwise(View view){
//        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
//        image.startAnimation(animation);
////    }

    public void zoom(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
        image.startAnimation(animation1);
    }

    public void fade(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        image.startAnimation(animation1);
    }

    public void blink(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        image.startAnimation(animation1);
    }

    public void move(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        image.startAnimation(animation1);
    }

    public void slide(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        image.startAnimation(animation1);
    }

    public void testClick(View view) {
        Toast.makeText(this, "Hello", Toast.LENGTH_SHORT).show();
    }
}
