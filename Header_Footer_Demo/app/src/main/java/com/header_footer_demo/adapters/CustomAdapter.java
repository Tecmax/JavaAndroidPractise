package com.header_footer_demo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.header_footer_demo.R;
import com.header_footer_demo.helper.GenerateRandom_Color;

import java.util.ArrayList;

/**
 * Created by SONU on 22/05/16.
 */
public class CustomAdapter extends BaseAdapter {


    private Context context;
    private ArrayList<String> arrayList;
    private LayoutInflater inflater;

    public CustomAdapter(Context context, ArrayList<String> arrayList) {

        this.context = context;
        this.arrayList = arrayList;

        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return arrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = inflater.inflate(R.layout.list_item_row, parent, false);
        TextView text = (TextView) convertView.findViewById(R.id.row_item_text);
        text.setBackgroundColor(GenerateRandom_Color.generateRandomColor());
        text.setText(arrayList.get(position));


        return convertView;
    }


}
