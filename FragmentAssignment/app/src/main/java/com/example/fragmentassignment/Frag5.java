package com.example.fragmentassignment;

import android.app.ActionBar;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


/**
 * A simple {@link Fragment} subclass.
 */
public class Frag5 extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.fragment_frag5, container, false);
        Button next = (Button) view.findViewById(R.id.button4);
        Button previous = (Button) view.findViewById(R.id.button7);
        next.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.my_layout, new Frag2());
                ft.addToBackStack("Fragment 2");
                ft.commit();
            }
        });

        previous.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.my_layout, new Frag4());
                ft.addToBackStack("Fragment 5");
                ft.commit();
            }
        });


        return view;
    }

}
