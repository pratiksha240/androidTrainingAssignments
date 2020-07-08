package com.example.asynctaskdemo;

public class Items
{
    private int mId;
    private String mName;
    private String mImage;

    public int getmId()
    {
        return mId;
    }

    public void setmId(int mId)
    {
        this.mId = mId;
    }

    public String getmName()
    {
        return mName;
    }

    public void setmName(String mName)
    {
        this.mName = mName;
    }

    public String getmImage()
    {
        return mImage;
    }

    public void setmImage(String mImage)
    {
        this.mImage = mImage;
    }

    public enum Type
    {
        ALBUMs,
        ARTISTS,
        TRACKS
    }
}
