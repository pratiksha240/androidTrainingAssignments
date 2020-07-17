package com.example.mvpdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter
{
    ArrayList<ImageData> mImageData;
    Context mContext;
    public MyAdapter( ArrayList<ImageData> imageData, Context context )
    {
        mImageData = (ArrayList<ImageData>) imageData.clone();
        mContext = context;
    }

    @Override
    public int getCount()
    {
        return mImageData.size();
    }

    @Override
    public Object getItem(int position)
    {
        return null;
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View view = convertView;
        LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.items_layout, null);

        TextView mAuthor = view.findViewById(R.id.textView);
        ImageView mImage = view.findViewById(R.id.imageView);

        ImageData imageData = mImageData.get(position);
        mAuthor.setText(imageData.getmAuthor());
        Picasso.with(mContext).load(imageData.getmId()).into(mImage);
        return view;
    }
}
