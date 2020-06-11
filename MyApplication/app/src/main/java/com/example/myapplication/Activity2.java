package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity2 extends MainActivity {
    @Override
    public void getNextButton() {
        Intent i = new Intent(Activity2.this, Activity3.class );
        startActivity(i);
    }

    @Override
    public void getPreviousButton() {
        Intent i = new Intent(Activity2.this, Activity1.class );
        startActivity(i);
    }

    @Override
    public String getAcitivityName() {
        return "Activity 2";
    }
}
