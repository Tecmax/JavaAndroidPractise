package com.header_footer_demo.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.header_footer_demo.R;
import com.header_footer_demo.helper.DemoViewHolder;
import com.header_footer_demo.helper.GenerateRandom_Color;
import com.header_footer_demo.helper.RecyclerView_HeaderFooter_Holder;

import java.util.ArrayList;

/**
 * Created by SONU on 22/05/16.
 */
public class RecyclerView_Adapter extends
        RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ArrayList<String> arrayList;
    private Context context;

    //Type of data in recycler view
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_FOOTER = 1;
    private static final int TYPE_ITEM = 2;


    public RecyclerView_Adapter(Context context,
                                ArrayList<String> arrayList) {
        this.context = context;
        this.arrayList = arrayList;

    }


    @Override
    public int getItemCount() {
        return (null != arrayList ? arrayList.size() + 2 : 0);//Add 2 more size to array list for Header and Footer

    }

    @Override
    public int getItemViewType(int position) {
        //Return item type according to requirement
        if (isPositionHeader(position))
            return TYPE_HEADER;
        else if (isPositionFooter(position))
            return TYPE_FOOTER;
        return TYPE_ITEM;

    }

    //if position is 0 then type is header
    private boolean isPositionHeader(int position) {
        return position == 0;
    }

    //If position is last then type is footer
    private boolean isPositionFooter(int position) {
        return position == arrayList.size() + 1;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder,
                                 int position) {

        //If instance is DemoViewHolder the type is Item do your stuff over here
        if (holder instanceof DemoViewHolder) {
            ((DemoViewHolder) holder).title.setBackgroundColor(GenerateRandom_Color.generateRandomColor());
            ((DemoViewHolder) holder).title.setText(arrayList.get(position - 1));//For getting data from array use -1 for getting correct data
        } else if (holder instanceof RecyclerView_HeaderFooter_Holder) {
            //Else the type is header
            if (position == 0)
                ((RecyclerView_HeaderFooter_Holder) holder).title.setText(context.getResources().getString(R.string.header_view));//if position is 0 set title to header view
            if (position == getItemCount())
                ((RecyclerView_HeaderFooter_Holder) holder).title.setText(context.getResources().getString(R.string.footer_view));//if position is equal to total item set title to footer view
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(
            ViewGroup viewGroup, int viewType) {

        //inflate the item according to item type
        View itemView;


        //Since we are using same holder for both header and footer so we can return same holder
        if (viewType == TYPE_HEADER || viewType == TYPE_FOOTER) {
            itemView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.header_footer_view, viewGroup, false);
            return new RecyclerView_HeaderFooter_Holder(itemView);
        } else if (viewType == TYPE_ITEM) {
            //inflate your layout and pass it to view holder
            itemView = LayoutInflater.from(viewGroup.getContext())
                    .inflate(R.layout.list_item_row, viewGroup, false);
            return new DemoViewHolder(itemView);
        }

        throw new RuntimeException("there is no type that matches the type " + viewType + " + make sure your using types correctly");//Some error occurs then exception occurs

    }
}
