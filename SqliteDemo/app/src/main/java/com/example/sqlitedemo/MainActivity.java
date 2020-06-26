package com.example.sqlitedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity
{
    FragmentManager fm = getSupportFragmentManager();
    final BroadcastReceiver br = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            String data = intent.getAction();
            System.out.println("Data = " + data);
            switch(data)
            {
                case "INSERT_DATA": InsertPage insertPage = new InsertPage();
                                    insertPage(insertPage, fm);
                                    break;
                case "FIRST_PAGE" : FrontPageFragment frontPage = new FrontPageFragment();
                                    firstPage(frontPage, fm);
                                    break;
                case "UPDATE_PAGE" : UpdatePage updatePage = new UpdatePage();
                                    updatePage(updatePage, fm);
                                    break;
            }
        }
    };

    LocalBroadcastManager localBroadcastManager;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        IntentFilter filter = new IntentFilter();
        filter.addAction("FIRST_PAGE");
        filter.addAction("INSERT_DATA");
        filter.addAction("UPDATE_DATA");
        filter.addAction("DELETE_DATA");

        localBroadcastManager.registerReceiver(br, filter);

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frag_layout, new FrontPageFragment(), "FirstPage");
        ft.commit();
    }

    private void firstPage(FrontPageFragment frag, FragmentManager fragmentManager)
    {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frag_layout, frag, "First Page").commit();
        System.out.println("First page..!!");
    }

    private void insertPage(InsertPage frag, FragmentManager fragmentManager)
    {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frag_layout, frag, "Insert Page").commit();
        System.out.println("Insert page..!!");
    }

    private void updatePage(UpdatePage updatePage, FragmentManager fragmentManager)
    {
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frag_layout, updatePage, "Update Page").commit();
        System.out.println("Update page..!!");
    }
}
