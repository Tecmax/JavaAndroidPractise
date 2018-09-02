package com.tecmax.henna.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.tecmax.henna.R;
import com.tecmax.henna.TavcsadActivity;
import com.tecmax.henna.entities.Movie;

import java.util.List;

/**
 * Created by DELL PC on 18-Dec-17.
 */

public class BMSAdapter extends RecyclerView.Adapter<BMSAdapter.BMSViewHolder> {
    List<Movie> movieList;
    Activity mActivity;

    public BMSAdapter(List<Movie> movieList, Activity activity) {
        this.movieList = movieList;
        mActivity= activity;
    }

    @Override
    public BMSAdapter.BMSViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.bmsadapter, parent, false);
        return new BMSViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BMSAdapter.BMSViewHolder holder, int position) {
        holder.mName.setText(movieList.get(position).getName());
        holder.mLanguage.setText(movieList.get(position).getLanguage());
        holder.mCertificate.setText(movieList.get(position).getCertificate());
        holder.mOld.setText(movieList.get(position).getOlder());
        holder.mBanner.setImageResource(movieList.get(position).getBanner());
        holder.mName.setTag(movieList.get(position).getName());
        holder.mBook.setTag(position);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    class BMSViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatImageView mBanner;
        AppCompatTextView mName, mLanguage, mCertificate, mOld;
        AppCompatButton mBook;

        public BMSViewHolder(View itemView) {
            super(itemView);
            mBanner = itemView.findViewById(R.id.mBanner);
            mName = itemView.findViewById(R.id.mName);
            mLanguage = itemView.findViewById(R.id.mLanguage);
            mCertificate = itemView.findViewById(R.id.mCertificate);
            mOld = itemView.findViewById(R.id.mOld);
            mBook = itemView.findViewById(R.id.mBook);
            mBook.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.mBook:
//                    Toast.makeText(view.getContext(), "Selected iS "+ mName.getTag().toString(), Toast.LENGTH_SHORT).show();
//                    Intent intent = new Intent(view.getContext(), MovieDescriptionActivity.class);
//                    intent.putExtra("Title",mName.getTag().toString());
//                    mActivity.startActivity(intent);
                    String data = view.getTag().toString();
                    int pos = Integer.parseInt(data);
                    Movie movie = movieList.get(pos);
                        Intent intent = new Intent(view.getContext(), TavcsadActivity.class);
                        intent.putExtra("Title",movie);
                        view.getContext().startActivity(intent);
//                    } else if (mName.getTag().toString().equals("Mufti")) {
//                        Intent intent = new Intent(view.getContext(), TavcsadActivity.class);
//                        intent.putExtra("Title",movie);
//                        view.getContext().startActivity(intent);
//                    }
                    break;
            }
        }
    }

}
