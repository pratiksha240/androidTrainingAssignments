package com.example.asynctaskdemo;

public class Items
{
    private int mId;
    private String mName;
    private String mImage;
    private Type mType;
    private String mSubtitle;
    private LayoutType mLayoutType;

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
        return "https://picsum.photos/300/300/?image=1008";
    }

    public void setmImage(String mImage)
    {
        this.mImage = mImage;
    }

    public Type getmType()
    {
        return mType;
    }

    public void setmType(Type mType)
    {
        this.mType = mType;
    }

    public LayoutType getmLayoutType()
    {
        return mLayoutType;
    }

    public void setmLayoutType(LayoutType mLayoutType)
    {
        this.mLayoutType = mLayoutType;
    }

    public String getmSubtitle() {
        return mSubtitle;
    }

    public void setmSubtitle(String mSubtitle) {
        this.mSubtitle = mSubtitle;
    }

    public enum Type
    {
        ALBUMS,
        ARTISTS,
        TRACKS,
    }

    public enum LayoutType
    {
        HEADER,
        ITEM,
        ALBUM,
        ARTIST,
        TRACK,
    }
}
