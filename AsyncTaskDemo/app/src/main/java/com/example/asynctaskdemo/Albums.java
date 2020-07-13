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

public class Albums extends Fragment
{
    RecyclerView recyclerView;
    MyAdapter myAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
//        ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(getActivity(), R.style.MyTheme);
//        inflater = getActivity().getLayoutInflater().cloneInContext(contextThemeWrapper);
        View view = inflater.inflate(R.layout.fragment_albums, container, false);

        recyclerView = view.findViewById(R.id.albumview);
        recyclerView.setLayoutManager( new LinearLayoutManager( getContext() ) );

        ArrayList<AlbumsData> albumsData = new ArrayList<>();
        Bundle bundle = this.getArguments();
        ArrayList<Items> itemsList = new ArrayList<>();
        albumsData = (ArrayList<AlbumsData>) bundle.getSerializable("AlbumList");

        for( int i = 0; i < albumsData.size(); i++ )
        {
            Items item = new Items();
            AlbumsData album = new AlbumsData();
            album = albumsData.get(i);
            item.setmId(album.getmId());
            item.setmName(album.getmName());
            item.setmImage(album.getmImage());
            item.setmLayoutType(Items.LayoutType.ALBUM);
            System.out.println("album Item = " + item.getmId() + "\t" + item.getmName() );
            itemsList.add(item);
        }

        myAdapter = new MyAdapter( getContext(), itemsList );
        recyclerView.setAdapter(myAdapter);

        return view;
    }
}
