package com.example.servicesdemo;

import android.net.Uri;

public class AudioData
{
    private Uri mPath;
    private Uri mTrackId;
    private String mTitle;
    private String mAlbum;
    private String mArtist;
    private long mId;

    public String getmAlbum()
    {
        return mAlbum;
    }

    public void setmAlbum(String mAlbum)
    {
        this.mAlbum = mAlbum;
    }

    public String getmArtist()
    {
        return mArtist;
    }

    public void setmArtist(String mArtist)
    {
        this.mArtist = mArtist;
    }

    public String getmTitle()
    {
        return mTitle;
    }

    public void setmTitle(String mTitle)
    {
        this.mTitle = mTitle;
    }

    public Uri getmPath()
    {
        return mPath;
    }

    public void setmPath(Uri mPath)
    {
        this.mPath = mPath;
    }

    public long getmId()
    {
        return mId;
    }

    public void setmId(long mId)
    {
        this.mId = mId;
    }

    public Uri getmTrackId()
    {
        return mTrackId;
    }

    public void setmTrackId(Uri mTrackId)
    {
        this.mTrackId = mTrackId;
    }
}
