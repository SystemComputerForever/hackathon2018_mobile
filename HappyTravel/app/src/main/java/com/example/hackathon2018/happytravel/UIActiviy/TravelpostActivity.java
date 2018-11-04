package com.example.hackathon2018.happytravel.UIActiviy;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.hackathon2018.happytravel.Adapter.TravelPostAdapter;
import com.example.hackathon2018.happytravel.Controller.RestController;
import com.example.hackathon2018.happytravel.Function.CallBackFunction;
import com.example.hackathon2018.happytravel.R;
import com.example.hackathon2018.happytravel.UIActiviy.BasicActivity.NavigationActivity;

import java.util.ArrayList;


public class TravelpostActivity extends NavigationActivity implements CallBackFunction {

    private RestController tpc;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_travelpost);
        super.onCreate(savedInstanceState);
        mContext = this;
        RecyclerView recyclerView;
        ArrayList<String> Dataset = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            Dataset.add(i + "");
        }
        TravelPostAdapter myAdapter = new TravelPostAdapter(Dataset);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); //設定此 layoutManager 為 linearlayout (類似ListView)
        layoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL)); //設定分割線
        recyclerView.setLayoutManager(layoutManager); //設定 LayoutManager
        recyclerView.setAdapter(myAdapter); //設定 Adapter*/
        refresh();
    }

    public void refresh() {
        //tpc = new RestController(progress_form, mContext,  drawer);
        //tpc.execute();
    }

    @Override
    public void done(String result) {

    }
}
