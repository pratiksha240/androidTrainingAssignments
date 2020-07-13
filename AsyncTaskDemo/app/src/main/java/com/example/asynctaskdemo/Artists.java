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

public class Artists extends Fragment
{
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
//        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.MyTheme);
//        inflater = getActivity().getLayoutInflater().cloneInContext(contextThemeWrapper);
        View view = inflater.inflate(R.layout.fragment_artists, container, false);
        recyclerView = view.findViewById(R.id.artistview);
        recyclerView.setLayoutManager( new LinearLayoutManager( getContext() ) );

        ArrayList<ArtistsData> artistsData = new ArrayList<>();
        Bundle bundle = this.getArguments();
        ArrayList<Items> itemsList = new ArrayList<>();
        artistsData = (ArrayList<ArtistsData>) bundle.getSerializable("ArtistList");

        for( int i = 0; i < artistsData.size(); i++ )
        {
            Items item = new Items();
            ArtistsData artist = new ArtistsData();
            artist = artistsData.get(i);
            item.setmId(artist.getmId());
            item.setmName(artist.getmName());
            item.setmImage(artist.getmImage());
            item.setmLayoutType(Items.LayoutType.ARTIST);
            System.out.println("artist Item = " + item.getmId() + "\t" + item.getmName() );
            itemsList.add(item);
        }

        myAdapter = new MyAdapter( getContext(), itemsList );
        recyclerView.setAdapter(myAdapter);
        return view;
    }
}
