package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;
import android.widget.BaseAdapter;
import android.widget.GridView;


import com.example.mytest.BrandAdapter.BrandAdapter;
import com.example.mytest.ImageApapter.ImageAdapter;
import com.example.mytest.model.Brand;


import java.util.ArrayList;

public class Homepage extends AppCompatActivity {

    ViewPager viewPager;
    ImageAdapter imageAdapter;
    GridView grvBrands;
    BrandAdapter brandAdapter;
    ArrayList<Brand> brandList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);
        linkViews();
        loadData();
    }

    private void linkViews() {

        viewPager = findViewById(R.id.viewPager);
        grvBrands = findViewById(R.id.grvBrands);
    }
    private void loadData() {
        //banner slider
        imageAdapter = new ImageAdapter(this);
        viewPager.setAdapter(imageAdapter);

        //Gridview - Brands

        brandList = new ArrayList<>();
        brandList.add(new Brand(R.drawable.nike));
        brandList.add(new Brand(R.drawable.adidas));
        brandList.add(new Brand(R.drawable.supreme));
        brandList.add(new Brand(R.drawable.jordan));
        brandList.add(new Brand(R.drawable.balenciaga));
        brandList.add(new Brand(R.drawable.converse));
        brandList.add(new Brand(R.drawable.vans));
        brandList.add(new Brand(R.drawable.louboutin));
        brandAdapter = new BrandAdapter(this,R.layout.brand_item_gridview,brandList);
        grvBrands.setAdapter(brandAdapter);
    }

}