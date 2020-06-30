package com.example.roomdatabasedemo;


import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MyDao
{
    @Insert
    public void addEmp(EmployeeEntity emp);

    @Query("select * from Employee")
    public List<EmployeeEntity> getEmployees();

    @Delete
    public void deleteEmployee(EmployeeEntity employee);

    @Update
    public void updateEmployee(EmployeeEntity employee);
}
