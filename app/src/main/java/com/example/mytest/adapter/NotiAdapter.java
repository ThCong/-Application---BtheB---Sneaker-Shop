package com.example.mytest.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.mytest.R;
import com.example.mytest.model.Noti;

import java.util.ArrayList;

public class NotiAdapter extends BaseAdapter {
    private Context context;
    int item_layout;
    ArrayList<Noti> notiList;

    public NotiAdapter(Context context, int item_layout, ArrayList<Noti> notiList) {
        this.context = context;
        this.item_layout = item_layout;
        this.notiList = notiList;
    }

    @Override
    public int getCount() {
        return notiList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        ViewHolder holder;
        if(view == null) {
            holder = new ViewHolder();
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(item_layout,null);
            holder.imvThumb = view.findViewById(R.id.imvThumb_Noti);
            holder.txtTitle = view.findViewById(R.id.txtTitle_Noti);
            view.setTag(holder);
        } else {holder = (ViewHolder) view.getTag();}
        Noti noti = notiList.get(i);
        holder.imvThumb.setImageResource(noti.getImgThumb());
        holder.txtTitle.setText(noti.getTxtTitle().toString());

        return view;
    }
    public class ViewHolder{
        ImageView imvThumb;
        TextView txtTitle;
    }
}
