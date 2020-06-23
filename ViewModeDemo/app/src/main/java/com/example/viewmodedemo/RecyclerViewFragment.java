package com.example.viewmodedemo;

import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class RecyclerViewFragment extends Fragment
{
    private RecyclerViewViewModel mViewModel;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.recycler_view_fragment, container, false);
        String[] country = {"India","USA","Japan","Brazil","Russia","Germany","France","China","Mexico","Nepal","Pakistan","Canada"};
        if( getActivity() != null )
        {
            mViewModel = new ViewModelProvider(getActivity()).get(RecyclerViewViewModel.class);
            if( mViewModel != null )
            {
                mViewModel.setValues(country);
                String[] countries = mViewModel.getValues();
                RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleview);
                if ( recyclerView != null && countries != null ) {
                    MyAdapter myRecycleviewAdapter = new MyAdapter(countries);
                    recyclerView.setAdapter(myRecycleviewAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                }
            }
        }
        return view;
    }
}
