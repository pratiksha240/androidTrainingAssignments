package com.example.mvpdemo;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;

import java.util.ArrayList;

public class MainFragment extends Fragment implements MvpPictureDemo.View
{
    GridView gridView;
    MyAdapter myAdapter;

    MvpPictureDemo.Presenter presenter;

    @Override
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState )
    {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        gridView = view.findViewById(R.id.gridview);
        presenter = new MvpActivityPresenter( this, getContext() );
        presenter.getDataFromUrl();

        return view;
    }


    @Override
    public void setGridview( ArrayList<ImageData> mImageData, Context mContext )
    {
//        for ( int i = 0; i < mImageData.size(); i++ )
//        {
//            ImageData imageData = mImageData.get(i);
//            Log.d("DEBUG", "MainFrag Parse Id = " + imageData.getmId());
//            Log.d("DEBUG", "MainFrag Author = " + imageData.getmAuthor());
//        }
        if( mContext != null )
        {
            Log.d("DEBUG","Not Null context object..!!");
            myAdapter = new MyAdapter( mImageData, mContext );
            gridView.setAdapter(myAdapter);
        }
        else
        {
            Log.d("DEBUG","Null context object..!!");
        }
    }
}
