package com.example.roomdatabasedemo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class InsertPage extends Fragment
{
    Button insert;
    EditText eid, name, desig;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_insert_page, container, false);

        insert = view.findViewById(R.id.button2);
        eid = view.findViewById(R.id.editText);
        name = view.findViewById(R.id.editText2);
        desig = view.findViewById(R.id.editText3);
        insertData();
        displayData();
        return view;
    }

    private void displayData()
    {
        List<EmployeeEntity> employees = MainActivity.myDatabase.myDao().getEmployees();

        for ( EmployeeEntity employee : employees )
        {
            int mId = employee.getEid();
            String mName = employee.getEname();
            String mDesignation = employee.getEdesig();

            EmployeeAdapter mAdapter = new EmployeeAdapter(getContext(), employees);
        }
    }

    private void insertData()
    {
        insert.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                int mId = Integer.parseInt(eid.getText().toString());
                String mName = name.getText().toString();
                String mDesignation = desig.getText().toString();

                EmployeeEntity values = new EmployeeEntity();
                values.setEid(mId);
                values.setEname(mName);
                values.setEdesig(mDesignation);

                MainActivity.myDatabase.myDao().addEmp(values);
                Toast.makeText(getContext(), "Record added..!!", Toast.LENGTH_LONG).show();

                Intent intent = new Intent();
                intent.setAction("FIRST_PAGE");
                LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
            }
        });
    }
}
