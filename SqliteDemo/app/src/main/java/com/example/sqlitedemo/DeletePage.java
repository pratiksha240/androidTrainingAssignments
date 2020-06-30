package com.example.sqlitedemo;

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
    MySqlHelper mySqlHelper;
    Button update, delete;
    TextView mEmployeeId, mEmployeeName, mDesignation;
    String mId, mName, mDesig;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_delete_page, container, false);

        mySqlHelper = new MySqlHelper (getContext(), null, null, 1);
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

        updateData();
        deleteData();

        return view;
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

    public void deleteData()
    {
        delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Integer deletedRows = mySqlHelper.deleteData(mEmployeeId.getText().toString());
                if( deletedRows > 0 )
                    Toast.makeText(getContext(), "Data Deleted..!!!" , Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(getContext(), "No id Found..!!!" , Toast.LENGTH_LONG).show();
                Intent intent = new Intent();
                intent.setAction("FIRST_PAGE");
                LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
            }
        });
    }
}
