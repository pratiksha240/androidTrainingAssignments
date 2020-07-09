package com.example.asynctaskdemo;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    Context context;
    private static final int TYPE_HEADER = 0;
    private static final int TYPE_ITEM = 1;
    ArrayList<Items> dataList;
    private onItemClickListener mListener;

    public MyAdapter(Context context, ArrayList<Items> dataList)
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
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        if (viewType == TYPE_ITEM)
        {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout, parent, false);
            return new ItemViewHolder( itemView, mListener );
        }
        else if (viewType == TYPE_HEADER)
        {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout, parent, false);
            return new HeaderViewHolder( itemView, mListener );
        }
        else
        {
            return null;
        }
    }

    @Override
    public int getItemViewType( int position )
    {
        Items item = dataList.get(position);
        if ( ( item.getmType() == Items.Type.ALBUMS ) || ( item.getmType() == Items.Type.ARTISTS) || ( item.getmType() == Items.Type.TRACKS) )
        {
            return TYPE_HEADER;
        }
        return TYPE_ITEM;
    }

    @Override
    public void onBindViewHolder( final RecyclerView.ViewHolder holder, int position )
    {
        Items item = dataList.get(position);
        Log.d("DEBUG","Datalist size = " + dataList.size() );
        if( holder instanceof HeaderViewHolder )
        {
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.mType.setText(item.getmType().toString());
            Log.d("DEBUG", "Printing Type " + item.getmType().toString());
        }
        else if( holder instanceof ItemViewHolder )
        {
            final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.mId.setText(String.valueOf(item.getmId()));
            itemViewHolder.mName.setText(item.getmName());
            Picasso.with(context).load(item.getmImage()).into(itemViewHolder.mImage);
            Log.d("DEBUG", "Priting items of " + item.getmId() + item.getmName());
        }
    }

    @Override
    public int getItemCount()
    {
        return dataList.size();
    }

    public String getType( int position )
    {
        return dataList.get(position).getmType().toString();
    }

    private class HeaderViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mType;

        public HeaderViewHolder( View view, final onItemClickListener listener )
        {
            super(view);
            mType = view.findViewById(R.id.textView);

            itemView.setOnClickListener( new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
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

    public class ItemViewHolder extends RecyclerView.ViewHolder
    {
        public TextView mId;
        public TextView mName;
        public ImageView mImage;

        public ItemViewHolder( View itemView, final onItemClickListener listener )
        {
            super(itemView);
            mId = itemView.findViewById(R.id.textview11);
            mName = itemView.findViewById(R.id.textView12);
            mImage = itemView.findViewById(R.id.imageView4);

            itemView.setOnClickListener( new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
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
