package com.example.asynctaskdemo;

import android.content.Context;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.module.AppGlideModule;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder>
{
    Context context;
    ArrayList<ArrayList<Items>> dataList;
    private onItemClickListener mListener;

    public MyAdapter(Context context, ArrayList<ArrayList<Items>> dataList)
    {
        this.context = context;
        this.dataList = dataList;
    }

    public interface onItemClickListener
    {
        void onItemClick( int position );
    }

    public void setOnItemClickListener( onItemClickListener listener)
    {
        mListener = listener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view;
        if( dataList.size() == 3 )
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.items_layout, parent, false);
        }
        else
        {
            LayoutInflater inflater = LayoutInflater.from(context);
            view = inflater.inflate(R.layout.item_layout, parent, false);
        }
        return new MyViewHolder( view, mListener );
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        ArrayList<Items> item = dataList.get(position);
        Log.d("DEBUG","Datalist size = " + dataList.size() );
        if( dataList.size() == 3 )
        {
            holder.mId3.setText(String.valueOf((item.get(0)).getmId()));
            holder.mName3.setText((item.get(0)).getmName());
            Glide.with(holder.mImage3.getContext()).load((item.get(0)).getmImage()).into(holder.mImage3);
//            Picasso.with(context).load((item.get(0)).getmImage()).into(holder.mImage3);
            holder.mType.setText((item.get(0)).getmType().toString());
            holder.mId2.setText(String.valueOf((item.get(1)).getmId()));
            holder.mName2.setText((item.get(1)).getmName());
            Picasso.with(context).load((item.get(1)).getmImage()).into(holder.mImage2);
            holder.mId1.setText(String.valueOf((item.get(2)).getmId()));
            holder.mName1.setText((item.get(2)).getmName());
            Picasso.with(context).load((item.get(2)).getmImage()).into(holder.mImage1);
        }
        else
        {
            holder.mId.setText(String.valueOf((item.get(0)).getmId()));
            holder.mName.setText((item.get(0)).getmName());
            Picasso.with(context).load((item.get(0)).getmImage()).into(holder.mImage);
        }
    }

    @Override
    public int getItemCount()
    {
        return dataList.size();
    }

    public String getType( int position )
    {
        return (dataList.get(position)).get(position).getmType().toString();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mId1, mId2, mId3, mId;
        public TextView mName1, mName2, mName3, mName;
        public ImageView mImage1, mImage2, mImage3, mImage;
        public TextView mType;

        public MyViewHolder( @NonNull View itemView, final onItemClickListener listener )
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
            mType = itemView.findViewById(R.id.textView);

            mId = itemView.findViewById(R.id.textview11);
            mName = itemView.findViewById(R.id.textView12);
            mImage = itemView.findViewById(R.id.imageView4);

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
