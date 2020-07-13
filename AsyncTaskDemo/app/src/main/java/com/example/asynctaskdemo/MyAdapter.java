package com.example.asynctaskdemo;

import android.content.Context;
import android.util.Log;
import android.view.ContextThemeWrapper;
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
    private static final int TYPE_ALBUM = 1;
    private static final int TYPE_ARTIST = 2;
    private static final int TYPE_TRACK = 3;
    private static final int TYPE_ITEM = 4;
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
        if ( ( viewType == TYPE_ALBUM ) || ( viewType == TYPE_ARTIST ) )
        {
            ContextThemeWrapper contextThemeWrapper;
            if( viewType == TYPE_ALBUM )
            {
                contextThemeWrapper = new ContextThemeWrapper(context, R.style.AlbumTheme);
            }
            else
            {
                contextThemeWrapper = new ContextThemeWrapper(context, R.style.ArtistTheme);
            }
            View itemView = LayoutInflater.from(contextThemeWrapper).inflate(R.layout.items_layout, parent, false);
            return new ItemViewHolder( itemView, mListener );
        }
        else if (viewType == TYPE_ITEM)
        {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_layout, parent, false);
            return new ItemViewHolder( itemView, mListener );
        }
        else if (viewType == TYPE_HEADER)
        {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.header_layout, parent, false);
            return new HeaderViewHolder( itemView, mListener );
        }
        else if (viewType == TYPE_TRACK)
        {
            View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.track_layout, parent, false);
            return new TrackHolder( itemView, mListener );
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
        if ( item.getmLayoutType() == Items.LayoutType.HEADER )
        {
            Log.d("DEBUG", "Header..!!");
            return TYPE_HEADER;
        }
        else if( item.getmLayoutType() == Items.LayoutType.ALBUM )
        {
            Log.d("DEBUG", "Album..!!");
            return TYPE_ALBUM;
        }
        else if( item.getmLayoutType() == Items.LayoutType.ARTIST )
        {
            Log.d("DEBUG", "Artist..!!");
            return TYPE_ARTIST;
        }
        else if( item.getmLayoutType() == Items.LayoutType.ITEM )
        {
            Log.d("DEBUG", "Item..!!");
            return TYPE_ITEM;
        }
        else
        {
            Log.d("DEBUG", "Track..!!");
            return TYPE_TRACK;
        }
    }

    @Override
    public void onBindViewHolder( final RecyclerView.ViewHolder holder, int position )
    {
        Items item = dataList.get(position);
        Log.d("DEBUG","Datalist size = " + dataList.size() );
        if( holder instanceof HeaderViewHolder )
        {
            Log.d("DEBUG","HeaderViewHolder Object...!!");
            HeaderViewHolder headerViewHolder = (HeaderViewHolder) holder;
            headerViewHolder.mType.setText(item.getmType().toString());
            Log.d("DEBUG", "Printing Type " + item.getmType().toString());
        }
        else if( holder instanceof ItemViewHolder )
        {
            Log.d("DEBUG","ItemViewHolder Object...!!");
            final ItemViewHolder itemViewHolder = (ItemViewHolder) holder;
            itemViewHolder.mName.setText(item.getmName());
            Picasso.with(context).load(item.getmImage()).into(itemViewHolder.mImage);
            Log.d("DEBUG", "Priting items of " + item.getmName());
        }
        else if( holder instanceof TrackHolder )
        {
            Log.d("DEBUG","TrackHolder Object...!!");
            final TrackHolder trackHolder = (TrackHolder) holder;
            trackHolder.mTrackName.setText(item.getmName());
            trackHolder.mArtistName.setText(item.getmSubtitle());
            Picasso.with(context).load(item.getmImage()).into(trackHolder.mTrackImage);
            Log.d("DEBUG", "Priting track of " + item.getmId() + item.getmName());
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
        public TextView mName;
        public ImageView mImage;

        public ItemViewHolder( View itemView, final onItemClickListener listener )
        {
            super(itemView);
            mName = itemView.findViewById(R.id.textView2);
            mImage = itemView.findViewById(R.id.imageView);

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

    public class TrackHolder extends RecyclerView.ViewHolder
    {
        public TextView mTrackName;
        public TextView mArtistName;
        public ImageView mTrackImage;

        public TrackHolder( View itemView, final onItemClickListener listener )
        {
            super(itemView);
            mTrackName = itemView.findViewById(R.id.textview11);
            mArtistName = itemView.findViewById(R.id.textView12);
            mTrackImage = itemView.findViewById(R.id.imageView4);

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
