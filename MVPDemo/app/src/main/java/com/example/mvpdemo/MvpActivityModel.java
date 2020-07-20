package com.example.mvpdemo;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MvpActivityModel implements MvpPictureDemo.Model
{
    @Override
    public ArrayList<ImageData> parseImageData( String url ) throws JSONException
    {
        NetworkHelper networkHelper = new NetworkHelper();
        String response = networkHelper.getResponseFromURL(url);
        ArrayList<ImageData> mImageData = new ArrayList<>();
        Log.d("DEBUG", "Called ImageData parser..!!");
        JSONArray jsonArray = new JSONArray(response);
        for ( int i = 0 ; i < jsonArray.length() ; i++ )
        {
            ImageData imageData = new ImageData();
            JSONObject object = jsonArray.getJSONObject(i);
            int mId = object.getInt("id");
            String mImageId = "https://picsum.photos/300/300?image=" + mId;
            imageData.setmId(mImageId);
            Log.d("DEBUG", "Id = " + mImageId);

            imageData.setmAuthor(object.getString("author"));
            Log.d("DEBUG", "Author = " + imageData.getmAuthor());
            mImageData.add(imageData);
        }
        Log.d("DEBUG","Response = " + response);
        return mImageData;
    }
}
