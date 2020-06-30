package com.example.roomdatabasedemo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class FirstPage extends Fragment
{
    EmployeeAdapter adapter;
    Button insert;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_first_page, container, false);
        insert = view.findViewById(R.id.button);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        adapter = new EmployeeAdapter(getContext(), MainActivity.myDatabase.myDao().getEmployees());
        recyclerView.setAdapter(adapter);
        insertData();
        displayListview();
        return view;
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

    public void displayListview()
    {
        adapter.setOnItemClickListener(new EmployeeAdapter.onItemClickListener() {
            @Override
            public void onItemClick(int position) {
                List<EmployeeEntity> employees = MainActivity.myDatabase.myDao().getEmployees();
                EmployeeEntity employee = employees.get(position);

                System.out.println("In ItemClick listener..!!");
                int mId = employee.getEid();
                String mName = employee.getEname();
                String mDesig = employee.getEdesig();
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
        });
    }
}
