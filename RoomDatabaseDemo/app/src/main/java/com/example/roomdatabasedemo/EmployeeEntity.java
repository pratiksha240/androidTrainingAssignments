package com.example.roomdatabasedemo;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Employee")
public class EmployeeEntity
{
    @PrimaryKey
    private int eid;

    private String ename;

    private String edesig;

    public int getEid()
    {
        return eid;
    }

    public void setEid(int eid)
    {
        this.eid = eid;
    }

    public String getEname()
    {
        return ename;
    }

    public void setEname(String ename)
    {
        this.ename = ename;
    }

    public String getEdesig()
    {
        return edesig;
    }

    public void setEdesig(String edesig)
    {
        this.edesig = edesig;
    }
}
