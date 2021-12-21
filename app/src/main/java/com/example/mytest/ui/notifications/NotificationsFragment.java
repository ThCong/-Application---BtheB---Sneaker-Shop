package com.example.mytest.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.mytest.R;
import com.example.adapter.NotiAdapter;
import com.example.adapter.OrderAdapter;
import com.example.model.Noti;
import com.example.model.Order;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {
    ListView lvNotification, lvOrder;
    NotiAdapter notiAdapter;
    ArrayList notiArrayList,orderArrayList;
    OrderAdapter orderAdapter;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        lvNotification = view.findViewById(R.id.lvNotification);
        lvOrder = view.findViewById(R.id.lvOrder);
        initData();
        loadData();
        return view ;
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
        notiAdapter = new NotiAdapter(getContext(), R.layout.item_noti_layout,notiArrayList);
        lvNotification.setAdapter(notiAdapter);

        //Order
        orderAdapter = new OrderAdapter(getContext(),R.layout.item_order_layout,orderArrayList);
        lvOrder.setAdapter(orderAdapter);
    }
}
