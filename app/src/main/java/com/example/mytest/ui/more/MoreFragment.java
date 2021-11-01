package com.example.mytest.ui.more;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.model.More;
import com.example.mytest.R;

import java.util.ArrayList;

import adapter.MoreAdapter;

public class MoreFragment extends Fragment {
    ListView lvMore;
    ArrayList<More> morelist;
    MoreAdapter moreAdapter;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_more, container, false);
        lvMore = view.findViewById(R.id.lvMore);
        morelist = new ArrayList<>();
        morelist.add(new More(R.drawable.account_icon,"My Account"));
        morelist.add(new More(R.drawable.mymess_icon,"My Message"));
        morelist.add(new More(R.drawable.delivery_icon,"Delivery"));
        morelist.add(new More(R.drawable.track_icon,"Track My Order"));
        morelist.add(new More(R.drawable.customerservice_icon,"Customer Service"));
        morelist.add(new More(R.drawable.myvoucher_icon,"My Voucher"));
        morelist.add(new More(R.drawable.language_icon,"Language"));

        moreAdapter = new MoreAdapter(getContext(),R.layout.more_item_layout,morelist);
        lvMore.setAdapter(moreAdapter);
        return view ;
    }
}
