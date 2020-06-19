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

    public recylerviewFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recylerview, container, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(view.getContext()));
        String[] country = {"India","USA","Japan","Brazil","Russia","Germany","France","China","Mexico"};
//        recyclerView.setAdapter(new MyRecycleviewAdapter(country));
        return view;
    }
}
