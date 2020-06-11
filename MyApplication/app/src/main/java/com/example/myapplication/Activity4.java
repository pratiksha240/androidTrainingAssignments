package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Activity4 extends MainActivity {
    @Override
    public void getNextButton() {
        Intent i = new Intent(Activity4.this, Activity5.class );
        startActivity(i);
    }

    @Override
    public void getPreviousButton() {
        Intent i = new Intent(Activity4.this, Activity3.class );
        startActivity(i);
    }

    @Override
    public String getAcitivityName() {
        return "Activity 4";
    }
}
