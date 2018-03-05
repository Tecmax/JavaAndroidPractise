package com.tecmax.basicappli;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;

import java.util.ArrayList;
import java.util.List;

public class AmazonProductsActivity extends AppCompatActivity {
    RecyclerView products;
    GridLayoutManager gridLayoutManager;
    StaggeredGridLayoutManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_amazon_products);
        products = findViewById(R.id.amazon);
        String[] name = {"Adidas", "Puma", "HRX", "Wrangler", "Reebok", "LEE", "Levis"};
        double[] MRP = {1000, 1099, 1199, 1059, 1082, 1999, 999};
        double[] Sp = {800, 999, 1000, 859, 999, 599, 499};
        Integer[] images = {R.drawable.adidas, R.drawable.adidas, R.drawable.adidas, R.drawable.adidas,
                R.drawable.adidas, R.drawable.adidas, R.drawable.adidas};
        List<Product> productList = new ArrayList<>();
        for (int i = 0; i < name.length; i++) {
            Product product = new Product();
            product.setImage(images[i]);
            product.setMrp(MRP[i]);
            product.setSp(Sp[i]);
            product.setName(name[i]);
            productList.add(product);
        }
        ProductAdapter productAdapter = new ProductAdapter(productList, this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL, false);
        gridLayoutManager = new GridLayoutManager(this,2);
        manager = new StaggeredGridLayoutManager(4,StaggeredGridLayoutManager.HORIZONTAL);
        products.setLayoutManager(manager);
        products.setAdapter(productAdapter);
    }
}
