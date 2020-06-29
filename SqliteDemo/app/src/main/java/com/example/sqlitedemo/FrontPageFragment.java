package com.example.sqlitedemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class FrontPageFragment extends Fragment
{
    SQLiteDatabase db;
    EmployeeAdapter adapter;
    MySqlHelper mySqlHelper;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_front_page, container, false);
        Button button = view.findViewById(R.id.button);
        mySqlHelper = new MySqlHelper (getContext(), null, null, 1);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new EmployeeAdapter(getContext(), mySqlHelper.getAllItems());
        recyclerView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Intent intent = new Intent();
                intent.setAction("INSERT_DATA");
                LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
            }
        });
        return view;
    }
}
