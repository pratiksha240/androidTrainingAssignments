package com.example.livedatademo;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

public class LiveDataFragment extends Fragment
{
    LiveDataViewModel model;
    TextView textView;
    EditText editText;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.live_data_fragment, container, false);
        textView = view.findViewById(R.id.textView);
        editText = view.findViewById(R.id.editText);
        model = new ViewModelProvider(getActivity()).get(LiveDataViewModel.class);

        final LiveData<String> data = model.getEnteredText();
        data.observe(getViewLifecycleOwner(), new Observer<String>()
        {
            @Override
            public void onChanged(String s)
            {
                textView.setText(s);
            }
        });
        editText.addTextChangedListener(new TextWatcher()
        {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after)
            {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count)
            {
                String text = editText.getText().toString();
                model.setEntededText(text);
            }

            @Override
            public void afterTextChanged(Editable s)
            {

            }
        });

        return view;
    }
}
