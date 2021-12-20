package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.ItemModel;
import com.example.model.Myorders;
import com.example.mytest.R;

import java.util.List;

public class ItemAdapter_ListView extends BaseAdapter {

    Context context;
    int item_listview;
    List<Myorders> items;

    public ItemAdapter_ListView(Context context, int item_listview, List<Myorders> items) {
        this.context = context;
        this.item_listview = item_listview;
        this.items = items;
    }



    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        ViewHolder holder;
        if (view == null)
        {
            holder = new com.example.adapter.ItemAdapter_ListView.ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.trackmyorder_customview,null);
            holder.imvThumb = view.findViewById(R.id.imvThumb);
            holder.txtName = view.findViewById(R.id.txtName);

            view.setTag(holder);
        }
        else
        {
            holder = (com.example.adapter.ItemAdapter_ListView.ViewHolder) view.getTag();
        }

        Myorders i = items.get(position);
        holder.imvThumb.setImageResource(i.getThumb());
        holder.txtName.setText(i.getName());
        return view;
    }


    public static class ViewHolder {
        ImageView imvThumb; TextView txtName;
    }
}


