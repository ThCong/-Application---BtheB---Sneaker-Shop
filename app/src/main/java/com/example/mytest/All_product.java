package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.Interface.MyItemClick;
import com.example.model.Product;
import com.example.mytest.fragments.CartFragment;
import com.example.mytest.fragments.DetailFragment;
import com.example.mytest.fragments.GridProductFragment;
import com.example.mytest.fragments.ListProductFragment;
import com.example.utils.Constant;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class All_product extends AppCompatActivity implements View.OnClickListener, MyItemClick {
    ImageButton imgbtnGrid, imgbtnFilter;
    ImageView imvBack,imvCart;
    EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.allproduct);

        imgbtnGrid = findViewById(R.id.imgbtnGrid);
        imgbtnGrid.setOnClickListener(this);


        imgbtnFilter = findViewById(R.id.imgbtnFilter);
        imgbtnFilter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomSheetDialog b = new BottomSheetDialog(All_product.this);
                b.setContentView(R.layout.layout_popup_filter);
                b.show();
            }
        });


        imvBack = (ImageView) findViewById(R.id.imvBack);
        imvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        imvCart = findViewById(R.id.imvCart);
        imvCart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment fragment = new CartFragment();
                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full1,fragment).commit();
            }
        });

        edtSearch = findViewById(R.id.edtSearch);
        edtSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(All_product.this,Search_keyword.class));
            }
        });
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentProduct,new ListProductFragment()).commit();
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        if(v.getId()==R.id.imgbtnGrid)
        {if(imgbtnGrid.getTag()==null || imgbtnGrid.getTag().equals("list")){
            imgbtnGrid.setImageResource(R.drawable.list);
            imgbtnGrid.setTag("grid");
            fragment = new GridProductFragment();

        }
        else {
            imgbtnGrid.setImageResource(R.drawable.grid);
            imgbtnGrid.setTag("list");
            fragment = new ListProductFragment();
        }
    }
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentProduct,fragment).commit();
    }

    @Override
    public void click(Product p) {
        DetailFragment detailFragment= new DetailFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(Constant.SELECT_ITEM,p);
                detailFragment.setArguments(bundle);
                if (bundle != null)

                getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container_full1, detailFragment).
                addToBackStack(null).
                commit();
    }

    public void openSizeDialog(Product p) {
        Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.layout_popup_size);
        dialog.show();
    }
}
