package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;

import com.example.adapter.Product_List_Adapter;
import com.example.model.Products_ListView;
import com.example.mytest.productFragment.GridProductFragment;
import com.example.mytest.productFragment.ListProductFragment;
import com.example.mytest.ui.home.HomeFragment;

import java.util.ArrayList;

public class Product_List extends AppCompatActivity implements View.OnClickListener {
    ImageButton imgbtnGrid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        imgbtnGrid = findViewById(R.id.imgbtnGrid);
        imgbtnGrid.setOnClickListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentProduct,new ListProductFragment()).commit();

    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        if(v.getId()==R.id.imgbtnGrid)
        {if(imgbtnGrid.getTag()==null || imgbtnGrid.getTag().equals("list")){
            imgbtnGrid.setImageResource(R.drawable.filter);
            imgbtnGrid.setTag("grid");
            fragment = new GridProductFragment();
        }
        else {
            imgbtnGrid.setImageResource(R.drawable.grid);
            imgbtnGrid.setTag("list");
            fragment = new ListProductFragment();
        }
    }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentProduct,fragment).commit();
    }
}