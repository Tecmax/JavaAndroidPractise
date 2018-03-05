package com.tecmax.basicappli.fragment;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.tecmax.basicappli.R;
import com.tecmax.basicappli.navagation.HomeActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment {

    private onfragmentChange mListener;
    String strtext;

    public BlankFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_blank, container, false);
        strtext = "dsadas";
        if (getArguments() != null)
            strtext = getArguments().getString("edttext");
        TextView abc = v.findViewById(R.id.hells);
        abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(), "Bye " + strtext, Toast.LENGTH_SHORT).show();
//                if (mListener != null) {
//                    mListener.sendFragment(new InterFragment(),
//                            InterFragment.class.getSimpleName());
//                }
                HomeActivity.replaceFragment(new InterFragment(),
                            InterFragment.class.getSimpleName());
            }
        });
        return v;
    }

    public interface onfragmentChange {
        void sendFragment(Fragment cfds, String tag);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof onfragmentChange) {
            mListener = (onfragmentChange) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement onfragmentChange");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
