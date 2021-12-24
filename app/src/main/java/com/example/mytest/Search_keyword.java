package com.example.mytest;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.model.Product;
import com.example.model.RecentProduct;
import com.example.model.TrendingProduct;

import java.util.ArrayList;

import com.example.adapter.ProductAdapter;
import com.example.adapter.RecentProductAdapter;
import com.example.adapter.TrendingProductAdapter;
import com.example.mytest.fragments.DetailFragment;
import com.example.mytest.fragments.ListProductFragment;
import com.example.utils.Constant;

public class Search_keyword extends AppCompatActivity {
    ImageButton btnBack;
    GridView gvMatching;
    ArrayList<Product> arrayList;
    ProductAdapter adapter;
    RecyclerView rcvTrend, rcvRecent;
    TrendingProductAdapter adapter2;
    RecentProductAdapter adapter3;
    Fragment detailFragment = null;
    EditText edtSearch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_keyword);

        rcvTrend = findViewById(R.id.rcvTrend);
        rcvRecent = findViewById(R.id.rcvRecent);
        gvMatching = findViewById(R.id.gvMatching);
        edtSearch = findViewById(R.id.edtSearch);
        arrayList = new ArrayList<>();

        arrayList.add(new Product(R.drawable.sneaker1,"Converse",10000,"ndjgv"));
        arrayList.add(new Product(R.drawable.sneaker2,"Nike",10000,"fdhj"));
        arrayList.add(new Product(R.drawable.sneaker3,"Adidas",10000,"sfv"));
        arrayList.add(new Product(R.drawable.sneaker4,"Puma",10000,"fsnv"));

        adapter = new ProductAdapter(this, R.layout.custom_matching, arrayList);
        gvMatching.setAdapter(adapter);

        gvMatching.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Product p = arrayList.get(position);
                detailFragment= new DetailFragment();
                Bundle bundle = new Bundle();
                bundle.putSerializable(Constant.SELECT_ITEM,p);
                detailFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_container_full_searchView, detailFragment)
                        .commit();
            }
        });

      //  TRENDING SEARCHES

        LinearLayoutManager manager = new LinearLayoutManager(this,
                LinearLayoutManager.HORIZONTAL,false);
        rcvTrend.setLayoutManager(manager);

                rcvTrend.setHasFixedSize(true);


        ArrayList<TrendingProduct> products = new ArrayList<>();
        products.add(new TrendingProduct("Jordan"));
        products.add(new TrendingProduct("Nike Air Force 1"));
        products.add(new TrendingProduct("Converse Chuck Taylor"));
        products.add(new TrendingProduct("PUMA Classic"));

        adapter2 = new TrendingProductAdapter(getApplicationContext(),products);
        adapter.notifyDataSetChanged();
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

        btnBack = findViewById(R.id.btnBackSearch);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}