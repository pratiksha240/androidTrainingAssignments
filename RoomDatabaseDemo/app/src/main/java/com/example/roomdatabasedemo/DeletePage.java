package com.example.roomdatabasedemo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class DeletePage extends Fragment
{
    Button update, delete;
    TextView mEmployeeId, mEmployeeName, mDesignation;
    String mId, mName, mDesig;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_delete_page, container, false);
        update = view.findViewById(R.id.button3);
        delete = view.findViewById(R.id.button4);

        mEmployeeId = view.findViewById(R.id.textView15);
        mEmployeeName = view.findViewById(R.id.textView17);
        mDesignation = view.findViewById(R.id.textView19);

        Bundle bundle = this.getArguments();
        mId = bundle.getString("eid");
        mName = bundle.getString("ename");
        mDesig = bundle.getString("edesig");

        mEmployeeId.setText( mId );
        mEmployeeName.setText( mName );
        mDesignation.setText( mDesig );
        deleteData();
        updateData();
        return view;
    }

    public void deleteData()
    {
        delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EmployeeEntity employee = new EmployeeEntity();
                employee.setEid(Integer.parseInt(mId));
                employee.setEname(mName);
                employee.setEdesig(mDesig);
                MainActivity.myDatabase.myDao().deleteEmployee(employee);
                Toast.makeText(getContext(), "Data Deleted..!!!" , Toast.LENGTH_LONG).show();

                Intent intent = new Intent();
                intent.setAction("FIRST_PAGE");
                LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
            }
        });
    }

    public void updateData()
    {
        update.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle bundle = new Bundle();
                bundle.putString("eid", String.valueOf(mId) );
                bundle.putString("ename", mName );
                bundle.putString("edesig", mDesig );

                Intent intent = new Intent();
                intent.setAction("UPDATE_PAGE");
                intent.putExtras(bundle);
                LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
            }
        });
    }
}
