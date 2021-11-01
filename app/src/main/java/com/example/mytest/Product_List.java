package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.adapter.Product_List_Adapter;
import com.example.model.Products_ListView;

import java.util.ArrayList;

public class Product_List extends AppCompatActivity {
ListView lvProduct;
Product_List_Adapter adapter;
ArrayList<Products_ListView> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        lvProduct = findViewById(R.id.lvProductss);

        arrayList = new ArrayList<>();
        arrayList.add(new Products_ListView("Nike",R.drawable.sneaker1,10000));
        arrayList.add(new Products_ListView("Nike",R.drawable.sneaker1,10000));
        arrayList.add(new Products_ListView("Nike",R.drawable.sneaker1,10000));
        arrayList.add(new Products_ListView("Nike",R.drawable.sneaker1,10000));

        adapter= new Product_List_Adapter(this,R.layout.custom_product_listview,arrayList);
        lvProduct.setAdapter(adapter);

    }
}