package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.adapter.OrderDetailAdapter;
import com.example.model.Order_Detail;

import java.util.ArrayList;

public class Checkout extends AppCompatActivity {
    ListView lvItemCheckouts;
    ArrayList<Order_Detail> order_detailList;
    OrderDetailAdapter orderadapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        linkViews();
        initData();
        loadData();
    }



    private void linkViews() {
        lvItemCheckouts = findViewById(R.id.lvItemCheckouts);
    }

    private void initData() {
        order_detailList = new ArrayList<>();
        order_detailList.add(new Order_Detail(R.drawable.sneaker2,"Ultraboost 29 Shoes","Fashion shoes",170.0,1));
        order_detailList.add(new Order_Detail(R.drawable.sneaker1,"Ultraboost 29 Shoes","Fashion shoes",140.0,2));
    }

    private void loadData() {
        orderadapter = new OrderDetailAdapter(Checkout.this, R.layout.custom_item_checkout,order_detailList);
        lvItemCheckouts.setAdapter(orderadapter);
    }

}