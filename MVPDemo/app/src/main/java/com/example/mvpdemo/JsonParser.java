package com.example.mvpdemo;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;

public class JsonParser
{
    ArrayList<ImageData> mImageData = new ArrayList<>();
    public ArrayList<ImageData> parseImageData( String response ) throws JSONException, URISyntaxException
    {
        Log.d("DEBUG", "Called ImageData parser..!!");
//        JSONObject jObj = new JSONObject(response);
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
