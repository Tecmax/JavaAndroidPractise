package com.header_footer_demo.helper;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.header_footer_demo.R;

/**
 * Created by SONU on 22/05/16.
 */
public class DemoViewHolder extends RecyclerView.ViewHolder {
    public TextView title;

    public DemoViewHolder(View view) {
        super(view);
        this.title = (TextView) view.findViewById(R.id.row_item_text);
    }
}