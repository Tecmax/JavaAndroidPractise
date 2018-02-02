package com.example.mahesha.recyclerview;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mahesha.activityexamples.R;

import java.util.ArrayList;

/**
 * Created by Mahesh on 19-06-2017.
 */

public class BmsAdapter extends RecyclerView.Adapter<BmsAdapter.BmsViewHolder> {
    ArrayList<BmsEntities> bmsEntities;
    static Context mContext;

    public BmsAdapter(ArrayList<BmsEntities> abcd) {
        this.bmsEntities = abcd;
    }

    @Override
    public BmsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        mContext = parent.getContext();
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_bms, parent, false);
        return new BmsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BmsViewHolder holder, int position) {
        holder.cover.setImageResource(bmsEntities.get(position).getImage());
        holder.title.setText(bmsEntities.get(position).getTitle());
        holder.language.setText(bmsEntities.get(position).getLanguage());
    }

    @Override
    public int getItemCount() {
        return bmsEntities.size();
    }

    public static class BmsViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        ImageView cover;
        Button book;
        TextView title, language;
        CardView cv;

        public BmsViewHolder(View itemView) {
            super(itemView);
            cover = (ImageView) itemView.findViewById(R.id.cover);
            book = (Button) itemView.findViewById(R.id.book);
            title = (TextView) itemView.findViewById(R.id.bms_title);
            language = (TextView) itemView.findViewById(R.id.bms_language);
            cv = (CardView) itemView.findViewById(R.id.card_view);
            title.setOnClickListener(this);
            language.setOnClickListener(this);
            book.setOnClickListener(this);
            cover.setOnClickListener(this);
            cv.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.bms_language:
                    Toast.makeText(mContext, "Language Clicked " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.book:
                    Toast.makeText(mContext, "button Clicked " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.bms_title:
                    Toast.makeText(mContext, "Title Clicked " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.cover:
                    Toast.makeText(mContext, "Cover Clicked " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.card_view:
                    Toast.makeText(mContext, "Cardview Clicked " + getAdapterPosition(), Toast.LENGTH_SHORT).show();
                    break;


            }
        }
    }
}
