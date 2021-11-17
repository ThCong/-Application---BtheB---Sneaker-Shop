package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.mytest.adapter.CartListAdapter;
import com.example.mytest.model.ProductCart;

import java.util.ArrayList;

public class Cart extends AppCompatActivity {
    private ImageButton imvClose;
    private RecyclerView rcvListCart;
    private ImageButton imvTickAll;
    private TextView txtTotal;
    private Button btnCheckout;
    CartListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);


        imvClose = (ImageButton) findViewById(R.id.imvClose);
        rcvListCart = (RecyclerView) findViewById(R.id.rcvListCart);
        imvTickAll = (ImageButton) findViewById(R.id.imvTickAll);
        txtTotal = (TextView) findViewById(R.id.txtTotal);
        btnCheckout = (Button) findViewById(R.id.btnCheckout);

        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        rcvListCart.setLayoutManager(linearLayoutManager);

        rcvListCart.setHasFixedSize(true);
        rcvListCart.setItemAnimator(new DefaultItemAnimator());

        ArrayList<ProductCart> products = new ArrayList<>();
        products.add(new ProductCart(R.drawable.pr4,"Heniken",19000,"ds"));
        products.add(new ProductCart(R.drawable.pr4,"Heniken",19000,"ds"));
        products.add(new ProductCart(R.drawable.pr4,"Heniken",19000,"ds"));
        products.add(new ProductCart(R.drawable.pr4,"Heniken",19000,"ds"));
        products.add(new ProductCart(R.drawable.pr4,"Heniken",19000,"ds"));
        products.add(new ProductCart(R.drawable.pr4,"Heniken",19000,"ds"));



        adapter= new CartListAdapter(getApplicationContext(),products);
        rcvListCart.setAdapter(adapter);
    }
}