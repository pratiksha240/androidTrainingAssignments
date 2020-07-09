package com.example.asynctaskdemo;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class JsonParser
{
    private static JsonParser instance = new JsonParser();

    public static JsonParser getInstance()
    {
        return instance;
    }

    public ArrayList<AlbumsData> parseAlbumData( String response ) throws JSONException
    {
        Log.d("DEBUG", "Called Album parser..!!");
        ArrayList<AlbumsData> albumData = new ArrayList<>();
        JSONObject jObj = new JSONObject(response);
        JSONArray jsonArray = jObj.getJSONArray("data");
        for ( int i = 0 ; i < jsonArray.length() ; i++ )
        {
            AlbumsData albumsData = new AlbumsData();
            JSONObject object = jsonArray.getJSONObject(i);
            albumsData.setmId(object.getInt("id"));
            Log.d("DEBUG", "AlbumName = " + object.getString("title"));
            albumsData.setmName(object.getString("title"));
            albumsData.setmImage(object.getString("cover_small"));
            Log.d("DEBUG", "Album Id = " + albumsData.getmId());
            Log.d("DEBUG", "Album name = " + albumsData.getmName());
//            System.out.println("AlbumId = " + ( albumData.get(i)).getmId());
            albumData.add(albumsData);
        }
        Log.d("DEBUG","Response = " + response);
        return albumData;
    }

    public ArrayList<ArtistsData> parseArtistsData( String response ) throws JSONException
    {
        ArrayList<ArtistsData> artistsData = new ArrayList<>();
        JSONObject jObj = new JSONObject(response);
        JSONArray jsonArray = jObj.getJSONArray("data");

        for ( int i = 0 ; i < jsonArray.length() ; i++ )
        {
            ArtistsData artistData = new ArtistsData();
            JSONObject object = jsonArray.getJSONObject(i);
            artistData.setmId(object.getInt("id"));
            artistData.setmName(object.getString("name"));
            artistData.setmImage(object.getString("picture_small"));
            Log.d("DEBUG", "Artist Id = " + artistData.getmId());
            Log.d("DEBUG", "Artist name = " + artistData.getmName());
            artistsData.add(artistData);
        }

        return artistsData;
    }

    public ArrayList<TracksData> parseTracksData( String response ) throws JSONException
    {
        ArrayList<TracksData> tracksData = new ArrayList<>();
        JSONObject jObj = new JSONObject(response);
        JSONArray jsonArray = jObj.getJSONArray("data");

        for ( int i = 0 ; i < jsonArray.length() ; i++ )
        {
            TracksData trackData = new TracksData();
            JSONObject object = jsonArray.getJSONObject(i);
            trackData.setmId(object.getInt("id"));
            trackData.setmName(object.getString("title"));
//            trackData.setmImage(object.getString("picture_small"));
            Log.d("DEBUG", "Track Id = " + trackData.getmId());
            Log.d("DEBUG", "Track name = " + trackData.getmName());
            tracksData.add(trackData);
        }

        return tracksData;
    }
}
