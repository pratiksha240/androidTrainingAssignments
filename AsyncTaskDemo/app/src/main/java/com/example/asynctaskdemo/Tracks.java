package com.example.asynctaskdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Tracks extends Fragment
{
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_tracks, container, false);
        recyclerView = view.findViewById(R.id.trackview);
        recyclerView.setLayoutManager( new LinearLayoutManager( getContext() ) );

        ArrayList<TracksData> tracksData = new ArrayList<>();
        Bundle bundle = this.getArguments();
        ArrayList<ArrayList<Items>> itemsList = new ArrayList<>();
        tracksData = (ArrayList<TracksData>) bundle.getSerializable("TrackList");
        for( int i = 0; i < tracksData.size(); i++ )
        {
            ArrayList<Items> items = new ArrayList<>();
            Items item = new Items();
            TracksData track = new TracksData();
            track = tracksData.get(i);
            item.setmId(track.getmId());
            item.setmName(track.getmName());
            item.setmImage(track.getmImage());
            System.out.println("track Item = " + item.getmId() + "\t" + item.getmName() );
            items.add(item);
            itemsList.add(items);
        }

        myAdapter = new MyAdapter( getContext(), itemsList );
        recyclerView.setAdapter(myAdapter);
        return view;
    }
}
