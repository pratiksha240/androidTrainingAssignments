package com.example.mvpdemo;

import android.os.AsyncTask;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class MainFragment extends Fragment
{
    GridView gridView;
    ArrayList<ImageData> mImageData = new ArrayList<>();
    MyAdapter myAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        gridView = view.findViewById(R.id.gridview);

        Log.d("DEBUG","Before AsyncTask class...!!");
        loadDataFromUrl datalist = new loadDataFromUrl();

        datalist.execute("https://picsum.photos/list");
        Log.d("DEBUG","After AsyncTask call..!!");

        return view;
    }

    private class loadDataFromUrl extends AsyncTask<String, String, String>
    {
        String mResult;
        String mResponse = "";
        @Override
        protected String doInBackground(String... strings)
        {
            try
            {
                HttpURLConnection urlConnection = null;
                URL url = new URL(strings[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.connect();
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

                String line;
                while ((line = br.readLine()) != null)
                {
                    mResponse = mResponse + line;
                }

//                InputStream stream = getContext().getAssets().open("PictureData.json");
//                Log.d("DEBUG","After getAsset() call..!!");
//                BufferedReader reader = new BufferedReader(new InputStreamReader(stream));
//                Log.d("DEBUG","created bufferedReader object..!!");
//                String line;
//                while ((line = reader.readLine()) != null)
//                {
//                    mResponse = mResponse + line;
//                }
                Log.d("DEBUG", "Response = " + mResponse );

                JsonParser jsonParser = new JsonParser();
                mImageData = jsonParser.parseImageData(mResponse);
            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            } catch (JSONException e)
            {
                e.printStackTrace();
            }
            catch (URISyntaxException e)
            {
                e.printStackTrace();
            }

            return mResult;
        }

        @Override
        protected void onPostExecute(String s)
        {
            super.onPostExecute(s);

            Log.d("DEBUG", "Setting Adapter..!!" );
            myAdapter = new MyAdapter( mImageData, getContext() );
            gridView.setAdapter(myAdapter);
            Log.d("DEBUG", "Ended onPostExecute..!!");
        }
    }
}
