package com.example.studentform;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link StudentDetails#newInstance} factory method to
 * create an instance of this fragment.
 *
 */
public class StudentDetails extends Fragment
{
    TextView sname, smarks, sgender, sdegree;

    public StudentDetails()
    {
        // Required empty public constructor
    }

    @Override
    public View onCreateView( LayoutInflater inflater,
                              ViewGroup container,
                             Bundle savedInstanceState )
    {
        View view = inflater.inflate( R.layout.fragment_student_details, container, false );
        sname = view.findViewById( R.id.textView8 );
        smarks = view.findViewById( R.id.textView10 );
        sgender = view.findViewById( R.id.textView12 );
        sdegree = view.findViewById( R.id.textView14 );

        Bundle bundle = this.getArguments();
        String name = bundle.getString("name");
        String marks = bundle.getString("marks");
        String gender = bundle.getString("gender");
        String degree = bundle.getString("degree");

        sname.setText( name );
        smarks.setText( marks );
        sgender.setText( gender );
        sdegree.setText( degree );

        return view;
    }
}
