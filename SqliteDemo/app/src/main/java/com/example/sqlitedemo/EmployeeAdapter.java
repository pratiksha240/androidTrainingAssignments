package com.example.sqlitedemo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>
{
    private Context context;
    private Cursor cursor;
    public EmployeeAdapter(Context context, Cursor cursor)
    {
        this.context = context;
        this.cursor = cursor;
    }
    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position)
    {
        if(!cursor.moveToPosition(position))
            return;
        int eId = cursor.getInt(cursor.getColumnIndex("eid"));
        String eName = cursor.getString(cursor.getColumnIndex("ename"));
        String eDesig = cursor.getString(cursor.getColumnIndex("edesignation"));

        holder.empid.setText(String.valueOf(eId));
        holder.empName.setText(eName);
        holder.empDesignation.setText(eDesig);
    }

    @Override
    public int getItemCount()
    {
        return cursor.getCount();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder
    {
        public TextView empid;
        public TextView empName;
        public TextView empDesignation;
        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            empid = itemView.findViewById(R.id.textView);
            empName = itemView.findViewById(R.id.textView2);
            empDesignation = itemView.findViewById(R.id.textView3);
        }
    }

    public void swapCusor(Cursor newCursor)
    {
        if( cursor != null )
            cursor.close();
        cursor = newCursor;
        if( newCursor != null )
            notifyDataSetChanged();
    }

}
