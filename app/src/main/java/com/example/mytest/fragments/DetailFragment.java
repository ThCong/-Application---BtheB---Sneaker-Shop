package com.example.mytest.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.MyItemClick;
import com.example.model.Product;
import com.example.mytest.R;
import com.example.utils.Constant;

public class DetailFragment extends Fragment {
    public static Product p;
    Button btnAddToCart;
    ImageButton imvbtnBack;
    MyItemClick itemClick;
    TextView txtName,txtPrice,txtType;
    ImageView imvThumb;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_detail, container, false);

        imvbtnBack = view.findViewById(R.id.imvbtnBack);
        imvbtnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getFragmentManager().beginTransaction().remove(DetailFragment.this).commit();
            }
        });

        txtName = view.findViewById(R.id.txtName);
        txtPrice = view.findViewById(R.id.txtPrice);
        txtType = view.findViewById(R.id.txtType);
        imvThumb = view.findViewById(R.id.imvThumb);

        Bundle bundle = getArguments();

            p = (Product) bundle.getSerializable(Constant.SELECT_ITEM);
            txtName.setText(p.getName());
            txtPrice.setText(String.valueOf(p.getPrice()));
            txtType.setText(p.getType());
            imvThumb.setImageResource(p.getThumb());

        btnAddToCart = view.findViewById(R.id.btnAddToCart);

        btnAddToCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                }

            });


        return view;
    }
}