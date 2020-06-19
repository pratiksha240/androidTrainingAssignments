package com.example.listviewdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ListviewFragment extends Fragment {

    MyAdapter myAdapter;
    ListView listView;
    ArrayList<String> countryList = new ArrayList<String>();

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        View v = inflater.inflate(R.layout.fragment_listview, container, false);

        listView = (ListView) v.findViewById(R.id.listview);
        countryList.add("India");
        countryList.add("USA");
        countryList.add("Japan");
        myAdapter = new MyAdapter(countryList, v);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String item = countryList.get(position);
                System.out.println("Clicked on item " + item );
            }
        });
        return v;
    }
}
