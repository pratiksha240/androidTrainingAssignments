package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FarmerPortal extends AppCompatActivity {
    DatabaseHelper myDB;
    EditText ename, eaddress, epincode;
    Button addbtn;
    Button showData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_portal);
        myDB = new DatabaseHelper(this);

        ename = (EditText)findViewById(R.id.fname);
        eaddress = (EditText)findViewById(R.id.address);
        epincode = (EditText)findViewById(R.id.pincode);
        addbtn = (Button)findViewById(R.id.freg2);
        showData = (Button)findViewById(R.id.freg);
        Button butt1 = (Button) findViewById(R.id.freg3);
        addData();
        showAll();

        butt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent int1 = new Intent(FarmerPortal.this, MainActivity.class);
                startActivity(int1);
            }
        });
    }

    public void addData(){
        addbtn.setOnClickListener(
                new OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        boolean isInserted = myDB.insertData(ename.getText().toString(),
                                eaddress.getText().toString(),
                                epincode.getText().toString());
                        if (isInserted == true) {
                            Toast.makeText(FarmerPortal.this, "Registered Successfully", Toast.LENGTH_LONG).show();
                            Intent int2 = new Intent(FarmerPortal.this, MainActivity.class);
                            startActivity(int2);
                        } else
                            Toast.makeText(FarmerPortal.this, "Registration Unsuccessfull", Toast.LENGTH_LONG).show();
                    }
                }
        );
    }

    public void showAll(){
        showData.setOnClickListener(
                new OnClickListener() {
                    @Override
                    public void onClick(View v) {
                           Cursor res = myDB.getAllData();
                           if(res.getCount() == 0){
                               // show error message
                               showMessage("Error","Nothing Found");
                               return;
                           }
                           StringBuffer buffer = new StringBuffer();
                           while(res.moveToNext()){
                               buffer.append("Id ="+res.getString(0)+"\n");
                               buffer.append("Name ="+res.getString(1)+"\n");
                               buffer.append("Address ="+res.getString(2)+"\n");
                               buffer.append("Pincode ="+res.getString(3)+"\n\n");
                           }
                           //show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title, String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }

}
