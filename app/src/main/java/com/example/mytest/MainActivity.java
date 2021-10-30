package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;

import com.example.adapter.ProductAdapter;
import com.example.model.Product;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView rcvProduct;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //sdfasffasdf
        //csvdvzc
        //ấdfsdfsdfsadfsadf

        LinkViews();
        confiRecycleView();
        initData();
    }

    private void LinkViews() {
        rcvProduct = findViewById(R.id.rcvProduct);
    }

    private void confiRecycleView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcvProduct.setLayoutManager(manager);



        rcvProduct.setHasFixedSize(true);
        rcvProduct.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        ArrayList<Product> products = new ArrayList<>();
        products.add(new Product(R.drawable.shoes2));
        products.add(new Product(R.drawable.shoes2));
        products.add(new Product(R.drawable.shoes2));
        products.add(new Product(R.drawable.shoes2));
        products.add(new Product(R.drawable.shoes2));


        ProductAdapter adapter = new ProductAdapter(getApplicationContext(), products);
        rcvProduct.setAdapter(adapter);


    }
}