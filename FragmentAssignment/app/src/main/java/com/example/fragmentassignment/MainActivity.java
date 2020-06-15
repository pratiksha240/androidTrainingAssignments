package com.example.fragmentassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.ActionBar;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.my_layout, new Frag1());
        ft.addToBackStack(null);
        ft.commit();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        //.setTitle("Back");
    }
    @Override
    public boolean onSupportNavigateUp()
    {
        getSupportFragmentManager().popBackStack();
//        finish();
        return true;
    }
}
