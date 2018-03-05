package com.tecmax.testaksh.recycleAdap;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.tecmax.testaksh.R;

import java.util.List;

/**
 * Created by DELL PC on 16-Feb-18.
 */

public class PractoAdap extends RecyclerView.Adapter<PractoAdap.PractoViewHolder> {
    Context mContext;
    List<PractoTablet> ss;

    public PractoAdap(List<PractoTablet> tablets) {
        ss = tablets;
    }

    @Override
    public PractoAdap.PractoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_amazon,
                parent, false);
        mContext = parent.getContext();
        return new PractoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(PractoAdap.PractoViewHolder holder, int position) {
        holder.cn.setText(ss.get(position).getTabCompany());
        holder.des.setText(ss.get(position).getTabDescription());
        holder.name.setText(ss.get(position).getTabName());
        String mrp, sp, discount;
        mrp = String.format(mContext.getResources().getString(R.string.mrp,
                ss.get(position).getTabMrp()+""));
        sp = String.format(mContext.getResources().getString(R.string.sp,
                ss.get(position).getTabSp()+""));
        discount = String.format(mContext.getResources().getString(R.string.discount,
                ss.get(position).getTabDiscount()+""));
        holder.mrp.setText(mrp);
        holder.sp.setText(sp);
        holder.discount.setText(discount);

    }

    @Override
    public int getItemCount() {
        return ss.size();
    }

    public class PractoViewHolder extends RecyclerView.ViewHolder {
        CardView practo;
        TextView cn, des, name, mrp, sp, discount;
        Button atc;

        public PractoViewHolder(View itemView) {
            super(itemView);
            practo = itemView.findViewById(R.id.practo);
            cn = itemView.findViewById(R.id.tabletCompany);
            des = itemView.findViewById(R.id.tabletDescription);
            name = itemView.findViewById(R.id.tabletName);
            mrp = itemView.findViewById(R.id.tabMrp);
            sp = itemView.findViewById(R.id.tabSp);
            discount = itemView.findViewById(R.id.tabDiscount);
            atc = itemView.findViewById(R.id.tabAddToCart);
            practo.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(mContext, "Hello " +ss.get(getAdapterPosition()).
                            getTabDiscount() , Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
