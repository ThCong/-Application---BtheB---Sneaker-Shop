package com.example.mytest;

import android.os.Bundle;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.adapter.AllSportAdapter;
import com.example.model.AllSportsModel;

import java.util.ArrayList;

public class AllSports  extends AppCompatActivity {
    GridView gvAllSports;
    ArrayList<AllSportsModel> items;
    AllSportAdapter adapter;
@Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_all_sports);

        gvAllSports = findViewById(R.id.gvAllSports);

        items =new ArrayList<>();
        items.add(new AllSportsModel(R.drawable.fitness,"Fitness and Training"));
        items.add(new AllSportsModel(R.drawable.running,"Running"));
        items.add(new AllSportsModel(R.drawable.boxing,"Boxing"));
        items.add(new AllSportsModel(R.drawable.baseball,"Baseball"));
        items.add(new AllSportsModel(R.drawable.swimming,"Swimming"));
        items.add(new AllSportsModel(R.drawable.soccer,"Soccer"));
        items.add(new AllSportsModel(R.drawable.football,"Football"));
        items.add(new AllSportsModel(R.drawable.basketball,"Basketball"));
        items.add(new AllSportsModel(R.drawable.volleyball,"Volleyball"));
        items.add(new AllSportsModel(R.drawable.hiking,"Hiking"));
        items.add(new AllSportsModel(R.drawable.tennis,"Tennis"));
        items.add(new AllSportsModel(R.drawable.all,"Shop All"));

        adapter = new AllSportAdapter(this, R.layout.custom_item_allsports, items);
        gvAllSports.setAdapter(adapter);
}
}
