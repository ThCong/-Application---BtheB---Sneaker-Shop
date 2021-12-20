package com.example.mytest.fragments;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adapter.Product_List_Adapter;
import com.example.Interface.MyItemClick;
import com.example.model.Product;
import com.example.mytest.R;

import java.util.ArrayList;

public class GridProductFragment extends Fragment {
    GridView grvProducts;
    Product_List_Adapter adapter;
    ArrayList<Product> arrayList;
    MyItemClick itemClick;
    TextView txtName,txtPrice,txtType;
    ImageView imvThumb;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_grid_product, container, false);
        grvProducts = view.findViewById(R.id.grvProducts);

        txtName = view.findViewById(R.id.txtName);
        txtPrice = view.findViewById(R.id.txtPrice);
        txtType = view.findViewById(R.id.txtType);
        imvThumb = view.findViewById(R.id.imvThumb);


        arrayList = new ArrayList<>();
        arrayList.add(new Product(R.drawable.sneaker1, "Converse", 10000, "ndjgv"));
        arrayList.add(new Product(R.drawable.sneaker2, "Nike", 12000, "fdhj"));
        arrayList.add(new Product(R.drawable.sneaker3, "Adidas", 20000, "sfv"));
        arrayList.add(new Product(R.drawable.sneaker1, "Puma", 8000, "fsnv"));
        arrayList.add(new Product(R.drawable.sneaker1, "Converse", 17000, "ndjgv"));
        arrayList.add(new Product(R.drawable.sneaker2, "Nike", 9000, "fdhj"));
        arrayList.add(new Product(R.drawable.sneaker3, "Adidas", 1000, "sfv"));
        arrayList.add(new Product(R.drawable.sneaker1, "Puma", 11000, "fsnv"));

        adapter = new Product_List_Adapter(getContext(), R.layout.custom_product_gridview, arrayList);
        grvProducts.setAdapter(adapter);
        grvProducts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT)
                {
                    itemClick = (MyItemClick) getActivity();
                    if(itemClick!=null)
                    {
                        itemClick.click(arrayList.get(position));
                    }
                }
                else
                {
                    txtName.setText(arrayList.get(position).getName());
                    txtPrice.setText(String.valueOf(arrayList.get(position).getPrice()));
                    txtType.setText(arrayList.get(position).getType());
                    imvThumb.setImageResource(arrayList.get(position).getThumb());
                }
            }
        });
        return view;
    }
}