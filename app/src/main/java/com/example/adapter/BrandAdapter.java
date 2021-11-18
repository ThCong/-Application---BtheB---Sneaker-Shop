package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.example.mytest.R;
import com.example.model.Brand;

import java.util.ArrayList;

public class BrandAdapter extends BaseAdapter {
    private Context context;
    int item_layout;
    ArrayList<Brand> brandlist;

    public BrandAdapter(Context context, int item_layout, ArrayList<Brand> brandlist) {
        this.context = context;
        this.item_layout = item_layout;
        this.brandlist = brandlist;
    }

    @Override
    public int getCount() {
        return brandlist.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder;
        if(view == null) {
            holder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(item_layout,null);
            holder.imvbrand = view.findViewById(R.id.imvbrand_item);
            view.setTag(holder);
        } else {holder =(ViewHolder) view.getTag();}
        Brand brand = brandlist.get(i);
        holder.imvbrand.setImageResource(brand.getImvbrand());
        return view;
    }
    public class ViewHolder{
        ImageView imvbrand;
    }
}
