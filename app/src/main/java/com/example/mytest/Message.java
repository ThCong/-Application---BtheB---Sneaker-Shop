package com.example.mytest;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.adapter.ItemAdapter_Gridview_Message;
import com.example.model.ItemModel;
import com.example.mytest.fragments.Mess1Fragment;
import com.example.mytest.fragments.Mess2Fragment;
import com.example.mytest.fragments.Mess3Fragment;

import java.util.ArrayList;

public class Message extends AppCompatActivity {
    GridView gvMessage;
    ArrayList<ItemModel> items;
    ItemAdapter_Gridview_Message adapter;
    ImageView imvBack;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message);

        gvMessage = findViewById(R.id.gvMessage);

        items = new ArrayList<ItemModel>();
        items.add(new ItemModel(R.drawable.image_mess1, "PEGASUS 38 FLYEASE LIGHTING"));
        items.add(new ItemModel(R.drawable.image_mess2, "SHOP FOR RUNNING SHOES LIKE A PRO"));
        items.add(new ItemModel(R.drawable.image_mess3, "NEW FAIRIES"));
        items.add(new ItemModel(R.drawable.image_mess4, "WARM LIGHTWEIGHT"));
        items.add(new ItemModel(R.drawable.image_mess5, "PEGASUS 38 FLYEASE LIGHTING"));
        items.add(new ItemModel(R.drawable.image_mess6, "SHOP FOR RUNNING SHOES LIKE A PRO"));

        adapter = new ItemAdapter_Gridview_Message(this,R.layout.item_message_layout,items);

        gvMessage.setAdapter(adapter);

        gvMessage.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                ItemModel i = items.get(position);
                switch (i.getMessage_Name()) {
                    case "PEGASUS 38 FLYEASE LIGHTING" : getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full_message,new Mess1Fragment()).commit(); break;
                    case "SHOP FOR RUNNING SHOES LIKE A PRO" : getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full_message,new Mess2Fragment()).commit(); break;
                    case "NEW FAIRIES" : getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full_message,new Mess3Fragment()).commit(); break;
                }
            }
        });

        imvBack = findViewById(R.id.imvBack);
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
