package com.tecmax.basicappli;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by DELL PC on 24-Mar-18.
 */

public class PdAdap extends RecyclerView.Adapter<PdAdap.dsfsdfed> {


    @Override
    public PdAdap.dsfsdfed onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.aproducts,parent,
                false);
        return new dsfsdfed(v);
    }

    @Override
    public void onBindViewHolder(PdAdap.dsfsdfed holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    class dsfsdfed extends RecyclerView.ViewHolder {

        public dsfsdfed(View itemView) {
            super(itemView);
        }
    }
}
