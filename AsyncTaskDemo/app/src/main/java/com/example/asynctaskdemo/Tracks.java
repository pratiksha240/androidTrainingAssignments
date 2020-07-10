package com.example.asynctaskdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.ContextThemeWrapper;
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
        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.MyTheme);
        inflater = getActivity().getLayoutInflater().cloneInContext(contextThemeWrapper);
        View view = inflater.inflate(R.layout.fragment_tracks, container, false);
        recyclerView = view.findViewById(R.id.trackview);
        recyclerView.setLayoutManager( new LinearLayoutManager( getContext() ) );

        ArrayList<TracksData> tracksData = new ArrayList<>();
        Bundle bundle = this.getArguments();
        ArrayList<Items> itemsList = new ArrayList<>();
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
            item.setmSubtitle(track.getmArtistName());
            item.setmLayoutType(Items.LayoutType.TRACK);
            System.out.println("track Item = " + item.getmId() + "\t" + item.getmName() );
            itemsList.add(item);
        }

        myAdapter = new MyAdapter( getContext(), itemsList );
        recyclerView.setAdapter(myAdapter);
        return view;
    }
}
