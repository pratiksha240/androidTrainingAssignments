package com.example.asynctaskdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.zip.Inflater;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    Context context;
    ArrayList<HashMap<String, String>> dataList;
    public MyAdapter(Context context, ArrayList<HashMap<String, String>> dataList)
    {
        this.context = context;
        this.dataList = dataList;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.items_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        HashMap<String, String> data = dataList.get(position);
        if( position == 0 )
        {
            holder.mId1.setText(data.get("id"));
            holder.mName1.setText(data.get("name"));
        }
        else if( position == 1 )
        {
            holder.mId2.setText(data.get("id"));
            holder.mName2.setText(data.get("name"));
        }
        else if( position == 2 )
        {
            holder.mId3.setText(data.get("id"));
            holder.mName3.setText(data.get("name"));
        }
    }

    @Override
    public int getItemCount()
    {
        return dataList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mId1, mId2, mId3;
        public TextView mName1, mName2, mName3;
        public ImageView mImage1, mImage2, mImage3;

        public MyViewHolder(@NonNull View itemView)
        {
            super(itemView);
            mId1 = itemView.findViewById(R.id.textView2);
            mName1 = itemView.findViewById(R.id.textView3);
            mImage1 = itemView.findViewById(R.id.imageView);
            mId2 = itemView.findViewById(R.id.textView5);
            mName2 = itemView.findViewById(R.id.textView6);
            mImage2 = itemView.findViewById(R.id.imageView2);
            mId3 = itemView.findViewById(R.id.textView9);
            mName3 = itemView.findViewById(R.id.textView10);
            mImage3 = itemView.findViewById(R.id.imageView3);
        }
    }
}
