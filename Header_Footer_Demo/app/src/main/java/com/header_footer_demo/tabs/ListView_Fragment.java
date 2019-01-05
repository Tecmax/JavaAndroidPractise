package com.header_footer_demo.tabs;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.header_footer_demo.R;
import com.header_footer_demo.adapters.CustomAdapter;

import java.util.ArrayList;

/**
 * Created by SONU on 22/05/16.
 */
public class ListView_Fragment extends Fragment {

    private static View view;
    private static ListView listView;

    public ListView_Fragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.listview_layout, container, false);
        setUpListView();
        return view;
    }

    //Set Up list view
    private void setUpListView() {

        listView = (ListView) view
                .findViewById(R.id.list_view);

        addHeaderFooterView();//Add header and footer before adding data to list view

        ArrayList<String> arrayList = new ArrayList<>();
        for (int i = 1; i <= 20; i++) {
            arrayList.add("ITEM " + i);//Adding items to recycler view
        }

        CustomAdapter adapter = new CustomAdapter( getActivity(), arrayList);
        listView.setAdapter(adapter);// set adapter on listview
        adapter.notifyDataSetChanged();
    }

//Add header and footer view
    private void addHeaderFooterView() {
        LayoutInflater inflater = (LayoutInflater) getActivity().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Header View
        View headerView = inflater.inflate(R.layout.header_footer_view, null, false);
        TextView headerTitle = (TextView) headerView.findViewById(R.id.header_footer_title);
        headerTitle.setText(getActivity().getResources().getString(R.string.header_view));//set the text to Header View
        listView.addHeaderView(headerView);//Add view to list view as header view

        View footerView = inflater.inflate(R.layout.header_footer_view, null, false);
        TextView footerTitle = (TextView) footerView.findViewById(R.id.header_footer_title);
        footerTitle.setText(getActivity().getResources().getString(R.string.footer_view));//set the text to Footer View
        listView.addFooterView(footerView);//Add view to list view as footer view

    }
}
