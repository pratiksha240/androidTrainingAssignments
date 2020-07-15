package com.example.servicesdemo;

import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.Context;
import android.database.Cursor;
import android.media.MediaPlayer;
import android.net.Uri;
import android.provider.MediaStore;
import android.util.Log;

import java.util.ArrayList;

public class SongList
{
    private static SongList songList = new SongList();
    private static Context mContext;
    ArrayList<AudioData> mAudioData  = new ArrayList<>();

    public static SongList getInstance(Context context)
    {
        mContext = context;
        return songList;
    }

    public ArrayList<AudioData> getSongList()
    {
        ContentResolver contentResolver = mContext.getContentResolver();
        Uri uri = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
        Cursor songCursor = contentResolver.query( uri, null, null, null, null );

        if( songCursor != null && songCursor.moveToFirst() )
        {
            int mTitle = songCursor.getColumnIndex( MediaStore.Audio.Media.TITLE );
            int mArtist = songCursor.getColumnIndex( MediaStore.Audio.Media.ARTIST );
            int mAlbumId = songCursor.getColumnIndex( MediaStore.Audio.Media.ALBUM_ID );
            int mId = songCursor.getColumnIndex( MediaStore.Audio.Media._ID );

//            int mPath = songCursor.getColumnIndex(String.valueOf(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI));
            do
            {
                String mCurrentTitle = songCursor.getString(mTitle);
                String mCurrentArtist = songCursor.getString(mArtist);
                String mCurrentAlbumId = songCursor.getString(mAlbumId);
                long mCurrentSongId = songCursor.getLong(mId);
                Uri mAlbumArtUri = ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"),
                        Long.parseLong(mCurrentAlbumId));

                Log.d("DEBUG", "Id = " + mCurrentSongId );
                Log.d("DEBUG", "Title = " + mCurrentTitle );
                Log.d("DEBUG", "Artist = " + mCurrentArtist );
                Log.d("DEBUG", "Image uri index = " + mAlbumId );
                Log.d("DEBUG", "Image uri = " + mAlbumArtUri );

                AudioData audioData = new AudioData();
                audioData.setmTitle(mCurrentTitle);
                audioData.setmArtist(mCurrentArtist);
                audioData.setmPath(mAlbumArtUri);
                audioData.setmId(mCurrentSongId);
                mAudioData.add(audioData);
                //mTitles.add(mCurrentTitle + "\n" + mCurrentAlbum + "\n" + mCurrentArtist );
            }while( songCursor.moveToNext() );
        }
        return mAudioData;
    }

}
