package com.broadcast.softgen.broadcast;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Mahesh on 14-06-2017.
 */

public class RecycleAdapter extends RecyclerView.Adapter<RecycleAdapter.ViewHolder> {
    ArrayList<IncomingNumber> incomingNumbers = new ArrayList<>();

    public RecycleAdapter(ArrayList<IncomingNumber> incomingNumbers) {
        this.incomingNumbers = incomingNumbers;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView id, number;

        public ViewHolder(View itemView) {
            super(itemView);
            id = (TextView) itemView.findViewById(R.id.row_id);
            number = (TextView) itemView.findViewById(R.id.phoneNo);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_view, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.id.setText("" + incomingNumbers.get(position).getId());
        holder.number.setText("" + incomingNumbers.get(position).getNumber());
    }

    @Override
    public int getItemCount() {
        return incomingNumbers.size();
    }
}
