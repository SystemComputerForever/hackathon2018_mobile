package com.example.hackathon2018.happytravel.Adapter;

import android.app.ActivityOptions;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hackathon2018.happytravel.MyApplication;
import com.example.hackathon2018.happytravel.R;
import com.example.hackathon2018.happytravel.UIActiviy.PostActivity;

import java.util.ArrayList;

/**
 * Created by Benix on 3/11/2018.
 */

public class ImageScrollAdapter extends RecyclerView.Adapter<ImageScrollAdapter.ViewHolder> {
    private ArrayList<String> data = new ArrayList<>();
    private Context mContext;

    public ImageScrollAdapter(ArrayList<String> data, Context mContext) {
        this.data = data;
        this.mContext = mContext;
    }

    @Override
    public ImageScrollAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_comment, parent, false);
        //  ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        //  layoutParams.width = ((Activity) parent.getContext()).getWindowManager().getDefaultDisplay().getWidth() / 3;
        //  view.setLayoutParams(layoutParams);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.user_id.setText("a");
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
        TextView user_id;
        ImageView user_icon;
        TextView cm_date;
        TextView cm_time;
        TextView user_comment;
        RecyclerView comment_recycler_view;

        ViewHolder(View v) {
            super(v);
            user_id = v.findViewById(R.id.user_id);
            user_icon = v.findViewById(R.id.user_icon);
            cm_date = v.findViewById(R.id.cm_date);
            user_comment = v.findViewById(R.id.user_comment);
            comment_recycler_view = v.findViewById(R.id.comment_recycler_view);
        }
    }
}