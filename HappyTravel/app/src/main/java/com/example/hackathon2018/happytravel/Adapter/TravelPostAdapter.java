package com.example.hackathon2018.happytravel.Adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hackathon2018.happytravel.R;

import java.util.ArrayList;

/**
 * Created by Benix on 3/11/2018.
 */

public class TravelPostAdapter extends RecyclerView.Adapter<TravelPostAdapter.ViewHolder> {
    private ArrayList<String> data;

    public TravelPostAdapter(ArrayList<String> data) {
        this.data = data;
    }

    @Override
    public TravelPostAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_post, parent, false);
        ViewHolder viewholder = new ViewHolder(view);
        return viewholder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.title.setText("a");
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        // public TextView txtItem;
        private ImageView image;
        private TextView title;
        private TextView startdate;
        public TextView userid;


        public ViewHolder(View v) {
            super(v);
            image = v.findViewById(R.id.imageView);
            title = v.findViewById(R.id.textView);
            startdate = v.findViewById(R.id.startdate);
            userid = v.findViewById(R.id.userid);
        }
    }
}