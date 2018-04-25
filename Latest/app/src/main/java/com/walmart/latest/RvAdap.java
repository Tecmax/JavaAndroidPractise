package com.walmart.latest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class RvAdap extends RecyclerView.Adapter<RvAdap.RVHold> {

    ArrayList<Student> studentsList;

    public RvAdap(ArrayList<Student> students) {
        studentsList = students;
    }

    @Override
    public RvAdap.RVHold onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_rv,
                parent, false);
        return new RVHold(view);
    }

    @Override
    public void onBindViewHolder(RvAdap.RVHold holder, int position) {
        holder.stName.setText(studentsList.get(position).getStName());
        holder.stClass.setText(studentsList.get(position).getStClass());
        holder.stSec.setText(studentsList.get(position).getStSec());
    }


    @Override
    public int getItemCount() {
        return studentsList.size();
    }


    public class RVHold extends RecyclerView.ViewHolder {
        TextView stName, stClass, stSec;

        public RVHold(View itemView) {
            super(itemView);
            stName = itemView.findViewById(R.id.name);
            stClass = itemView.findViewById(R.id.tvClass);
            stSec = itemView.findViewById(R.id.tvSection);
            stName.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });
        }
    }
}
