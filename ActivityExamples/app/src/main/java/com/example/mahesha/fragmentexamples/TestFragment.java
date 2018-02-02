package com.example.mahesha.fragmentexamples;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.mahesha.activityexamples.R;

/**
 * Created by Mahesh on 09-05-2017.
 */

public class TestFragment extends Fragment {
    EditText username;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v=  inflater.inflate(R.layout.activity_aksh_bind,container,false);
        username= (EditText) v.findViewById(R.id.ak_username);
        username.setText("hello");
        return v;
    }
}
