package com.example.mytest.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import com.example.mytest.All_product;
import com.example.mytest.R;

public class Mess2Fragment extends Fragment {
    ImageView imvBack;
    Button btnShopNow;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mess2, container, false);
        imvBack = view.findViewById(R.id.imvBack);
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().remove(Mess2Fragment.this).commit();
            }
        });
        btnShopNow = view.findViewById(R.id.btnShopNowMess2);
        btnShopNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getContext(), All_product.class));
            }
        });
        return view;
    }
}