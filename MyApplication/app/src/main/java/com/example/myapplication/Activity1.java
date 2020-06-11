package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Activity1 extends MainActivity {
    @Override
    public void getNextButton() {
        Intent i = new Intent(Activity1.this, Activity2.class );
        startActivity(i);
    }

    @Override
    public void getPreviousButton() {
        Intent i = new Intent(Activity1.this, Activity1.class );
        startActivity(i);
    }

    @Override
    public String getAcitivityName(){
        return  "Acitivity 1";
    }
}
