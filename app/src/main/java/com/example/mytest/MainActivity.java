package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;


import android.os.Bundle;

import com.example.mytest.ImageApapter.ImageAdapter;

public class MainActivity extends AppCompatActivity {

    ViewPager viewPager;
    ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linkViews();
        loadData();
    }

    private void linkViews() {
        viewPager = findViewById(R.id.viewPager);
    }
    private void loadData() {
        imageAdapter = new ImageAdapter(this);
        viewPager.setAdapter(imageAdapter);
    }
}