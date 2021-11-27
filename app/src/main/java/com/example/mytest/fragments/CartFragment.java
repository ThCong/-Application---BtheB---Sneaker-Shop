package com.example.mytest.fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import java.io.Serializable;
import com.example.adapter.CartListAdapter;
import com.example.model.Products_ListView;
import com.example.mytest.MainActivity;
import com.example.mytest.R;
import com.example.utils.Constant;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class CartFragment extends Fragment {
    private ImageView imvClose;
    RecyclerView rcvListCart;
    private ImageButton imvTickAll;
    private TextView txtTotal;
    private Button btnCheckout;
    CartListAdapter adapter;
    ArrayList<Products_ListView> products;
    BottomNavigationView bottomNavigationView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_cart, container, false);

        imvClose = (ImageView) view.findViewById(R.id.imvClose);
        rcvListCart = (RecyclerView) view.findViewById(R.id.rcvListCart);
        imvTickAll = (ImageButton) view.findViewById(R.id.imvTickAll);
        txtTotal = (TextView) view.findViewById(R.id.txtTotal);
        btnCheckout = (Button) view.findViewById(R.id.btnCheckout);

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rcvListCart.setLayoutManager(linearLayoutManager);

        rcvListCart.setHasFixedSize(true);
        rcvListCart.setItemAnimator(new DefaultItemAnimator());

        products= new ArrayList<>();
        products.add(new Products_ListView(R.drawable.sneaker1,"Converse",10000,"ndjgv"));
        products.add(new Products_ListView(R.drawable.sneaker1,"Converse",10000,"ndjgv"));
        products.add(new Products_ListView(R.drawable.sneaker1,"Converse",10000,"ndjgv"));
        products.add(new Products_ListView(R.drawable.sneaker1,"Converse",10000,"ndjgv"));
        products.add(new Products_ListView(R.drawable.sneaker1,"Converse",10000,"ndjgv"));
        products.add(new Products_ListView(R.drawable.sneaker1,"Converse",10000,"ndjgv"));
        products.add(new Products_ListView(R.drawable.sneaker1,"Converse",10000,"ndjgv"));
        products.add(new Products_ListView(R.drawable.sneaker1,"Converse",10000,"ndjgv"));

        adapter= new CartListAdapter(getContext(),products);
        rcvListCart.setAdapter(adapter);
        imvClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().remove(CartFragment.this).commit();
                bottomNavigationView = MainActivity.bottomNavigationView;
                bottomNavigationView.clearAnimation();
                bottomNavigationView.animate().translationX(bottomNavigationView.getHeight()).setDuration(300);
            }
        });

        return view;
    }


}