package com.example.mahesha.activityexamples;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import com.example.mahesha.widgets.ButtonActivity;
import com.example.mahesha.widgets.CheckBoxActivity;
import com.example.mahesha.widgets.CustomCanvasActivity;
import com.example.mahesha.widgets.ImageButtonActivity;
import com.example.mahesha.widgets.ImageViewActivity;
import com.example.mahesha.widgets.MenuActivity;
import com.example.mahesha.widgets.ProgressBarActivity;
import com.example.mahesha.widgets.RadioActivity;
import com.example.mahesha.widgets.RatingBarActivity;
import com.example.mahesha.widgets.SeekbarActivity;
import com.example.mahesha.widgets.SnackBarActivity;
import com.example.mahesha.widgets.SpinnerActivity;
import com.example.mahesha.widgets.SwitchActivity;
import com.example.mahesha.widgets.TextViewActivity;
import com.example.mahesha.widgets.ToggleActivity;

import java.util.ArrayList;

public class WidgetsActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout relativeLayout;
private Context mActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_widgets);
        mActivity = WidgetsActivity.this;
        relativeLayout = (RelativeLayout) findViewById(R.id.activity_widgets);
        Button mButton = (Button) findViewById(R.id.button);
        Button mtextViews = (Button) findViewById(R.id.bt_textview);
        Button mCheckBox = (Button) findViewById(R.id.bt_checkbox);
        Button mRadio = (Button) findViewById(R.id.bt_radio);
        Button mSwitch = (Button) findViewById(R.id.switchex);
        Button mToggle = (Button) findViewById(R.id.bt_toggle);
        Button mImageButton = (Button) findViewById(R.id.image_button);
        Button mImageView = (Button) findViewById(R.id.image_view);
        Button mProgressBar = (Button) findViewById(R.id.progress_bar);
        Button mSeek = (Button) findViewById(R.id.seek);
        Button mRating = (Button) findViewById(R.id.rating);
        Button mSpinner = (Button) findViewById(R.id.spinner);
        mButton.setOnClickListener(this);
        mtextViews.setOnClickListener(this);
        mCheckBox.setOnClickListener(this);
        mRadio.setOnClickListener(this);
        mSwitch.setOnClickListener(this);
        mToggle.setOnClickListener(this);
        mImageButton.setOnClickListener(this);
        mImageView.setOnClickListener(this);
        mProgressBar.setOnClickListener(this);
        mSeek.setOnClickListener(this);
        mRating.setOnClickListener(this);
        mSpinner.setOnClickListener(this);
        findViewById(R.id.snack_Bar).setOnClickListener(this);
        findViewById(R.id.menus_example).setOnClickListener(this);
        findViewById(R.id.canvas_example).setOnClickListener(this);

//        AssetManager am = this.getApplicationContext().getAssets();
//
//        Typeface typeface = Typeface.createFromAsset(am,String.format(Locale.US, "fonts/%s", "abc.ttf"));
//        setTypeface(typeface);

        Typeface fComic = Typeface.createFromAsset(getAssets(), "fonts/comic.ttf");
        mSpinner.setTypeface(fComic);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "fonts/verdana.ttf");
        mImageView.setTypeface(custom_font);
        ArrayList<String> phoneNos=new ArrayList<String>();
        if (!phoneNos.isEmpty())
        for (int i = 0; i <= phoneNos.size(); i++) {
            sendMessage(phoneNos.get(i).toString(),"Help Needed");
        }
    }

    private void sendMessage(String s, String s1) {
        Intent intent= new Intent( Intent.ACTION_SENDTO, Uri.parse("sms://"));
        intent.putExtra("address", s);
        intent.putExtra("sms_body", s1);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button:
                startActivity(new Intent(mActivity, ButtonActivity.class));
                Snackbar.make(relativeLayout, "Buttons", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.bt_textview:
                startActivity(new Intent(mActivity, TextViewActivity.class));
                Snackbar.make(relativeLayout, "Text View", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.bt_checkbox:
                startActivity(new Intent(mActivity, CheckBoxActivity.class));
                Snackbar.make(relativeLayout, "CheckBox", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.bt_radio:
                startActivity(new Intent(mActivity, RadioActivity.class));
                Snackbar.make(relativeLayout, "Radio", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.switchex:
                startActivity(new Intent(mActivity, SwitchActivity.class));
                Snackbar.make(relativeLayout, "Switch", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.bt_toggle:
                startActivity(new Intent(mActivity, ToggleActivity.class));
                Snackbar.make(relativeLayout, "Toggle", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.image_button:
                startActivity(new Intent(mActivity, ImageButtonActivity.class));
                Snackbar.make(relativeLayout, "Image Button", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.image_view:
                startActivity(new Intent(mActivity, ImageViewActivity.class));
                Snackbar.make(relativeLayout, "Image View", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.progress_bar:
                startActivity(new Intent(mActivity, ProgressBarActivity.class));
                Snackbar.make(relativeLayout, "Progress Bar", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.seek:
                startActivity(new Intent(mActivity, SeekbarActivity.class));
                Snackbar.make(relativeLayout, "Seek Bar", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.rating:
                startActivity(new Intent(mActivity, RatingBarActivity.class));
                Snackbar.make(relativeLayout, "Ratings Bar", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.spinner:
                startActivity(new Intent(mActivity, SpinnerActivity.class));
                Snackbar.make(relativeLayout, "Spinner", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.snack_Bar:
                startActivity(new Intent(mActivity, SnackBarActivity.class));
                Snackbar.make(relativeLayout, "SnackBar", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.menus_example:
                startActivity(new Intent(mActivity, MenuActivity.class));
                Snackbar.make(relativeLayout, "Menus", Snackbar.LENGTH_SHORT).show();
                break;
            case R.id.canvas_example:
                startActivity(new Intent(mActivity, CustomCanvasActivity.class));
                Snackbar.make(relativeLayout, "Menus", Snackbar.LENGTH_SHORT).show();
                break;
        }
    }
}
