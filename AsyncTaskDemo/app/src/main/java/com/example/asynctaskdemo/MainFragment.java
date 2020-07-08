package com.example.asynctaskdemo;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;

public class MainFragment extends Fragment
{
    MyAdapter myAdapter;
    ArrayList<AlbumsData> albumsData = new ArrayList<>();
    ArrayList<ArtistsData> artistsData = new ArrayList<>();
    ArrayList<TracksData> tracksData = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        RecyclerView  recyclerView = view.findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        System.out.println("Before AsyncTask class...!!");
        loadDataFromUrl datalist = new loadDataFromUrl();

        datalist.execute();
        System.out.println("After AsyncTask call..!!");

//        dataList = datalist.getParseDataList();
//        loadDataFromUrl(url);
//        myAdapter = new MyAdapter(getContext(), parseDataList);
//        recyclerView.setAdapter(myAdapter);
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
            return "Success";
        }
    }
}
