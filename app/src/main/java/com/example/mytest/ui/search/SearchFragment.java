package com.example.mytest.ui.search;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.model.GroupObject;
import com.example.model.ItemObject;
import com.example.mytest.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import adapter.ExpandableListViewAdapter;

public class SearchFragment extends Fragment {
    private ExpandableListView expandableListView;
    private List<GroupObject> mListGroup;
    private Map<GroupObject, List<ItemObject>> mListItem;
    private ExpandableListViewAdapter expandableListViewAdapter;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        linkView(view);
        loadData();
        return view ;
    }

    private void linkView(View view) {
        expandableListView = view.findViewById(R.id.elvOption);
    }

    private void loadData() {
        mListItem = getmListItem();
        mListGroup = new ArrayList<>(mListItem.keySet());

        expandableListViewAdapter = new ExpandableListViewAdapter(mListGroup, mListItem);
        expandableListView.setAdapter(expandableListViewAdapter);
    }
    private Map<GroupObject, List<ItemObject>> getmListItem(){
        Map<GroupObject, List<ItemObject>> listMap = new HashMap<>();

        GroupObject groupObject1 = new GroupObject(1, "Men");
        GroupObject groupObject2 = new GroupObject(2, "Women");
        GroupObject groupObject3 = new GroupObject(3, "Kids");
        GroupObject groupObject4 = new GroupObject(4, "Sports");
        GroupObject groupObject5 = new GroupObject(5, "Brands");


        List<ItemObject> objectList1 = new ArrayList<>();
        objectList1.add(new ItemObject(1, "Shop All"));
        objectList1.add(new ItemObject(2, "High Tops"));
        objectList1.add(new ItemObject(3, "Low Tops"));
        objectList1.add(new ItemObject(4, "Slip On"));

        List<ItemObject> objectList2 = new ArrayList<>();
        objectList2.add(new ItemObject(5, "Shop All"));
        objectList2.add(new ItemObject(6, "High Tops"));
        objectList2.add(new ItemObject(7, "Low Tops"));
        objectList2.add(new ItemObject(8, "Slip On"));

        List<ItemObject> objectList3 = new ArrayList<>();
        objectList3.add(new ItemObject(9, "Shop All"));
        objectList3.add(new ItemObject(10, "High Tops"));
        objectList3.add(new ItemObject(11, "Low Tops"));
        objectList3.add(new ItemObject(12, "Slip On"));

        List<ItemObject> objectList4 = new ArrayList<>();
        objectList4.add(new ItemObject(13, "Shop All Sports"));
        objectList4.add(new ItemObject(14, "Shop By Brand"));

        List<ItemObject> objectList5 = new ArrayList<>();
        objectList5.add(new ItemObject(15, "All Brands"));

        listMap.put(groupObject1, objectList1);
        listMap.put(groupObject2, objectList2);
        listMap.put(groupObject3, objectList3);
        listMap.put(groupObject4, objectList4);
        listMap.put(groupObject5, objectList5);


        return listMap;
    }

}