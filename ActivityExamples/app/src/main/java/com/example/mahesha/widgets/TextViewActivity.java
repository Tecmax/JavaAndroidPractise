package com.example.mahesha.widgets;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;

import com.example.mahesha.activityexamples.R;
import com.example.mahesha.utility.InstantAutoCompleteTextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.example.mahesha.utility.Utils.loadJSONFromAsset;

public class TextViewActivity extends AppCompatActivity {
    TextInputLayout tilReferredBy;
    InstantAutoCompleteTextView atvReferredBy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        tilReferredBy = (TextInputLayout) findViewById(R.id.til_referred_by);
        atvReferredBy = (InstantAutoCompleteTextView) findViewById(R.id.atv_referred_by);
        atvReferredBy.setThreshold(2);
        atvReferredBy.addTextChangedListener(twSearchRefer);
        ArrayList<String> list = new ArrayList<String>();
        try {
            JSONObject obj = new JSONObject(loadJSONFromAsset(getApplicationContext()));
            JSONArray jsonArray = obj.getJSONArray("services");
            if (jsonArray != null) {
                int len = jsonArray.length();
                for (int i=0;i<len;i++){
                    list.add(jsonArray.get(i).toString());
                }
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        ArrayAdapter<String> adapterDoctor = new ArrayAdapter<>(
                this, android.R.layout.simple_dropdown_item_1line, list);
        atvReferredBy.setAdapter(adapterDoctor);
    }


    TextWatcher twSearchRefer = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override
        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

        }

        @Override
        public void afterTextChanged(Editable editable) {

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    String str = atvReferredBy.getText().toString().trim();
                    if (str.length() > 1) {
                        if (atvReferredBy.isPopupShowing()) {
                            tilReferredBy.setError(null);
                        } else {
                            tilReferredBy.setError("No such name with " + str);
                        }
                    } else {
                        tilReferredBy.setError(null);
                    }
                }
            }, 100);

        }
    };
}
