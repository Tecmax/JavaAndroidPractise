package com.walmart.latest.fragm;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.walmart.latest.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AmFragment extends Fragment {


    public AmFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_am, container, false);
        Button login = v.findViewById(R.id.login);
        final EditText mUserName = v.findViewById(R.id.un);
        EditText mPassword = v.findViewById(R.id.pas);
        EditText mEmail = v.findViewById(R.id.email);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), mUserName.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

}