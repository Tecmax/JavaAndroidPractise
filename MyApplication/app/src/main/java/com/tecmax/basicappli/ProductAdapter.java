package com.tecmax.basicappli;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by DELL PC on 21-Dec-17.
 */

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.PView> {
    List<Product> productList;
    Activity activity;

    ProductAdapter(List<Product> products, Activity activity) {
        productList = products;
        this.activity = activity;
    }

    @Override
    public ProductAdapter.PView onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(activity).inflate(R.layout.aproducts,
                parent, false);

        return new PView(view);
    }

    @Override
    public void onBindViewHolder(ProductAdapter.PView holder, int position) {
        holder.pBanner.setImageResource(productList.get(position).getImage());
        holder.pName.setText(productList.get(position).getName());
        String mrp = String.format(activity.getResources().getString(R.string.mrp),
                String.valueOf(productList.get(position).getMrp()));
        String sp = String.format(activity.getResources().getString(R.string.sp),
                String.valueOf(productList.get(position).getSp()));
        holder.pMrp.setText(mrp);
        holder.pSp.setText(sp);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public class PView extends RecyclerView.ViewHolder {
        public ImageView pBanner;
        public TextView pName;
        public TextView pMrp;
        public TextView pSp;

        public PView(View itemView) {
            super(itemView);
            pBanner = itemView.findViewById(R.id.pImage);
            pName = itemView.findViewById(R.id.pName);
            pMrp = itemView.findViewById(R.id.pMrp);
            pSp = itemView.findViewById(R.id.pSp);
            pSp.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(activity, "Hello", Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
