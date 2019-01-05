package com.header_footer_demo.helper;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.header_footer_demo.R;


/**
 * Created by SONU on 01/04/16.
 */
public class RecyclerView_HeaderFooter_Holder extends RecyclerView.ViewHolder {
    public TextView title;

    public RecyclerView_HeaderFooter_Holder(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.header_footer_title);
    }
}