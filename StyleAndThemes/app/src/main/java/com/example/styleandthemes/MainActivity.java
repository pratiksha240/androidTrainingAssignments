package com.example.styleandthemes;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{
    Button button;
    ImageView imageView;
    Switch switch1;
    private static String SHEARED_PREF = "Sheared_Pref";
    private static String SWITCH = "switch1";
    private static boolean switchstatus ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
        {
        super.onCreate(savedInstanceState);
        loadData();
        onActivitySetTheme(this);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.imageView);
        switch1 = (Switch) findViewById(R.id.switch1);

        switch1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                saveData();
                recreate();
            }
        });
//        loadData();
        switch1.setChecked(switchstatus);

    }

    public static void onActivitySetTheme( Activity activity )
    {
        if(switchstatus)
        {
            activity.setTheme(R.style.MyThem);
        }
        else
        {
            activity.setTheme(R.style.AppTheme);
        }
    }

    public void saveData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHEARED_PREF, MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(SWITCH, switch1.isChecked());
        editor.apply();
        Toast.makeText(this, "Data saved", Toast.LENGTH_SHORT).show();
    }

    public void loadData()
    {
        SharedPreferences sharedPreferences = getSharedPreferences(SHEARED_PREF, MODE_PRIVATE);
        switchstatus = sharedPreferences.getBoolean(SWITCH, false);
    }
}
