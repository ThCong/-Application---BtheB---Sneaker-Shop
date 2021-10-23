package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class BrandActivity extends AppCompatActivity {
    ListView lvBrands;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brand);

        lvBrands = findViewById(R.id.lvBrands);
        arrayList = new ArrayList<>();

        arrayList.add("Adidas");
        arrayList.add("Alexander McQueen");
        arrayList.add("Asics");

        arrayList.add("Balenciaga");
        arrayList.add("Burberry");
        arrayList.add("Brookhaven");

        arrayList.add("Calvin Klein");
        arrayList.add("Converse");
        arrayList.add("Champion");

        arrayList.add("Degrey");
        arrayList.add("Dirty Coins");
        arrayList.add("Dior");
        arrayList.add("Dolce Gabbana");


        ArrayAdapter adapter = new ArrayAdapter(BrandActivity.this,
                android.R.layout.simple_list_item_1, arrayList);

        lvBrands.setAdapter(adapter);
    }
}