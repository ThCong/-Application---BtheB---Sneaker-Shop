package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.model.PopupSizeModel;
import com.example.mytest.R;

import java.util.List;

public class PopupSizeAdapter extends BaseAdapter {
    Context context;
    int item_layout;
    List<PopupSizeModel> items;

    public PopupSizeAdapter(Context context, int item_layout, List<PopupSizeModel> items) {
        this.context = context;
        this.item_layout = item_layout;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int i) {
        return items.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        PopupSizeAdapter.ViewHolder holder;
        if (view==null)
        {
            holder=new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(item_layout, null);
            holder.txtSize = view.findViewById(R.id.txtSize);
            view.setTag(holder);
        }
        else {
            holder = (ViewHolder) view.getTag();
        }
        PopupSizeModel popupSizeModel = items.get(i);
        holder.txtSize.setText(popupSizeModel.getSize());
        return view;
    }

    public static class ViewHolder{
        TextView txtSize;
    }
}
