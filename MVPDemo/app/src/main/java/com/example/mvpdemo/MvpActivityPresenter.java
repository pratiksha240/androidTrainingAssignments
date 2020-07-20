package com.example.mvpdemo;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;

import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class MvpActivityPresenter implements MvpPictureDemo.Presenter
{
    MvpPictureDemo.Model model = new MvpActivityModel();
    String mResponse = "";
    ArrayList<ImageData> mImageData = new ArrayList<>();
    MvpPictureDemo.View view;
    String mResult;
    Context context;

    public MvpActivityPresenter( MvpPictureDemo.View view, Context context )
    {
        this.view = view;
        this.context = context;
    }

    @Override
    public void getDataFromUrl()
    {
        LoadDataFromUrl loadDataFromUrl = new LoadDataFromUrl();
        loadDataFromUrl.execute("https://picsum.photos/list");
    }

    public class LoadDataFromUrl extends AsyncTask<String, String, String>
    {
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
                Log.d("DEBUG", "Response = " + mResponse );

                mImageData = model.parseImageData(mResponse);

            }
            catch (MalformedURLException e)
            {
                e.printStackTrace();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
            catch (JSONException e)
            {
                e.printStackTrace();
            }

            return mResult;
        }

        @Override
        protected void onPostExecute(String s)
        {
            Log.d("DEBUG", "Setting Adapter..!!" );
            for ( int i = 0; i < mImageData.size(); i++ )
            {
                ImageData imageData = mImageData.get(i);
                Log.d("DEBUG", "After Parse Id = " + imageData.getmId());
                Log.d("DEBUG", "After Parse Author = " + imageData.getmAuthor());
            }
            view.setGridview( mImageData,context );
            Log.d("DEBUG", "Ended onPostExecute..!!");
        }
    }
}
