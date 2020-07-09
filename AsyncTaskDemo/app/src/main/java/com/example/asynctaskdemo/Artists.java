package com.example.asynctaskdemo;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class Artists extends Fragment
{
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_artists, container, false);
        recyclerView = view.findViewById(R.id.artistview);
        recyclerView.setLayoutManager( new LinearLayoutManager( getContext() ) );

        ArrayList<ArtistsData> artistsData = new ArrayList<>();
        Bundle bundle = this.getArguments();
        ArrayList<ArrayList<Items>> itemsList = new ArrayList<>();
        artistsData = (ArrayList<ArtistsData>) bundle.getSerializable("ArtistList");
        for( int i = 0; i < artistsData.size(); i++ )
        {
            ArrayList<Items> items = new ArrayList<>();
            Items item = new Items();
            ArtistsData artist = new ArtistsData();
            artist = artistsData.get(i);
            item.setmId(artist.getmId());
            item.setmName(artist.getmName());
            item.setmImage(artist.getmImage());
            System.out.println("artist Item = " + item.getmId() + "\t" + item.getmName() );
            items.add(item);
            itemsList.add(items);
        }

        myAdapter = new MyAdapter( getContext(), itemsList );
        recyclerView.setAdapter(myAdapter);
        return view;
    }
}
