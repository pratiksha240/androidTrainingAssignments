package com.example.mvpdemo;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import org.json.JSONException;
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
                mImageData = model.parseImageData(strings[0]);
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
