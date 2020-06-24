package com.example.livedatademo;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class LiveDataViewModel extends ViewModel
{
    private MutableLiveData<String> text = new MutableLiveData<String>();

    public MutableLiveData<String> getEnteredText()
    {
        return text;
    }

    public void setEntededText(String text)
    {
        this.text.setValue(text);
    }
}
