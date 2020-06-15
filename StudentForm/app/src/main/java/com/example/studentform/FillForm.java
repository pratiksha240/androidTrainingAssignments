package com.example.studentform;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;


/**
 * A simple {@link Fragment} subclass.
 */
public class FillForm extends Fragment {

    EditText sname, marks;
    Button btn;
    RadioButton radioButton;
    RadioGroup radioGroup;
    String gender, degree;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState)
    {
        final View view = inflater.inflate(R.layout.fragment_fill_form, container, false);
        Spinner mySpinner = (Spinner) view.findViewById(R.id.spinner);
        btn = view.findViewById(R.id.button);
        sname = view.findViewById(R.id.editText);
        marks = view.findViewById(R.id.editText2);

        btn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                Bundle bundle = new Bundle();
                bundle.putString("name", sname.getText().toString() );
                bundle.putString("marks", marks.getText().toString() );
                bundle.putString("gender", gender );
                bundle.putString("degree", degree );
                StudentDetails fragment2 = new StudentDetails();
                fragment2.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.my_layout, fragment2).commit();
            }
        });

        radioGroup = (RadioGroup) view.findViewById( R.id.radioGroup );
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener()
        {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId)
            {
                radioButton = view.findViewById(checkedId);
                gender = radioButton.getText().toString();
            }
        });
        ArrayAdapter<String> ad = new ArrayAdapter<String>(getContext(),
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.education));

        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(ad);

        mySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener()
        {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                degree = parent.getItemAtPosition(position).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        return view;
    }

    @Override
    public void onResume()
    {
        super.onResume();

    }

}
