package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.widget.GridView;

import com.example.model.RecentProduct;
import com.example.model.TrendingProduct;

import java.util.ArrayList;

import adapter.ProductAdapter;
import adapter.RecentProductAdapter;
import adapter.TrendingProductAdapter;

public class SearchActivity extends AppCompatActivity {
GridView gvMatching;
ArrayList<MatchingProducts> arrayList;
ProductAdapter adapter;
    RecyclerView rcvTrend, rcvRecent;
    TrendingProductAdapter adapter2;
    RecentProductAdapter adapter3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_keyword);

        rcvTrend = findViewById(R.id.rcvTrend);
        rcvRecent = findViewById(R.id.rcvRecent);
        gvMatching = (GridView) findViewById(R.id.gvMatching);
        arrayList = new ArrayList<>();

        arrayList.add(new MatchingProducts("Converse All Star Hi Leather", R.drawable.sneaker1));
        arrayList.add(new MatchingProducts("Jordan Max Aura 3 Basketball", R.drawable.sneaker2));
        arrayList.add(new MatchingProducts("Men’s Nike Air Force 1 Casual", R.drawable.sneaker3));
        arrayList.add(new MatchingProducts("Adidas Comfort Slide Sandals", R.drawable.sneaker4));


        adapter = new ProductAdapter(this, R.layout.custom_matching, arrayList);
        gvMatching.setAdapter(adapter);

        //TRENDING SEARCHES

        LinearLayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false);
        rcvTrend.setLayoutManager(manager);

//                rcvTrend.setHasFixedSize(true);
//                rcvTrend.setItemAnimator(new DefaultItemAnimator());

        ArrayList<TrendingProduct> products = new ArrayList<>();
        products.add(new TrendingProduct("Jordan"));
        products.add(new TrendingProduct("Nike Air Force 1"));
        products.add(new TrendingProduct("Converse Chuck Taylor"));
        products.add(new TrendingProduct("PUMA Classic"));

        adapter2 = new TrendingProductAdapter(getApplicationContext(),products);
        rcvTrend.setAdapter(adapter2);

        DividerItemDecoration divider = new DividerItemDecoration(rcvTrend.getContext(),DividerItemDecoration.HORIZONTAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider);
        divider.setDrawable(drawable);
        rcvTrend.addItemDecoration(divider);

        //RECENT SEARCHES

        LinearLayoutManager manager1 = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false);
        rcvRecent.setLayoutManager(manager1);

        ArrayList<RecentProduct> products1 = new ArrayList<>();
        products1.add(new RecentProduct("Vans Authentic"));
        products1.add(new RecentProduct("Converse All Star Footwear"));
        products1.add(new RecentProduct("Adidas Original"));
        products1.add(new RecentProduct("Nike Air Max"));

        adapter3 = new RecentProductAdapter(getApplicationContext(), products1);
        rcvRecent.setAdapter(adapter3);

        DividerItemDecoration divider1 = new DividerItemDecoration(rcvRecent.getContext(),DividerItemDecoration.HORIZONTAL);
        Drawable drawable1 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider);
        divider.setDrawable(drawable1);
        rcvRecent.addItemDecoration(divider1);

    }
}