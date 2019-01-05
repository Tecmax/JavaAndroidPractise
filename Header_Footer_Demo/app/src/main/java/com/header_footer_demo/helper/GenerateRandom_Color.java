package com.header_footer_demo.helper;

import android.graphics.Color;

import java.util.Random;

/**
 * Created by SONU on 22/05/16.
 */
public class GenerateRandom_Color {

    //this method will generate random colors
    public static int generateRandomColor() {
        Random rnd = new Random();
        return Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
    }
}
