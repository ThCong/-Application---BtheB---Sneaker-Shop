package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.ItemAdapter_ListView;
import com.example.model.Order_Detail;

import java.util.ArrayList;

public class Track_My_Order extends AppCompatActivity {

    ListView lvOrder;
    ArrayList<Order_Detail> items;
    ItemAdapter_ListView adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trackmyorder);

        lvOrder = findViewById(R.id.lvTrackOrders);


        items = new ArrayList<Order_Detail>();
        items.add(new Order_Detail(R.drawable.sneaker1,"Ultraboost 29 Shoes","Fashion shoes",170.0,1,"To recieve"));
        items.add(new Order_Detail(R.drawable.sneaker2,"McKenzie Treso 2","Fashion shoes",190.0,2,"Processing"));
        items.add(new Order_Detail(R.drawable.sneaker3,"Nike Air Max 2021","Fashion shoes",150.0,1,"Completed"));

        adapter = new ItemAdapter_ListView(this, R.layout.item_trackmyorder_layout, items);

        lvOrder.setAdapter(adapter);

    }
}