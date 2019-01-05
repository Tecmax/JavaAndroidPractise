package com.header_footer_demo.tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.header_footer_demo.R;
import com.header_footer_demo.adapters.RecyclerView_Adapter;

import java.util.ArrayList;

/**
 * Created by SONU on 22/05/16.
 */
public class RecyclerView_Fragment extends Fragment {

    private static View view;
    private static RecyclerView recyclerView;
    private boolean isListType = true;

    public RecyclerView_Fragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);//call this method to implement option menu over fragment

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.recyclerview_layout, container, false);
        setRecyclerView();
        return view;
    }

    //Setting recycler view
    private void setRecyclerView() {

        recyclerView = (RecyclerView) view
                .findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView
                .setLayoutManager(new LinearLayoutManager(getActivity()));//Linear Items


        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            arrayList.add("ITEM " + i);//Adding items to recycler view
        }
        RecyclerView_Adapter adapter = new RecyclerView_Adapter(getActivity(), arrayList);
        recyclerView.setAdapter(adapter);// set adapter on recycler view

    }

    //Toggle recycler view between List and Grid Type
    private void toggleRecyclerView(boolean isList) {
        isListType = isList;//set the current type is list or not
        if (isList)
            recyclerView
                    .setLayoutManager(new LinearLayoutManager(getActivity()));//Linear Items
        else
            recyclerView
                    .setLayoutManager(new GridLayoutManager(getActivity(), 2));//Grid Items
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);//Inflate menu
        onPrepareOptionsMenu(menu);//call prepare menu so that title will change according to current type
    }

    @Override
    public void onPrepareOptionsMenu(Menu menu) {
        super.onPrepareOptionsMenu(menu);
        MenuItem item = menu.findItem(R.id.action_toggle);//find menu id
        //If current type is not list then set to list else by default is grid only
        if (!isListType)
            item.setTitle(getActivity().getResources().getString(R.string.list));
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_toggle:

                //toggle the recycler view type and change the menu text also
                if (isListType) {
                    item.setTitle(getActivity().getResources().getString(R.string.list));
                    toggleRecyclerView(false);
                } else {
                    item.setTitle(getActivity().getResources().getString(R.string.grid));
                    toggleRecyclerView(true);
                }
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
