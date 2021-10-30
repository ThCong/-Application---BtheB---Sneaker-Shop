package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.model.MatchingProducts;
import com.example.mytest.R;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends BaseAdapter {

    Context context;
    int layout;
    List<MatchingProducts> arrayList;

    public ProductAdapter(Context context, int layout, ArrayList<MatchingProducts> arrayList) {
        this.context = context;
        this.layout = layout;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return arrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    private class ViewHolder{
        TextView txtName;
        ImageView imvPhoto;
    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        if ( view == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(layout, null);
            viewHolder = new ViewHolder();

            viewHolder.txtName=(TextView) view.findViewById(R.id.txtName);
            viewHolder.imvPhoto=(ImageView) view.findViewById(R.id.imvPhoto);

            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.txtName.setText(arrayList.get(i).ProductName);
        viewHolder.imvPhoto.setImageResource(arrayList.get(i).ProductPhoto);
        return view;
    }
}
