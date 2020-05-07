package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class FarmerList extends AppCompatActivity {

    DatabaseHelper dh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_list);


        ListView listView = (ListView) findViewById(R.id.listview);
        dh = new DatabaseHelper(this);
        ArrayList<String> items = new ArrayList<String>();
        Cursor data = dh.getAllData();

        if (data.getCount() == 0) {
            Toast.makeText(FarmerList.this, "Database was empty", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
                items.add("\n"+data.getString(1)+"\n"+data.getString(2)+" - "+data.getString(3)+"\n");
                ListAdapter ad = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, items);
                listView.setAdapter(ad);
            }
        }

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent int1 = new Intent(FarmerList.this, consumer.class);
                startActivity(int1);
            }
        });
    }
}
