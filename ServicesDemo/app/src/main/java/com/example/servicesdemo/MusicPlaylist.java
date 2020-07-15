package com.example.servicesdemo;

import android.Manifest;
import android.content.ContentResolver;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MusicPlaylist extends Fragment
{
    private static final int MY_PERMISSION_REQUEST = 1;
    ListView listView;
    ArrayList<AudioData> mAudioData = new ArrayList<>();
    ArrayList<String> arrayList;
    MyAdapter adapter;
    SongList songList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_music_playlist, container, false);
        songList = SongList.getInstance( getContext() );
        if(ContextCompat.checkSelfPermission( getContext(), Manifest.permission.READ_EXTERNAL_STORAGE ) != PackageManager.PERMISSION_GRANTED )
        {
            if(ActivityCompat.shouldShowRequestPermissionRationale( getActivity(), Manifest.permission.READ_EXTERNAL_STORAGE ) )
            {
                ActivityCompat.requestPermissions(getActivity(),
                            new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST);
            }
            else
            {
                ActivityCompat.requestPermissions(getActivity(),
                            new String[] {Manifest.permission.READ_EXTERNAL_STORAGE}, MY_PERMISSION_REQUEST);
            }
        }
        else
        {
            listView = view.findViewById(R.id.listview);
            arrayList = new ArrayList<>();
            mAudioData = songList.getSongList();
            for( int i = 0; i < mAudioData.size(); i++ )
            {
                AudioData audioData = mAudioData.get(i);
                Log.d("DEBUG", "Fragment Title = " + audioData.getmTitle());
                Log.d("DEBUG", "Fragment Sub Title = " + audioData.getmArtist());
            }
            adapter = new MyAdapter( mAudioData, view );
            listView.setAdapter(adapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
            {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id)
                {
                    Toast.makeText( getContext(), "Item Seleceted..!!", Toast.LENGTH_LONG );
                    
                }
            });
        }
        return view;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults)
    {
        switch( requestCode )
        {
            case MY_PERMISSION_REQUEST :
            {
                if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED )
                {
                    if( ActivityCompat.checkSelfPermission(getContext(), Manifest.permission.READ_EXTERNAL_STORAGE ) == PackageManager.PERMISSION_GRANTED )
                    {
                        Toast.makeText(getContext(), "Permission Granted..!!", Toast.LENGTH_LONG ).show();
                        songList.getSongList();
                    }
                    else
                    {
                        Toast.makeText(getContext(), "Permission Denied..!!", Toast.LENGTH_LONG ).show();
                        getActivity().finish();
                    }
                }
            }
        }
    }
}
