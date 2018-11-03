package com.example.hackathon2018.happytravel.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.hackathon2018.happytravel.R;
import java.util.ArrayList;

/**
 * Created by Benix on 3/11/2018.
 */

public class TravelPostAdapter extends RecyclerView.Adapter<TravelPostAdapter.ViewHolder>
{
    private ArrayList<String> data;

    public TravelPostAdapter(ArrayList<String> data)
    {
        this.data = data;
    }

    @Override
    public TravelPostAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_post, parent, false);
        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position)
    {
      //  holder.txtItem.setText(mDataSet.get(position));
    }

    @Override
    public int getItemCount()
    {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {
       // public TextView txtItem;
        public ViewHolder(View v)
        {
            super(v);
           // txtItem = (TextView) v.findViewById(R.id.txtItem);
        }
    }
}