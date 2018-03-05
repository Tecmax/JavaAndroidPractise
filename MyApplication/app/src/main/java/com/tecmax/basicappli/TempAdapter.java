package com.tecmax.basicappli;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by DELL PC on 03-Jan-18.
 */

public class TempAdapter extends RecyclerView.Adapter<TempAdapter.TempHolder> {
    String[] mNames;
    List<TempEntity> tempEntities;
    TempAdapter(String[] names) {
        mNames = names;
    }
    TempAdapter(List<TempEntity> names) {
        tempEntities = names;
    }

    @Override
    public TempAdapter.TempHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_temp, parent, false);
        return new TempHolder(v);
    }

    @Override
    public void onBindViewHolder(TempAdapter.TempHolder holder, int position) {
        holder.name.setText(tempEntities.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return tempEntities.size();
    }

    public class TempHolder extends RecyclerView.ViewHolder {
        ImageView pic;
        TextView name;

        public TempHolder(View itemView) {
            super(itemView);
            pic = itemView.findViewById(R.id.tempPic);
            name = itemView.findViewById(R.id.tempContact);
            pic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}
