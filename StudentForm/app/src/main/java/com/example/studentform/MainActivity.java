package com.example.studentform;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;

import static java.lang.System.*;

public class MainActivity extends AppCompatActivity
{
    BroadcastReceiver br = new BroadcastReceiver()
    {
        @Override
        public void onReceive( Context context, Intent intent )
        {
            String data =  intent.getAction();
            System.out.println("Data = " + data);
            StudentDetails fragment2 = new StudentDetails();
            Bundle bundle = intent.getExtras();
            fragment2.setArguments(bundle);
            studentDetails(fragment2);
        }
    };
    LocalBroadcastManager localBroadcastManager;

    @Override
    protected void onCreate( Bundle savedInstanceState )
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        fillForm();

        IntentFilter filter = new IntentFilter();
        filter.addAction("CUSTOM_SHOW_DETAILS");
        localBroadcastManager.registerReceiver(br, filter);
    }

    public void fillForm()
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frag_layout, new FillForm(), "Form Fragment");
        ft.commit();
    }

    public void studentDetails( StudentDetails fragment2 )
    {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.frag_layout, fragment2, "Student Details Fragment");
        ft.commit();
    }

    @Override
    protected void onDestroy()
    {
        super.onDestroy();
        localBroadcastManager.unregisterReceiver(br);
    }
}
