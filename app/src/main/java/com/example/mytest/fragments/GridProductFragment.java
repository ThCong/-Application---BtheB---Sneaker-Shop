package com.example.mytest.fragments;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adapter.Product_List_Adapter;
import com.example.model.MyItemClick;
import com.example.model.Products_ListView;
import com.example.mytest.R;

import java.util.ArrayList;

public class GridProductFragment extends Fragment {
    GridView grvProducts;
    Product_List_Adapter adapter;
    ArrayList<Products_ListView> arrayList;
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
        arrayList.add(new Products_ListView(R.drawable.sneaker1, "Converse", 10000, "ndjgv"));
        arrayList.add(new Products_ListView(R.drawable.sneaker2, "Nike", 10000, "fdhj"));
        arrayList.add(new Products_ListView(R.drawable.sneaker3, "Adidas", 10000, "sfv"));
        arrayList.add(new Products_ListView(R.drawable.sneaker1, "Puma", 10000, "fsnv"));
        arrayList.add(new Products_ListView(R.drawable.sneaker1, "Converse", 10000, "ndjgv"));
        arrayList.add(new Products_ListView(R.drawable.sneaker2, "Nike", 10000, "fdhj"));
        arrayList.add(new Products_ListView(R.drawable.sneaker3, "Adidas", 10000, "sfv"));
        arrayList.add(new Products_ListView(R.drawable.sneaker1, "Puma", 10000, "fsnv"));


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