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

import com.example.database.Product_Database_Helper;
import com.example.model.Product;

import java.util.ArrayList;

import com.example.adapter.ProductAdapter;
import com.example.adapter.RecentAndTrendingAdapter;
import com.example.mytest.fragments.DetailFragment;
import com.example.utils.Constant;

public class Search_keyword extends AppCompatActivity {
    ImageButton btnBack;
    GridView gvMatching;
    ArrayList<Product> arrayList;
    ProductAdapter adapter;
    RecyclerView rcvTrend, rcvRecent;
    RecentAndTrendingAdapter adapter2, adapter3;
    Fragment detailFragment = null;
    EditText edtSearch;
    Product_Database_Helper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_keyword);

        rcvTrend = findViewById(R.id.rcvTrend);
        rcvRecent = findViewById(R.id.rcvRecent);
        gvMatching = findViewById(R.id.gvMatching);
        edtSearch = findViewById(R.id.edtSearch);
        arrayList = new ArrayList<>();

        db = new Product_Database_Helper(this);
        arrayList = db.dsAllProducts();
        adapter = new ProductAdapter(this, R.layout.item_matching_layout, arrayList);
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

        LinearLayoutManager manager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rcvTrend.setLayoutManager(manager);
        rcvTrend.setHasFixedSize(true);

        String[] trending = {"Jordan","Nike Air Force 1","PUMA Classic","Converse Chuck Taylor" };
        adapter2 = new RecentAndTrendingAdapter(getApplicationContext(),trending);
        adapter.notifyDataSetChanged();
        rcvTrend.setAdapter(adapter2);


        DividerItemDecoration divider = new DividerItemDecoration(rcvTrend.getContext(),DividerItemDecoration.HORIZONTAL);
        Drawable drawable = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider);
        divider.setDrawable(drawable);
        rcvTrend.addItemDecoration(divider);

        //RECENT SEARCHES

        LinearLayoutManager manager1 = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false);
        rcvRecent.setLayoutManager(manager1);
        String[] recent = {"Vans Authentic","Converse All Star Footwear","Adidas Original","Nike Air Max"};
        adapter3 = new RecentAndTrendingAdapter(getApplicationContext(), recent);
        rcvRecent.setAdapter(adapter3);
        DividerItemDecoration divider1 = new DividerItemDecoration(rcvRecent.getContext(),DividerItemDecoration.HORIZONTAL);
        Drawable drawable1 = ContextCompat.getDrawable(getApplicationContext(), R.drawable.custom_divider);
        divider1.setDrawable(drawable1);
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