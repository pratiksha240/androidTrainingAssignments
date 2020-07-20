package com.example.mvpdemo;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetworkHelper
{
    String getResponseFromURL( String mUrl )
    {
        String mResponse = "";
        try
        {
            HttpURLConnection urlConnection = null;
            URL url = new URL(mUrl);
            urlConnection = (HttpURLConnection) url.openConnection();
            urlConnection.connect();
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            String line;
            while ((line = br.readLine()) != null)
            {
                mResponse = mResponse + line;
            }
        }
        catch (MalformedURLException e)
        {
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
        Log.d("DEBUG", "Response = " + mResponse );
        return mResponse;
    }
}
