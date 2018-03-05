package com.softgen.ecommerce.customisedgallery;

import android.os.Build;

/**
 * Created by Mahesh on 28-08-2017.
 */

public class Utils {
    public static boolean isMarshmallow() {
        return android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.M ? true : false;
    }
}
