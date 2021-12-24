package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.Product;
import com.example.mytest.R;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder>{
    Context context;
    ArrayList<Product> products;
    int numberOrder = 1;

    public CartListAdapter(Context context, ArrayList<Product> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.custom_listcart,parent,false);

        return new ViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.imvThumb.setImageResource(products.get(position).getThumb());
        holder.txtName.setText(products.get(position).getName());
        holder.txtType.setText(products.get(position).getType());
        holder.txtPrice.setText("$" + String.valueOf(products.get(position).getPrice()));


        holder.imvAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder = numberOrder +1 ;
                holder.txtNumber.setText(String.valueOf(numberOrder).toString());
            }
        });
        holder.imvSubtract.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                numberOrder = numberOrder -1 ;
                holder.txtNumber.setText(String.valueOf(numberOrder).toString());
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageButton imvSubtract,imvAdd;
        ImageView imvThumb;
        TextView txtName, txtType,txtPrice, txtNumber;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imvThumb= itemView.findViewById(R.id.imvThumb_cart);
            txtName = itemView.findViewById(R.id.txtName_cart);
            txtPrice = itemView.findViewById(R.id.txtPrice_cart);
            txtType = itemView.findViewById(R.id.txtType_cart);
            imvSubtract = itemView.findViewById(R.id.imgbtnSubtract);
            imvAdd = itemView.findViewById(R.id.imgbtnAdd);
            txtNumber = itemView.findViewById(R.id.txtNumber);
        }
    }
}
