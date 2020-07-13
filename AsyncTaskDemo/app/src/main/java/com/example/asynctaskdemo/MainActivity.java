package com.example.asynctaskdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity
{
    FragmentManager fm = getSupportFragmentManager();
    LocalBroadcastManager localBroadcastManager;

    BroadcastReceiver br = new BroadcastReceiver()
    {
        @Override
        public void onReceive(Context context, Intent intent)
        {
            String data = intent.getAction();
            System.out.println("Data = " + data);
            switch(data)
            {
                case "ALBUM_PAGE":
                {
                    Albums albums = new Albums();
                    albumPage( albums, fm, intent );
                    break;
                }
                case "ARTIST_PAGE":
                {
                    Artists artists = new Artists();
                    artistPage( artists, fm, intent );
                    break;
                }
                case "TRACK_PAGE":
                {
                    Tracks tracks = new Tracks();
                    trackPage( tracks, fm, intent );
                    break;
                }
                default:
                {
                    Log.d("DEBUG","Invalid Flag..!!");
                    break;
                }
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        localBroadcastManager = LocalBroadcastManager.getInstance(this);

        IntentFilter filter = new IntentFilter();
        filter.addAction("MAIN_PAGE");
        filter.addAction("ALBUM_PAGE");
        filter.addAction("ARTIST_PAGE");
        filter.addAction("TRACK_PAGE");

        localBroadcastManager.registerReceiver(br, filter);
        if( savedInstanceState == null)
        {
            frontPage();
        }
    }

    @Override
    public boolean onSupportNavigateUp()
    {
        if (fm.getBackStackEntryCount() > 0)
        {
            fm.popBackStack();
            return true;
        }
        else
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
        }
        return false;
    }

    private void frontPage()
    {
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.frag_layout, new MainFragment(), "Main Fragment");
        ft.commit();
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);
    }

    private void albumPage(Albums albums, FragmentManager fragmentManager, Intent intent)
    {
        Bundle bundle = intent.getExtras();
        albums.setArguments(bundle);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frag_layout, albums, "Album Page");
        ft.addToBackStack(null);
        ft.commit();
        System.out.println("Album page..!!");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void artistPage( Artists artists, FragmentManager fragmentManager, Intent intent)
    {
        Bundle bundle = intent.getExtras();
        artists.setArguments(bundle);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frag_layout, artists, "Artist Page");
        ft.addToBackStack(null);
        ft.commit();
        System.out.println("Artist page..!!");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    private void trackPage(Tracks tracks, FragmentManager fragmentManager, Intent intent)
    {
        Bundle bundle = intent.getExtras();
        tracks.setArguments(bundle);
        FragmentTransaction ft = fragmentManager.beginTransaction();
        ft.replace(R.id.frag_layout, tracks, "Track Page");
        ft.addToBackStack(null);
        ft.commit();
        System.out.println("Track page..!!");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }
}
