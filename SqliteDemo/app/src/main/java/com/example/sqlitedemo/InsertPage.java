package com.example.sqlitedemo;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class InsertPage extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_insert_page, container, false);
        final Button btn = view.findViewById(R.id.button2);
        final EditText eid = view.findViewById(R.id.editText);
        final EditText name = view.findViewById(R.id.editText2);
        final EditText desig = view.findViewById(R.id.editText3);
        btn.setOnClickListener(new View.OnClickListener()
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
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.replace(R.id.frag_layout, new FrontPageFragment(), "First Page");
                ft.commit();
            }
        });
        return view;
    }
}
