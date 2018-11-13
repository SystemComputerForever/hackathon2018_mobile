package com.example.hackathon2018.happytravel.Adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hackathon2018.happytravel.Item.Travelpost;
import com.example.hackathon2018.happytravel.MyApplication;
import com.example.hackathon2018.happytravel.R;
import com.example.hackathon2018.happytravel.UIActiviy.PostActivity;

import java.util.ArrayList;

/**
 * Created by Benix on 3/11/2018.
 */

public class TravelPostAdapter extends RecyclerView.Adapter<TravelPostAdapter.ViewHolder> {
    private ArrayList<Travelpost> data ;
    private Context mContext;

    public TravelPostAdapter(ArrayList<Travelpost> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
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

        holder.location.setText(data.get(position).getCountry());
        holder.title.setText(data.get(position).getTitle());
        holder.startdate.setText(data.get(position).getStart_date());
        holder.userid.setText(data.get(position).getU_id());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(mContext, PostActivity.class);
                ActivityOptions options =
                        ActivityOptions.makeCustomAnimation(MyApplication.getAppContext(), android.R.anim.fade_in, android.R.anim.fade_out);
                mContext.startActivity(myIntent, options.toBundle());
            }
        });
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
            image = v.findViewById(R.id.image);
            title = v.findViewById(R.id.title);
            startdate = v.findViewById(R.id.startdate);
            userid = v.findViewById(R.id.userid);
            location = v.findViewById(R.id.location);
        }
    }
}