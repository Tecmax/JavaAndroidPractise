package com.tecmax.testaksh.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.tecmax.testaksh.PrefManager;
import com.tecmax.testaksh.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends Fragment {

    CheckBox rem;
    EditText un, pa;
    PrefManager manager;

    public LoginFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_login, container, false);
        rem = v.findViewById(R.id.rem);
        un = v.findViewById(R.id.lg);
        pa = v.findViewById(R.id.pa);
        Button logi = v.findViewById(R.id.lvv);
        logi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validation(view);
            }
        });
        manager = new PrefManager(getActivity());

        if (manager.isRememberMe()) {
            un.setText(manager.getUserName());
            rem.setChecked(true);
        }
        return v;
    }

    public void validation(View v) {
        if (rem.isChecked()) {
            manager.setUserName(un.getText().toString());
        }
        manager.setRememberMe(rem.isChecked());
        Toast.makeText(getActivity(),
                "Login Clicked", Toast.LENGTH_SHORT).show();
    }
}
