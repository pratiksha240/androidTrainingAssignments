package com.example.listviewdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.widget.Toast.*;

public class MainActivity extends AppCompatActivity
{
    ListView listView;
    MyAdapter myAdapter;
    ArrayList<String> countryList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listview);
        countryList.add("India");
        countryList.add("USA");
        countryList.add("Japan");

        myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id)
            {
                String item = countryList.get(position);
//                String item = parent.getItemAtPosition(position).toString();
////                Toast.makeText(this, parent.getItemAtPosition(position).toString(), Toast.LENGTH_LONG).show();
                System.out.println("Clicked on item " + item );
            }
        });
    }
    class MyAdapter extends BaseAdapter
    {
        @Override
        public int getCount() {
            return countryList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent)
        {
            View v = LayoutInflater.from(getApplicationContext()).inflate(R.layout.listview_item_layout, null);
            TextView textView = v.findViewById(R.id.textview);
            textView.setText(countryList.get(position));
            return v;
        }
    }
}
