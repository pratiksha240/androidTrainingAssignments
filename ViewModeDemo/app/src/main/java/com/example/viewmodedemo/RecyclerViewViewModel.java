package com.example.viewmodedemo;

import androidx.lifecycle.ViewModel;

public class RecyclerViewViewModel extends ViewModel
{
    String[] country;
    public void setValues(String[] country)
    {
        if( country != null )
        {
            this.country = country;
        }
        else{
            System.out.println("\nNull object..!!");
        }
    }
    public String[] getValues()
    {
        return country;
    }
}
