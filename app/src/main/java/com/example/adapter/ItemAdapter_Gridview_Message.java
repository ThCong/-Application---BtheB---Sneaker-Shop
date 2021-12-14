package com.example.adapter;

import android.content.ContentValues;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.ItemModel;
import com.example.mytest.R;

import java.util.List;

public class ItemAdapter_Gridview_Message extends BaseAdapter {

    Context context;
    int item_gridview;
    List<ItemModel> items;

    public ItemAdapter_Gridview_Message(Context context, int item_gridview, List<ItemModel> items) {
        this.context = context;
        this.item_gridview = item_gridview;
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
            holder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(R.layout.custom_item_message,null);
            holder.imvMessageThumb = view.findViewById(R.id.imvMessageThumb);
            holder.txtMessageName = view.findViewById(R.id.txtMessageName);

            view.setTag(holder);
        }
        else
        {
            holder = (ViewHolder) view.getTag();
        }

        ItemModel i = items.get(position);
        holder.imvMessageThumb.setImageResource(i.getMessage_Thumb());
        holder.txtMessageName.setText(i.getMessage_Name());
        return view;
    }

    public static class ViewHolder {
        ImageView imvMessageThumb;
        TextView txtMessageName;
    }
}
