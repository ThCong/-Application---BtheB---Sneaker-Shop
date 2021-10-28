package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.GridView;

import com.example.model.MatchingProducts;
import com.example.model.RecentProduct;
import com.example.model.TrendingProduct;

import java.util.ArrayList;

import adapter.ProductAdapter;
import adapter.RecentProductAdapter;
import adapter.TrendingProductAdapter;

public class SearchActivity extends AppCompatActivity {
    GridView gvMatching;
    ArrayList<MatchingProducts> arrayList;
    ProductAdapter adapterMatching;
    RecyclerView rcvTrend, rcvRecent;
    TrendingProductAdapter adapterTrending;
    RecentProductAdapter adapterRecent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);

        rcvTrend = findViewById(R.id.rcvTrend);
        rcvRecent = findViewById(R.id.rcvRecent);
        gvMatching = (GridView) findViewById(R.id.gvMatching);
        arrayList = new ArrayList<>();

        arrayList.add(new MatchingProducts("Converse All Star Hi Leather", R.drawable.sneaker1));
        arrayList.add(new MatchingProducts("Jordan Max Aura 3 Basketball", R.drawable.sneaker2));
        arrayList.add(new MatchingProducts("Men’s Nike Air Force 1 Casual", R.drawable.sneaker3));
        arrayList.add(new MatchingProducts("Adidas Comfort Slide Sandals", R.drawable.sneaker4));


        adapterMatching = new ProductAdapter(this, R.layout.custom_matching, arrayList);
        gvMatching.setAdapter(adapterMatching);

        //TRENDING SEARCHES

        LinearLayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false);
        rcvTrend.setLayoutManager(manager);
        ArrayList<TrendingProduct> products = new ArrayList<>();
        products.add(new TrendingProduct("Jordan"));
        products.add(new TrendingProduct("Nike Air Force 1"));
        products.add(new TrendingProduct("Converse Chuck Taylor"));
        products.add(new TrendingProduct("PUMA Classic"));

        adapterTrending = new TrendingProductAdapter(getApplicationContext(),products);
        rcvTrend.setAdapter(adapterTrending);

        DividerItemDecoration divider1 = new DividerItemDecoration(rcvTrend.getContext(),DividerItemDecoration.HORIZONTAL);
        Drawable drawable1 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider);
        divider1.setDrawable(drawable1);
        rcvTrend.addItemDecoration(divider1);

        //RECENT SEARCHES

        LinearLayoutManager manager1 = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false);
        rcvRecent.setLayoutManager(manager1);

        ArrayList<RecentProduct> products1 = new ArrayList<>();
        products1.add(new RecentProduct("Vans Authentic"));
        products1.add(new RecentProduct("Converse All Star Footwear"));
        products1.add(new RecentProduct("Adidas Original"));
        products1.add(new RecentProduct("Nike Air Max"));

        adapterRecent = new RecentProductAdapter(getApplicationContext(), products1);
        rcvRecent.setAdapter(adapterRecent);

        DividerItemDecoration divider2 = new DividerItemDecoration(rcvRecent.getContext(),DividerItemDecoration.HORIZONTAL);
        Drawable drawable2 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider);
        divider2.setDrawable(drawable2);
        rcvTrend.addItemDecoration(divider2);

    }
}