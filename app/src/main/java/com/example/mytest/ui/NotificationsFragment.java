package com.example.mytest.ui;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.Interface.MyItemClick;
import com.example.Interface.MyMessClick;
import com.example.adapter.MessageAdapter;
import com.example.model.Messages;
import com.example.mytest.R;
import com.example.adapter.OrderAdapter;
import com.example.model.Order;
import com.example.mytest.fragments.Mess1Fragment;
import com.example.mytest.fragments.Mess2Fragment;
import com.example.mytest.fragments.Mess3Fragment;

import java.util.ArrayList;

public class NotificationsFragment extends Fragment {
        ListView lvNotification, lvOrder;
        ArrayList<Messages> notiArrayList;
        ArrayList<Order> orderArrayList;
        MessageAdapter notiAdapter;
        OrderAdapter orderAdapter;
        MyMessClick messClick;

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
        notiArrayList = new ArrayList<>();
        notiArrayList.add( new Messages(R.drawable.mess1,"PEGASUS 38 FLYEASE LIGHTING"));
        notiArrayList.add( new Messages(R.drawable.mess2,"SHOP FOR RUNNING SHOES LIKE A PRO"));
        notiArrayList.add( new Messages(R.drawable.mess3,"NEW FAIRIES"));

        //Order
        orderArrayList = new ArrayList<>();
        orderArrayList.add(new Order(R.drawable.product_1,"Parcel Delivered","Parcel 12345 for your order has been deliverred"));
        orderArrayList.add(new Order(R.drawable.product_1,"Shipped Out","Your order has been shipped out by GHN. Click here to see order details"));
        orderArrayList.add(new Order(R.drawable.product_1,"Payment Confirm","We ‘re notified the seller. Kindly wait for your shipment"));
        }
    private void loadData() {
        //Notification
        notiAdapter = new MessageAdapter(getContext(), R.layout.item_noti_layout,notiArrayList);
        lvNotification.setAdapter(notiAdapter);

        lvNotification.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Messages m = notiArrayList.get(position);
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
                {
                    messClick = (MyMessClick) getActivity();
                    if(messClick!=null)
                    {
                        messClick.messclick(m);
                    }
                }
                }
        });

        //Order
        orderAdapter = new OrderAdapter(getContext(),R.layout.item_order_layout,orderArrayList);
        lvOrder.setAdapter(orderAdapter);
    }
}
