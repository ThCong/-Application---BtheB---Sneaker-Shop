package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.mytest.adapter.NotiAdapter;
import com.example.mytest.model.Noti;

import java.util.ArrayList;

public class Notification extends AppCompatActivity {

    ListView lvNotification, lvOrder;
    NotiAdapter adapter;
    ArrayList<Noti> notiArrayList;


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
//        lvOrder = findViewById(R.id.lvOrder);
    }
    private void initData() {
        notiArrayList = new ArrayList<>();
//        notiArrayList.add( new Noti(R.drawable.mess1,"PEGASUS 38 FLYEASE “LIGHTING’"));
//        notiArrayList.add( new Noti(R.drawable.mess2,"SHOP FOR RUNNING SHOES LIKE A PRO"));
//        notiArrayList.add( new Noti(R.drawable.mess3,"NEW FAIRIES"));

    }
    private void loadData() {
        adapter = new NotiAdapter(this, R.layout.noti_item_layout,initData());
    }

}