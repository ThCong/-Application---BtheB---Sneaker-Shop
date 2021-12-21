package com.example.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.model.RecentProduct;
import com.example.mytest.R;

import java.util.ArrayList;


public class RecentProductAdapter extends RecyclerView.Adapter<RecentProductAdapter.ViewHolder> {
    Context context;
    ArrayList<RecentProduct> products1;

    public RecentProductAdapter(Context context, ArrayList<RecentProduct> products1) {
        this.context = context;
        this.products1 = products1;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.item_recent_layout,parent,false);

        return new ViewHolder(customView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.btnRecent.setText(""+ products1.get(position).getRecent());
    }

    @Override
    public int getItemCount() {
        return products1.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder{
        Button btnRecent;
        public ViewHolder(@NonNull View itemView){
            super (itemView);
            btnRecent = itemView.findViewById(R.id.btnRecent);
        }

    }
}
