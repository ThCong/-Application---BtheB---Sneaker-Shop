package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.model.MyItemClick;
import com.example.model.Product;
import com.example.mytest.fragments.CartFragment;
import com.example.mytest.fragments.DetailFragment;
import com.example.mytest.fragments.GridProductFragment;
import com.example.mytest.fragments.ListProductFragment;
import com.example.utils.Constant;

public class Product_List extends AppCompatActivity implements View.OnClickListener, MyItemClick {
    ImageButton imgbtnGrid;
    ImageView imvBack,imvCart;
    private FragmentManager manager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);

        imgbtnGrid = findViewById(R.id.imgbtnGrid);
        imgbtnGrid.setOnClickListener(this);

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
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentProduct,new ListProductFragment()).commit();
    }

    @Override
    public void onClick(View v) {
        Fragment fragment = null;
        if(v.getId()==R.id.imgbtnGrid)
        {if(imgbtnGrid.getTag()==null || imgbtnGrid.getTag().equals("list")){
            imgbtnGrid.setImageResource(R.drawable.filter);
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
}
