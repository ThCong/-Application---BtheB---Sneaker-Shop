package com.example.mytest;

import android.os.Bundle;
import android.widget.GridView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.adapter.PopupSizeAdapter;
import com.example.model.PopupSizeModel;

import java.util.ArrayList;

public class PopupSize extends AppCompatActivity {
    GridView gvPopSize;
    ArrayList<PopupSizeModel> items;
    PopupSizeAdapter adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_popup_size);

        gvPopSize = findViewById(R.id.gvPopSize);

        items = new ArrayList<>();
        items.add(new PopupSizeModel("7"));
        items.add(new PopupSizeModel("7.5"));
        items.add(new PopupSizeModel("8"));
        items.add(new PopupSizeModel("8.5"));
        items.add(new PopupSizeModel("9"));
        items.add(new PopupSizeModel("9.5"));

        adapter = new PopupSizeAdapter(this,R.layout.custom_size, items);
        gvPopSize.setAdapter(adapter);
    }

}
