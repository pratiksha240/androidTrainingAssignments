package com.example.listviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter
{
    ArrayList<String> countryList;
    View view;
    MyAdapter(ArrayList<String> objects , View v)
    {
        countryList = (ArrayList<String>)objects.clone();
        view = v;
    }

    @Override
    public int getCount()
    {
        return countryList.size();
    }

    @Override
    public Object getItem(int position)
    {
        return countryList.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = LayoutInflater.from(view.getContext()).inflate(R.layout.listview_item_layout, null);
        TextView textView = v.findViewById(R.id.textview);
        textView.setText(countryList.get(position));
        return v;
    }
}
