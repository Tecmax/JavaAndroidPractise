package com.tecmax.henna.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tecmax.henna.R;
import com.tecmax.henna.adapter.BMSAdapter;
import com.tecmax.henna.entities.Movie;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {
    RecyclerView bookMyShow;
    RecyclerView.LayoutManager layoutManager;
    GridLayoutManager gridLayoutManager;

    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_gallery, container, false);
        bookMyShow = v.findViewById(R.id.bms);
        String[] mNameList = {"MCA", "Mufti", "Thor", "Tiger Zindha Hai", "Premam", "Sathya"};
        String[] mLanguageList = {"Telugu", "Kannada", "English", "Hindi", "Mal", "Tamil"};
        String[] mCertificateList = {"UA", "A", "U", "UA", "U/A", "U"};
        String[] mStatusList = {"New", "Old", "Seen", "New", "Seen", "Old"};
        Integer[] mBannerList = {R.drawable.mca, R.drawable.mufti, R.drawable.thor, R.drawable.tiger,
                R.drawable.premam, R.drawable.satya};

        List<Movie> movieList = new ArrayList<>();
        for (int i = 0; i < mBannerList.length; i++) {
            Movie movie = new Movie();
            movie.setBanner(mBannerList[i]);
            movie.setCertificate(mCertificateList[i]);
            movie.setLanguage(mLanguageList[i]);
            movie.setName(mNameList[i]);
            movie.setOlder(mStatusList[i]);
            movieList.add(movie);
        }
        BMSAdapter bmsAdapter = new BMSAdapter(movieList,getActivity());
//        layoutManager = new LinearLayoutManager(getActivity(),LinearLayoutManager.HORIZONTAL,false);
        layoutManager = new LinearLayoutManager(getActivity());
//        gridLayoutManager = new GridLayoutManager(this,2);
        bookMyShow.setLayoutManager(layoutManager);
        bookMyShow.setAdapter(bmsAdapter);
        return v;
    }

}
