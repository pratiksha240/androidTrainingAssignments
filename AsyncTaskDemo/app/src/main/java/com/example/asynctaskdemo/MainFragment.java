package com.example.asynctaskdemo;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import org.json.JSONException;

import java.util.ArrayList;

public class MainFragment extends Fragment
{
    MyAdapter myAdapter;
    static ArrayList<AlbumsData> albumsData = new ArrayList<>();
    static ArrayList<ArtistsData> artistsData = new ArrayList<>();
    static ArrayList<TracksData> tracksData = new ArrayList<>();
    static ArrayList<Items> itemsList = new ArrayList<>();
    String result;
    public RecyclerView  recyclerView;
    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        Log.d("DEBUG","Before AsyncTask class...!!");
        loadDataFromUrl datalist = new loadDataFromUrl();

        datalist.execute();
        Log.d("DEBUG","After AsyncTask call..!!");

        return view;
    }

    private class loadDataFromUrl extends AsyncTask<String, String, String>
    {
        @Override
        protected String doInBackground(String... strings)
        {
            try
            {
                Log.d("DEBUG","In AsyncTask class..!!");

                NetworkHelper networkHelper = new NetworkHelper();
                JsonParser parser = JsonParser.getInstance();
                albumsData = parser.parseAlbumData(networkHelper.getAlbumAssetJsonData(getContext()));
                artistsData = parser.parseArtistsData(networkHelper.getArtistsAssetJsonData(getContext()));
                tracksData = parser.parseTracksData(networkHelper.getTracksAssetJsonData(getContext()));
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }
            result = "Success";
            return result;
        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);
            itemsList = getItemsList();
            for( int i = 0; i < itemsList.size(); i++ )
            {
                Items item = new Items();
                item = itemsList.get(i);
                System.out.println("ItemList = " + item.getmId() + "\t" + item.getmName() + "\t" + item.getmType());
            }
            Log.d("DEBUG", "Setting Adapter..!!" );
            myAdapter = new MyAdapter(getContext(), itemsList);
            recyclerView.setAdapter(myAdapter);
            displayListview();
            Log.d("DEBUG", "Ended onPostExecute..!!");
        }
    }

    private ArrayList<Items> getItemsList()
    {
        ArrayList<Items> items = new ArrayList<>();
        Items albums = new Items();
        albums.setmType(Items.Type.ALBUMS);
        albums.setmLayoutType(Items.LayoutType.HEADER);
        items.add(albums);
        for( int i = 0; i < 3; i++ )
        {
            Items item = new Items();
            AlbumsData album;
            album = albumsData.get(i);
            item.setmId(album.getmId());
            item.setmName(album.getmName());
            item.setmImage(album.getmImage());
            item.setmLayoutType(Items.LayoutType.ALBUM);
            System.out.println("Album Item = " + item.getmId() + "\t" + item.getmName() + "\t" + item.getmType());
            items.add(item);
        }
        Items artists = new Items();
        artists.setmType(Items.Type.ARTISTS);
        artists.setmLayoutType(Items.LayoutType.HEADER);
        items.add(artists);
        for( int i = 0; i < 3; i++ )
        {
            Items item = new Items();
            ArtistsData artist = new ArtistsData();
            artist = artistsData.get(i);
            item.setmId(artist.getmId());
            item.setmName(artist.getmName());
            item.setmImage(artist.getmImage());
            item.setmLayoutType(Items.LayoutType.ARTIST);
            System.out.println("Artist Item = " + item.getmId() + "\t" + item.getmName() + "\t" + item.getmType());
            items.add(item);
        }
        Items tracks = new Items();
        tracks.setmType(Items.Type.TRACKS);
        tracks.setmLayoutType(Items.LayoutType.HEADER);
        items.add(tracks);
        for( int i = 0; i < 3; i++ )
        {
            Items item = new Items();
            TracksData track = new TracksData();
            track = tracksData.get(i);
            item.setmId(track.getmId());
            item.setmName(track.getmName());
            item.setmImage(track.getmImage());
            item.setmSubtitle(track.getmArtistName());
            item.setmLayoutType(Items.LayoutType.TRACK);
            System.out.println("Track Item = " + item.getmId() + "\t" + item.getmName() + "\t" + item.getmType());
            items.add(item);
        }
        return items;
    }

    public void displayListview()
    {
        myAdapter.setOnItemClickListener(new MyAdapter.onItemClickListener()
        {
            @Override
            public void onItemClick(int position)
            {
                if( myAdapter.getItemViewType(position) == 0 )
                {
                    String mType = myAdapter.getType(position);
                    Log.d("DEBUG", "Type is = " + mType);
                    if (mType.equals("ALBUMS"))
                    {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("AlbumList", albumsData);
                        Intent intent = new Intent();
                        intent.setAction("ALBUM_PAGE");
                        intent.putExtras(bundle);
                        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
                    }
                    else if (mType.equals("ARTISTS"))
                    {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("ArtistList", artistsData);
                        Intent intent = new Intent();
                        intent.setAction("ARTIST_PAGE");
                        intent.putExtras(bundle);
                        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
                    } else if (mType.equals("TRACKS")) {
                        Bundle bundle = new Bundle();
                        bundle.putSerializable("TrackList", tracksData);
                        Intent intent = new Intent();
                        intent.setAction("TRACK_PAGE");
                        intent.putExtras(bundle);
                        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
                    }
                }
                else if( myAdapter.getItemViewType(position) == 1 )
                {
                    Toast.makeText(getContext(), "item Selected..!! ", Toast.LENGTH_LONG);
                }
            }
        });
    }
}
