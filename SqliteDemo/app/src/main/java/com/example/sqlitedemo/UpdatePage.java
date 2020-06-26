package com.example.sqlitedemo;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class UpdatePage extends Fragment
{
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_update_page, container, false);
        Button update = view.findViewById(R.id.button3);
        Button delete = view.findViewById(R.id.button4);
        update.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                changePage();
            }
        });
        delete.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                changePage();
            }
        });
        return view;
    }

    private void changePage()
    {
        Intent intent = new Intent();
        intent.setAction("FIRST_DATA");
        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
    }
}
