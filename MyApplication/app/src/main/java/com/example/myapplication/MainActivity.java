package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

    public abstract class MainActivity extends AppCompatActivity {
        Button nextbtn;
        Button previousbtn;
        TextView activity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nextbtn = (Button) findViewById(R.id.button5);
        previousbtn = (Button) findViewById(R.id.button10);
        activity = (TextView) findViewById(R.id.textView5);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        next();
        previous();
        String name = getAcitivityName();
        showActivityName(name);
    }
    public abstract String getAcitivityName();
    public abstract void getNextButton();
    public abstract void getPreviousButton();
    public void next()
    {
        nextbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getNextButton();
            }
        });
    }
    public void previous()
    {
        previousbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getPreviousButton();
            }
        });
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }

    public void showActivityName(String name) {
        activity.setText(name);
    }
}
