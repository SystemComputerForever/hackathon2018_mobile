package com.example.hackathon2018.happytravel.Adapter;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hackathon2018.happytravel.R;

import java.util.ArrayList;

/**
 * Created by Benix on 3/11/2018.
 */

public class TravelPostAdapter extends RecyclerView.Adapter<TravelPostAdapter.ViewHolder> {
    private ArrayList<String> data = new ArrayList<>();

    public TravelPostAdapter(ArrayList<String> data) {
        this.data = data;
    }


    @Override
    public TravelPostAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_post, parent, false);
   //     ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
      //  layoutParams.width = ((Activity) parent.getContext()).getWindowManager().getDefaultDisplay().getWidth() / 3;
      //  view.setLayoutParams(layoutParams);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.location.setText("a");
    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView image;
        TextView location;
        TextView startdate;
        TextView userid;

        ViewHolder(View v) {
            super(v);
            Log.e("showview", v.toString());
            image = v.findViewById(R.id.imageView);
            title = v.findViewById(R.id.title);
            startdate = v.findViewById(R.id.startdate);
            userid = v.findViewById(R.id.userid);
            location = v.findViewById(R.id.location);
        }
    }
}