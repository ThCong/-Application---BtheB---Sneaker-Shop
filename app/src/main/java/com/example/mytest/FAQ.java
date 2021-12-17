package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.adapter.FAQ_TopicAdapter;
import com.example.adapter.ProductAdapter;
import com.example.model.FAQ_Topic;
import com.example.model.Product;

import java.util.ArrayList;

public class FAQ extends AppCompatActivity {
    RecyclerView rcvTopic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faq);
        LinkViews();
        confiRecycleView();
        initData();
    }

    private void LinkViews() {
        rcvTopic = findViewById(R.id.rcvTopic);
    }

    private void confiRecycleView() {
        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rcvTopic.setLayoutManager(manager);



        rcvTopic.setHasFixedSize(true);
        rcvTopic.setItemAnimator(new DefaultItemAnimator());
    }

    private void initData() {
        ArrayList<FAQ_Topic> topics = new ArrayList<>();
        topics.add(new FAQ_Topic(R.drawable.profile,"My Account"));
        topics.add(new FAQ_Topic(R.drawable.product,"Products"));
        topics.add(new FAQ_Topic(R.drawable.truck_big,"Delivery"));


        FAQ_TopicAdapter adapter = new FAQ_TopicAdapter(getApplicationContext(), topics);
        rcvTopic.setAdapter(adapter);


    }
}