package com.example.recyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class MyRecycleviewAdapter extends RecyclerView.Adapter<MyRecycleviewAdapter.RecyclerViewHolder>
{
    private String[] data;
    public MyRecycleviewAdapter(String[] data)
    {
        this.data = data;
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.recycler_item_layout, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerViewHolder holder, final int position)
    {
        String text = data[position];
        holder.itemView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                System.out.println("Selected item = " + data[position]);
            }
        });
        holder.textView.setText(text);
    }

    @Override
    public int getItemCount()
    {
        return data.length;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder
    {
        TextView textView;
        public RecyclerViewHolder(View itemView)
        {
            super(itemView);
            textView = itemView.findViewById(R.id.textView);
        }
    }
}
