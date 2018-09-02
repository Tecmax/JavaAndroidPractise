package com.tecmax.henna.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.tecmax.henna.R;
import com.tecmax.henna.retrofit.InstituteList;

import java.util.List;

public class InstituteListAdapter extends RecyclerView.Adapter<InstituteListAdapter.InstituteHolder> {
    private List<InstituteList> instituteLists;
    private Context context;

    public InstituteListAdapter(List<InstituteList> dfdg){
        instituteLists = dfdg;
    }

    @Override
    public InstituteHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        context = parent.getContext();
        View df = LayoutInflater.from(context).inflate(R.layout.adapter_institute, parent, false);
        return new InstituteHolder(df);
    }

    @Override
    public void onBindViewHolder(InstituteHolder holder, int position) {
        InstituteList list = instituteLists.get(position);
        String imageUrl = list.getLogo().replace("/home/amvldrxq/", "http://");
        Glide.with(context)
                .load(imageUrl)
                .into(holder.logo);
        holder.title.setText(list.getTitle());
    }

    @Override
    public int getItemCount() {
        return instituteLists.size();
    }

    class InstituteHolder extends RecyclerView.ViewHolder {
        ImageView logo;
        TextView title;

        public InstituteHolder(View itemView) {
            super(itemView);
            logo = itemView.findViewById(R.id.ivLogo);
            title = itemView.findViewById(R.id.etTitle);
        }
    }
}
