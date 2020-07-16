package com.example.servicesdemo;

import android.app.Service;
import android.content.ContentUris;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.IBinder;
import android.provider.MediaStore;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class MusicService extends Service
{
    Uri mTrackUri;
    MediaPlayer player;
    long mTrackId;
    @Nullable
    @Override
    public IBinder onBind(Intent intent)
    {
        Log.d("DEBUG","bind Successfully..!!");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId)
    {
        Log.d("DEBUG","Service Started Successfully..!!");
        Bundle bundle = intent.getExtras();
        if( player != null )
        {
            player.stop();
            Log.d("DEBUG","Stop previous song..!!" );
        }
        mTrackId = bundle.getLong("Id");
        mTrackUri = ContentUris.withAppendedId( MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, mTrackId );
        player = MediaPlayer.create( getApplicationContext(), mTrackUri );
        player.start();
        Log.d("DEBUG","Track Id = " + mTrackId );
        return flags;
    }

    @Override
    public void onDestroy()
    {
        if( player != null )
        {
            player.release();
        }
    }
}
