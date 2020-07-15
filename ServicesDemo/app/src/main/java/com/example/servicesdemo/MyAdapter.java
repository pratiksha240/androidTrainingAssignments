package com.example.servicesdemo;

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
    ArrayList<AudioData> mAudioData;
    View view;
    public MyAdapter( ArrayList<AudioData> songList, View v )
    {
        mAudioData = (ArrayList<AudioData>) songList.clone();
        view = v;
    }

    @Override
    public int getCount()
    {
        return mAudioData.size();
    }

    @Override
    public Object getItem(int position)
    {
        return mAudioData.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        View v = LayoutInflater.from(view.getContext()).inflate(R.layout.items_layout, null);
        TextView mTitle = v.findViewById(R.id.textTitle);
        TextView mSubtitle = v.findViewById(R.id.textSubtitle);
        ImageView mAlbumArt = v.findViewById(R.id.imageView);
        AudioData audioData = mAudioData.get(position);
        mTitle.setText(audioData.getmTitle());
        mSubtitle.setText(audioData.getmArtist());
        Picasso.with(v.getContext()).load(audioData.getmPath()).into(mAlbumArt);
        return v;
    }
}
