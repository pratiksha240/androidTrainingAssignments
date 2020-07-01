package com.example.roomdatabasedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.room.Room;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

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
                case "INSERT_DATA":
                {
                    InsertPage insertPage = new InsertPage();
                    insertPage(insertPage, fm);
                    break;
                }
                case "FIRST_PAGE" :
                {
                    FirstPage firstPage = new FirstPage();
                    firstPage(firstPage, fm);
                    break;
                }
                case "DELETE_PAGE" :
                {
                    DeletePage deletePage = new DeletePage();
                    System.out.println("before call ..!!");
                    deletePage(deletePage, fm, intent);
                    System.out.println("after call ..!!");
                    break;
                }
                case "UPDATE_PAGE" :
                {
                    UpdatePage updatePage = new UpdatePage();
                    System.out.println("Update page call...!!");
                    updatePage(updatePage, fm, intent);
                    break;
                }
                default:
                {
                    System.out.println("Invalid Flag..!!");
                    break;
                }
            }
        }
    };

    LocalBroadcastManager localBroadcastManager;
    public static MyDatabase myDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDatabase = Room.databaseBuilder(getApplicationContext(), MyDatabase.class, "EmployeeDB").allowMainThreadQueries().build();
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        IntentFilter filter = new IntentFilter();
        filter.addAction("FIRST_PAGE");
        filter.addAction("INSERT_DATA");
        filter.addAction("UPDATE_PAGE");
        filter.addAction("DELETE_PAGE");

        localBroadcastManager.registerReceiver(br, filter);

        if( savedInstanceState == null)
        {
            frontPage();
        }
    }

    private void frontPage()
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frag_layout, new FirstPage(), "FirstPage");
        ft.commit();
    }

    private void updatePage(UpdatePage updatePage, FragmentManager fragmentManager, Intent intent)
    {
        Bundle bundle = intent.getExtras();
        updatePage.setArguments(bundle);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frag_layout, updatePage, "Update Page").commit();
        System.out.println("Update page..!!");
    }

    private void deletePage(DeletePage deletePage, FragmentManager fragmentManager, Intent intent)
    {
        Bundle bundle = intent.getExtras();
        deletePage.setArguments(bundle);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frag_layout, deletePage, "Delete Page").commit();
        System.out.println("Delete page..!!");
    }

    private void firstPage(FirstPage frag, FragmentManager fragmentManager)
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
}
