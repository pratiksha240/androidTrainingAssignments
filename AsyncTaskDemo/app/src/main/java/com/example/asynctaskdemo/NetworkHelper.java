package com.example.asynctaskdemo;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class NetworkHelper
{
    public static String getAlbumAssetJsonData(Context context)
    {
        String response = "";
        try
        {
            InputStream stream = context.getAssets().open("AlbumResponse.json");
            Log.d("DEBUG","After getAsset() call..!!");
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            Log.d("DEBUG","created bufferedReader object..!!");
            String line;
            while ((line = reader.readLine()) != null)
            {
                response = response + line;
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        Log.e("data", response);
        return response;
    }

    public static String getArtistsAssetJsonData(Context context)
    {
        String response = "";
        try
        {
            InputStream stream = context.getAssets().open("ArtistsResponse.json");
            Log.d("DEBUG","After getAsset() call..!!");
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            Log.d("DEBUG","created bufferedReader object..!!");
            String line;
            while ((line = reader.readLine()) != null)
            {
                response = response + line;
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        Log.e("data", response);
        return response;
    }

    public static String getTracksAssetJsonData(Context context)
    {
        String response = "";
        try
        {
            InputStream stream = context.getAssets().open("TracksResponse.json");
            Log.d("DEBUG","After getAsset() call..!!");
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
            Log.d("DEBUG","created bufferedReader object..!!");
            String line;
            while ((line = reader.readLine()) != null)
            {
                response = response + line;
            }
        }
        catch ( IOException e )
        {
            e.printStackTrace();
        }
        Log.e("data", response);
        return response;
    }
//    static String getResponseFromUrl( String urlQuery )
//    {
//        String response = "";
//        try
//        {
//            URL url = new URL("https://picsum.photos/list");
//            Log.d("DEBUG","set url");
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setConnectTimeout(10000);
//            connection.setReadTimeout(10000);
//            Log.d("DEBUG","Before connect..!!");
//            connection.connect();
//            Log.d("DEBUG","After connection..!!");

//            InputStream stream = context.getAssets().open("AlbumResponse.json");
//            Log.d("DEBUG","After getAsset() call..!!");
//            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
//            Log.d("DEBUG","created bufferedReader object..!!");
//            String line;

//            while ((line = reader.readLine()) != null) {
//                response = response + line;
//            }
//        }
//        catch (MalformedURLException e) {
//            e.printStackTrace();
//        } catch (IOException e)
//        {
//            e.printStackTrace();
//        }
//        return response;
//    }
}
