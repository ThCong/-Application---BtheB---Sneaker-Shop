package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Products_ListView;
import com.example.mytest.R;

import java.util.ArrayList;
import java.util.List;


public class Product_List_Adapter extends BaseAdapter {
    Context context;
    int layout;
    List<Products_ListView> products_listViews;

    public Product_List_Adapter(Context context, int layout, ArrayList<Products_ListView> arrayList) {
        this.context = context;
        this.layout = layout;
        this.products_listViews = arrayList;
    }

    @Override
    public int getCount() {
        return products_listViews.size();
    }

    @Override
    public Object getItem(int i) {
        return products_listViews.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        Product_List_Adapter.ViewHolder viewHolder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if ( convertView == null){
            viewHolder = new Product_List_Adapter.ViewHolder();
            convertView = inflater.inflate(layout, null);
            viewHolder.imvThumb=(ImageView) convertView.findViewById(R.id.imvThumb);
            viewHolder.txtName=(TextView) convertView.findViewById(R.id.txtName);
            viewHolder.txtPrice=(TextView) convertView.findViewById(R.id.txtPrice);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (Product_List_Adapter.ViewHolder) convertView.getTag();
        }

        Products_ListView p= products_listViews.get(i);
        viewHolder.txtName.setText(p.getName());
        viewHolder.imvThumb.setImageResource(p.getThumb());
        viewHolder.txtPrice.setText(String.valueOf(p.getPrice()));
        return convertView;
    }

    private class ViewHolder{
        TextView txtName,txtPrice;
        ImageView imvThumb;
    }
}

