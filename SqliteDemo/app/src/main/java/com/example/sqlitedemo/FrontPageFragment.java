package com.example.sqlitedemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class FrontPageFragment extends Fragment
{
    SQLiteDatabase db;
    EmployeeAdapter adapter;
    MySqlHelper mySqlHelper;
    Button insert;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             final ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_front_page, container, false);
        insert = view.findViewById(R.id.button);
        mySqlHelper = new MySqlHelper (getContext(), null, null, 1);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new EmployeeAdapter(getContext(), mySqlHelper.getAllItems());
        recyclerView.setAdapter(adapter);

        displayListview();
        insertData();
        return view;
    }

    public void displayListview()
    {
        adapter.setOnItemClickListener(new EmployeeAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                Cursor cursor = mySqlHelper.getAllItems();
                if(cursor.moveToPosition(position))
                {
                    System.out.println("In ItemClick listener..!!");
                    int mId = cursor.getInt(cursor.getColumnIndex("eid"));
                    String mName = cursor.getString(cursor.getColumnIndex("ename"));
                    String mDesig = cursor.getString(cursor.getColumnIndex("edesignation"));
                    System.out.println("Name = " + mName + "\nId = " + mId + "\nDesign = " + mDesig);

                    Bundle bundle = new Bundle();
                    bundle.putString("eid", String.valueOf(mId) );
                    bundle.putString("ename", mName );
                    bundle.putString("edesig", mDesig );

                    Intent intent = new Intent();
                    intent.setAction("DELETE_PAGE");
                    intent.putExtras(bundle);
                    LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
                }
            }
        });
    }
    public void insertData()
    {
        insert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setAction("INSERT_DATA");
                LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
            }
        });
    }
}
