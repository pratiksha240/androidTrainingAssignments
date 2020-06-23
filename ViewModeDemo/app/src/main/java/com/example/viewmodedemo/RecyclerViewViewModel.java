package com.example.viewmodedemo;

import androidx.lifecycle.ViewModel;

public class RecyclerViewViewModel extends ViewModel
{
    String[] country;
    public void setValues(String[] country)
    {
        this.country = country;
    }
    public String[] getValues()
    {
        return country;
    }
}
