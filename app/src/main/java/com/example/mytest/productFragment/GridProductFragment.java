package com.example.mytest.productFragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import com.example.adapter.Product_List_Adapter;
import com.example.model.Products_ListView;
import com.example.mytest.R;

import java.util.ArrayList;

public class GridProductFragment extends Fragment {
    GridView grvProducts;
    Product_List_Adapter adapter;
    ArrayList<Products_ListView> arrayList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         View view = inflater.inflate(R.layout.fragment_grid_product, container, false);
        grvProducts = view.findViewById(R.id.grvProducts);

        arrayList = new ArrayList<>();
        arrayList.add(new Products_ListView("Converse",R.drawable.sneaker1,10000));
        arrayList.add(new Products_ListView("Nike",R.drawable.sneaker2,10000));
        arrayList.add(new Products_ListView("Adidas",R.drawable.sneaker3,10000));
        arrayList.add(new Products_ListView("Puma",R.drawable.sneaker1,10000));
        arrayList.add(new Products_ListView("Adidas",R.drawable.sneaker3,10000));
        arrayList.add(new Products_ListView("Puma",R.drawable.sneaker1,10000));
        arrayList.add(new Products_ListView("Adidas",R.drawable.sneaker3,10000));
        arrayList.add(new Products_ListView("Puma",R.drawable.sneaker1,10000));

        adapter= new Product_List_Adapter(getContext(),R.layout.custom_product_gridview,arrayList);
        grvProducts.setAdapter(adapter);
         return view;
    }
}