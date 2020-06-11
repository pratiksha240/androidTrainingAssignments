package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity5 extends MainActivity {
    @Override
    public void getNextButton() {
        Intent i = new Intent(Activity5.this, Activity2.class );
        startActivity(i);
    }

    @Override
    public void getPreviousButton() {
        Intent i = new Intent(Activity5.this, Activity4.class );
        startActivity(i);
    }

    @Override
    public String getAcitivityName() {
        return "Activity 5";
    }
}
