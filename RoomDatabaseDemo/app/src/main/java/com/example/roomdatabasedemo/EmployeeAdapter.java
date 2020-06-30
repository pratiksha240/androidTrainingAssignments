package com.example.roomdatabasedemo;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>
{
    private Context context;
    private List<EmployeeEntity> employees;
    private onItemClickListener mListener;

    public interface onItemClickListener
    {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(onItemClickListener listener)
    {
        mListener = listener;
    }

    public EmployeeAdapter(Context context, List<EmployeeEntity> employees)
    {
        this.context = context;
        this.employees = employees;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        return new EmployeeViewHolder( view, mListener );
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position)
    {
        EmployeeEntity employee = employees.get(position);
        int mId = employee.getEid();
        String mName = employee.getEname();
        String mDesignation = employee.getEdesig();

        holder.empid.setText(String.valueOf(mId));
        holder.empName.setText(mName);
        holder.empDesignation.setText(mDesignation);
    }

    @Override
    public int getItemCount()
    {
        return employees.size();
    }

    public class EmployeeViewHolder extends RecyclerView.ViewHolder
    {
        public TextView empid;
        public TextView empName;
        public TextView empDesignation;
        public EmployeeViewHolder(@NonNull View itemView, final onItemClickListener listener) {
            super(itemView);
            empid = itemView.findViewById(R.id.textView);
            empName = itemView.findViewById(R.id.textView2);
            empDesignation = itemView.findViewById(R.id.textView3);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if( listener != null )
                    {
                        int position = getAdapterPosition();
                        if( position != RecyclerView.NO_POSITION)
                        {
                            listener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
