package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Vouchers;
import com.example.mytest.R;

import java.util.ArrayList;

public class VoucherAdapter extends BaseAdapter {
    private Context context;
    int item_layout;
    ArrayList<Vouchers> vouchers;

    public VoucherAdapter(Context context, int item_layout, ArrayList<Vouchers> vouchers) {
        this.context = context;
        this.item_layout = item_layout;
        this.vouchers = vouchers;
    }


    @Override
    public int getCount() {
        return vouchers.size();
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
            holder.imvThumb = view.findViewById(R.id.imvThumbVoucher);
            holder.txtTitle = view.findViewById(R.id.txtTitleVoucher);
            holder.txtDescrip = view.findViewById(R.id.txtDescripVoucher);
            view.setTag(holder);
        } else {holder = (ViewHolder) view.getTag();}
        Vouchers voucher = vouchers.get(i);
        holder.imvThumb.setImageResource(voucher.getImvThumb());
        holder.txtTitle.setText(voucher.getTxtTittle());
        holder.txtDescrip.setText(voucher.getTxtDescrip());
        return view;
    }
    public class ViewHolder{
        ImageView imvThumb;
        TextView txtTitle,txtDescrip;
    }
}
