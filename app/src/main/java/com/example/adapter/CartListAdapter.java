package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Products_ListView;
import com.example.mytest.R;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder>{
    Context context;
ArrayList<Products_ListView> products;

    public CartListAdapter(Context context, ArrayList<Products_ListView> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public CartListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.custom_listcart,parent,false);

        return new ViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull CartListAdapter.ViewHolder holder, int position) {

        holder.imvThumb.setImageResource(products.get(position).getThumb());
        holder.txtName.setText(products.get(position).getName());
        holder.txtType.setText(products.get(position).getType());
        holder.txtPrice.setText("$" + String.valueOf(products.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imvThumb,imvMinus,imvPlus;
        TextView txtName, txtType,txtPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imvThumb= itemView.findViewById(R.id.imvThumb);
            txtName = itemView.findViewById(R.id.txtName);
            txtPrice = itemView.findViewById(R.id.txtPrice);
            txtType = itemView.findViewById(R.id.txtType);
            imvMinus = itemView.findViewById(R.id.imvMinus);
            imvPlus = imvMinus.findViewById(R.id.imvPlus);
        }
    }
}
