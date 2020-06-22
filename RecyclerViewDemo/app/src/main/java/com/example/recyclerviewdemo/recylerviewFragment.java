package com.example.recyclerviewdemo;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


/**
 * A simple {@link Fragment} subclass.
 */
public class recylerviewFragment extends Fragment {

    @Override
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_recylerview, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleview);
        String[] country = {"India","USA","Japan","Brazil","Russia","Germany","France","China","Mexico","Nepal","Pakistan","Canada"};
        MyRecycleviewAdapter myRecycleviewAdapter = new MyRecycleviewAdapter(country);
        recyclerView.setAdapter(myRecycleviewAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }
}
