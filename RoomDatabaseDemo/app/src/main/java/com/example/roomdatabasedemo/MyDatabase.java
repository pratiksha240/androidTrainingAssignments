package com.example.roomdatabasedemo;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {EmployeeEntity.class}, version = 1, exportSchema = false)
public abstract class MyDatabase extends RoomDatabase
{
    public abstract MyDao myDao();
}
