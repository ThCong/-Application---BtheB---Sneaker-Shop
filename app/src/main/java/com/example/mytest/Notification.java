package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.mytest.adapter.NotiAdapter;
import com.example.mytest.adapter.OrderAdapter;
import com.example.mytest.model.Noti;
import com.example.mytest.model.Order;

import java.util.ArrayList;

public class Notification extends AppCompatActivity {

    ListView lvNotification, lvOrder;
    NotiAdapter notiAdapter;
    ArrayList notiArrayList,orderArrayList;
    OrderAdapter orderAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notification);
        linkViews();
        initData();
        loadData();
    }

    private void linkViews() {
        lvNotification = findViewById(R.id.lvNotification);
        lvOrder = findViewById(R.id.lvOrder);
    }
    private void initData() {
        //Notification
        notiArrayList = new ArrayList<Noti>();
        notiArrayList.add( new Noti(R.drawable.mess1,"PEGASUS 38 FLYEASE “LIGHTING’"));
        notiArrayList.add( new Noti(R.drawable.mess2,"SHOP FOR RUNNING SHOES LIKE A PRO"));
        notiArrayList.add( new Noti(R.drawable.mess3,"NEW FAIRIES"));

        //Order
        orderArrayList = new ArrayList();
        orderArrayList.add(new Order(R.drawable.product_1,"Parcel Delivered","Parcel 12345 for your order has been deliverred"));
        orderArrayList.add(new Order(R.drawable.product_1,"Shipped Out","Your order has been shipped out by GHN. Click here to see order details"));
        orderArrayList.add(new Order(R.drawable.product_1,"Payment Confirm","We ‘re notified the seller. Kindly wait for your shipment"));

    }
    private void loadData() {
        //Notification
        notiAdapter = new NotiAdapter(this, R.layout.noti_item_layout,notiArrayList);
        lvNotification.setAdapter(notiAdapter);

        //Order
        orderAdapter = new OrderAdapter(this,R.layout.order_item_layout,orderArrayList);
        lvOrder.setAdapter(orderAdapter);
    }

}