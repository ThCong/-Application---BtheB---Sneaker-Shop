package com.example.mytest.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.model.Brand;
import com.example.model.Products_ListView;
import com.example.mytest.Product_List;
import com.example.mytest.R;

import java.util.ArrayList;

import adapter.BrandAdapter;
import adapter.ImageAdapter;

public class HomeFragment extends Fragment {
    ViewPager viewPager;
    ImageAdapter imageAdapter;
    GridView grvBrands;
    BrandAdapter brandAdapter;
    ArrayList<Brand> brandList;
    Button btnOpenShop;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        linkViews(view);
        loadData();
        addEvents();
        return view ;
    }

    private void linkViews(View view) {

        viewPager = view.findViewById(R.id.viewPager);
        grvBrands = view.findViewById(R.id.grvBrands);
        btnOpenShop = view.findViewById(R.id.btnOpenShop);
    }
    private void loadData() {
        //banner slider
        imageAdapter = new ImageAdapter(getContext());
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
        brandAdapter = new BrandAdapter(getContext(),R.layout.brand_item_gridview,brandList);
        grvBrands.setAdapter(brandAdapter);
    }
    private void addEvents() {
        btnOpenShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(getContext(), Product_List.class);
                startActivity(intent);
            }
        });
    }
}
