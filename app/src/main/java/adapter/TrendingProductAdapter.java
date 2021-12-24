package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytest.R;
import com.example.model.TrendingProduct;

import java.util.ArrayList;

public class TrendingProductAdapter extends RecyclerView.Adapter<TrendingProductAdapter.ViewHolder> {
    Context context;

    ArrayList<TrendingProduct> products;

    public TrendingProductAdapter(Context context, ArrayList<TrendingProduct> products) {
        this.context = context;
        this.products = products;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View customView = inflater.inflate(R.layout.custom_trending,parent,false);

        return new ViewHolder(customView);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.btnTrend.setText(""+ products.get(position).getTrending());
    }

    @Override
    public int getItemCount() {

        return products.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        Button btnTrend;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            btnTrend = itemView.findViewById(R.id.btnTrend);
        }
    }
}
