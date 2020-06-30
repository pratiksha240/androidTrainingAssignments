package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class InsertPage extends Fragment
{
    Button insert;
    EditText eid, name, desig;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.fragment_insert_page, container, false);
        insert = view.findViewById(R.id.button2);
        eid = view.findViewById(R.id.editText);
        name = view.findViewById(R.id.editText2);
        desig = view.findViewById(R.id.editText3);
        insertData();
        return view;
    }

    public void insertData()
    {
        insert.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                MySqlHelper mySqlHelper = new MySqlHelper(getContext(),null,null,1);
                SQLiteDatabase db = mySqlHelper.getWritableDatabase();
                ContentValues values = new ContentValues();
                int empid = Integer.parseInt(eid.getText().toString());
                values.put( "eid", empid );
                values.put( "ename", name.getText().toString() );
                values.put( "edesignation", desig.getText().toString() );
                long row = db.insert("Employee", null, values );
                System.out.println("row value = " + row);

                Intent intent = new Intent();
                intent.setAction("FIRST_PAGE");
                LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
            }
        });
    }
}
