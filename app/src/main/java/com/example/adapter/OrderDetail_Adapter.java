package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.Order_Detail;
import com.example.model.Product;
import com.example.mytest.R;

import java.util.List;

public class OrderDetail_Adapter extends BaseAdapter {
    Context context;
    int layout;
    List<Order_Detail> orders;

    public OrderDetail_Adapter(Context context, int layout, List<Order_Detail> orders) {
        this.context = context;
        this.layout = layout;
        this.orders = orders;
    }

    @Override
    public int getCount() {
        return orders.size();
    }

    @Override
    public Object getItem(int i) {
        return orders.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        if ( convertView == null){
            viewHolder = new ViewHolder();
            convertView = inflater.inflate(layout, null);
            viewHolder.imvThumb=(ImageView) convertView.findViewById(R.id.imvThumb);
            viewHolder.txtName=(TextView) convertView.findViewById(R.id.txtName);
            viewHolder.txtPrice=(TextView) convertView.findViewById(R.id.txtPrice);
            viewHolder.txtQuantity = convertView.findViewById(R.id.txtquantity);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Order_Detail o = orders.get(i);
        viewHolder.txtName.setText(o.getName());
        viewHolder.imvThumb.setImageResource(o.getThumb());
        viewHolder.txtPrice.setText(String.valueOf(o.getPrice()));
        viewHolder.txtQuantity.setText(String.valueOf(o.getQuantity()));
        return convertView;
    }

    private class ViewHolder{
        TextView txtName,txtPrice,txtQuantity;
        ImageView imvThumb;
    }
}
