package com.example.roomdatabasedemo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class UpdatePage extends Fragment
{
    TextView mEmployeeId;
    EditText mEmployeeName, mDesignation;
    String mId, mName, mDesig;
    Button update;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_update_page, container, false);
        mEmployeeId = view.findViewById(R.id.textView8);
        mEmployeeName = view.findViewById(R.id.editText4);
        mDesignation = view.findViewById(R.id.editText5);
        update = view.findViewById(R.id.button5);

        Bundle bundle = this.getArguments();
        mId = bundle.getString("eid");
        mName = bundle.getString("ename");
        mDesig = bundle.getString("edesig");

        mEmployeeId.setText( mId );
        mEmployeeName.setText( mName );
        mDesignation.setText( mDesig );

        updateData();
        return view;
    }

    public void updateData()
    {
        update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                EmployeeEntity employee = new EmployeeEntity();
                employee.setEid(Integer.parseInt(mEmployeeId.getText().toString()));
                employee.setEname(mEmployeeName.getText().toString());
                employee.setEdesig(mDesignation.getText().toString());

                MainActivity.myDatabase.myDao().updateEmployee(employee);
                Toast.makeText(getContext(), "Data Updated", Toast.LENGTH_LONG).show();

                Intent intent = new Intent();
                intent.setAction("FIRST_PAGE");
                LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
            }
        });
    }
}
