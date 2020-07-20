package com.example.mvpdemo;

import android.content.Context;

import org.json.JSONException;

import java.util.ArrayList;

public interface MvpPictureDemo
{
    interface View
    {
        void setGridview( ArrayList<ImageData> imageData, Context context );
    }

    interface Presenter
    {
        void getDataFromUrl();
    }

    interface Model
    {
        ArrayList<ImageData> parseImageData( String response ) throws JSONException;
    }
}
