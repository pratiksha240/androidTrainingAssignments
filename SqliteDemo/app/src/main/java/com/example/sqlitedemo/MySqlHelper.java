package com.example.sqlitedemo;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MySqlHelper extends SQLiteOpenHelper
{

    public MySqlHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version)
    {
        super(context, "EmployeeInfo" , factory, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db)
    {
        db.execSQL("create table Employee(eid integer primary key, ename text, edesignation text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        db.execSQL("drop table if exists Employee");
        onCreate(db);
    }

    public Cursor getAllItems()
    {
        String query = "SELECT * FROM  Employee";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = null;
        if( db != null)
            cursor = db.rawQuery( query, null );
        return cursor;
    }

    public Integer deleteData(String id)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete("Employee", "eid = ?", new String[] {id});
    }

    public boolean updateData(String id, String name, String desig )
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put( "eid", id );
        values.put( "ename", name );
        values.put( "edesignation", desig );
        db.update("EMployee", values, "eid = ?", new String[] { id });
        return true;
    }
}

