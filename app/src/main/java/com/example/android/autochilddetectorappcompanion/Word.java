package com.example.android.autochilddetectorappcompanion;

/**
 * Created by ujigt on 2/8/2017.
 */

public class Word {

    private String mTitleName;
    private String mDesName;
    private int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1;

    public Word(String titleName, String desName)
    {
        mTitleName = titleName;
        mDesName = desName;
    }

    public Word(String titleName, String desName, int imageResourceId)
    {
        mTitleName = titleName;
        mDesName = desName;
        mImageResourceId = imageResourceId;

    }

    public String getTitleName()
    {
        return mTitleName;
    }

    public String getDesName()
    {
        return mDesName;
    }

    public int getImageResourceId()
    {
        return mImageResourceId;
    }

    public boolean hasImage()
    {
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }
}
