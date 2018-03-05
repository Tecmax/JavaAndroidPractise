package com.tecmax.basicappli;

import android.app.Application;

import com.tecmax.basicappli.utils.TypefaceUtil;

import io.realm.Realm;
import uk.co.chrisjenx.calligraphy.CalligraphyConfig;

/**
 * Created by DELL PC on 12-Feb-18.
 */

public class TecmaxApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        try {
            Realm.init(this);
            CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
                    .setDefaultFontPath("fonts/test.ttf")
                    .setFontAttrId(R.attr.fontPath)
                    .build()
            );
            TypefaceUtil.overrideFont(getApplicationContext(), "SERIF",
                    "fonts/test.ttf");

        } catch (Exception ex) {
            ex.printStackTrace();
        }


    }
}
