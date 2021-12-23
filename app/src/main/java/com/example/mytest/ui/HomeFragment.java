package com.example.mytest.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.GridView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.model.Brand;
import com.example.mytest.All_product;
import com.example.mytest.R;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import com.example.adapter.BrandAdapter;
import com.example.adapter.ImageAdapter;
import com.example.mytest.Voucher;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {
    ViewPager viewPager;
    ImageAdapter imageAdapter;
    GridView grvBrands;
    BrandAdapter brandAdapter;
    ArrayList<Brand> brandList;
    Button btnOpenShop, btnLastItem;
    CircleIndicator circleIndicator;
    Timer timer;
    View.OnClickListener OpenAllProducts;
    LinearLayout llShopAll, llBestSeller, llSaleOff, llVoucher;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        linkViews(view);
        loadData();
        addEvents();
        return view;
    }



    private void linkViews(View view) {

        viewPager = view.findViewById(R.id.viewPager);
        grvBrands = view.findViewById(R.id.grvBrands);
        btnOpenShop = view.findViewById(R.id.btnOpenShop);
        circleIndicator = view.findViewById(R.id.circleIndicator);
        llBestSeller = view.findViewById(R.id.llBestSeller);
        llSaleOff = view.findViewById(R.id.llSaleOff);
        llShopAll = view.findViewById(R.id.llShopAll);
        btnLastItem = view.findViewById(R.id.btnOpenLastItem);
        llVoucher = view.findViewById(R.id.llVoucher);
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
        brandAdapter = new BrandAdapter(getContext(), R.layout.item_brand_gridview_layout, brandList);
        grvBrands.setAdapter(brandAdapter);

        //Circle Indicator
        circleIndicator.setViewPager(viewPager);
        imageAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());

        //Auto Silde

        if (timer == null) {
            timer = new Timer();
        }
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(() -> {
                    int currentItem = viewPager.getCurrentItem();
                    int totalItem = imageAdapter.getCount() - 1;
                    if (currentItem < totalItem) {
                        currentItem++;
                        viewPager.setCurrentItem(currentItem);
                    } else {
                        viewPager.setCurrentItem(0);
                    }
                });
            }
        }, 1000, 2500);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (timer != null) {
            timer.cancel();
            timer = null;
        }
    }

    private void addEvents() {

        OpenAllProducts = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), All_product.class));
            }
        };
        btnOpenShop.setOnClickListener(OpenAllProducts);
        llShopAll.setOnClickListener(OpenAllProducts);
        llSaleOff.setOnClickListener(OpenAllProducts);
        llBestSeller.setOnClickListener(OpenAllProducts);
        btnLastItem.setOnClickListener(OpenAllProducts);

        llVoucher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), Voucher.class));
            }
        });

    };
    
    


}
