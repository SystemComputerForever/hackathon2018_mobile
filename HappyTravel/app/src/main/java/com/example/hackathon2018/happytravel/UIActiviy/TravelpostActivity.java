package com.example.hackathon2018.happytravel.UIActiviy;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.example.hackathon2018.happytravel.Adapter.TravelPostAdapter;
import com.example.hackathon2018.happytravel.Controller.RestController;
import com.example.hackathon2018.happytravel.Function.CallBackFunction;
import com.example.hackathon2018.happytravel.Function.FileHandler;
import com.example.hackathon2018.happytravel.Function.GetData;
import com.example.hackathon2018.happytravel.Item.Travelpost;
import com.example.hackathon2018.happytravel.R;
import com.example.hackathon2018.happytravel.UIActiviy.BasicActivity.NavigationActivity;

import org.json.JSONArray;

import java.util.ArrayList;
import java.util.HashMap;


public class TravelpostActivity extends NavigationActivity implements CallBackFunction {

    private RestController tpc;
    private Context mContext;
    private DrawerLayout mydrawer;
    private View progress_form;
    private FileHandler fh = new FileHandler();
    private HashMap<String, String> data = new HashMap<>();
    ;
    private RecyclerView recyclerView;

    private enum variable {
        plan_id, title, country_id, routes, est_days, start_date, end_date, requirements, images, u_id, country
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_travelpost);
        super.onCreate(savedInstanceState);
        mContext = this;
        mydrawer = findViewById(R.id.drawer_layout);
        progress_form = findViewById(R.id.progress_form);
        new GetData().GetCountry();
        //you need to save the exist user here first
        // fh.saveFile("user",)
      /*  GridLayoutManager gl = new GridLayoutManager(this, 2);
        //  LinearLayoutManager layoutManager = new LinearLayoutManager(this); //設定此 layoutManager 為 linearlayout (類似ListView)
        //  layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView = findViewById(R.id.recyclerView);
        // recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)); //設定分割線
        recyclerView.setLayoutManager(gl); //設定 LayoutManager
        ArrayList<String> Dataset = new ArrayList<String>();
        for (int i = 0; i < 10; i++) {
            Dataset.add(i + "");
        }
        TravelPostAdapter myAdapter = new TravelPostAdapter(Dataset, mContext);
        recyclerView.setAdapter(myAdapter); //設定 Adapter*/
        GridLayoutManager gl = new GridLayoutManager(this, 2);
        recyclerView = findViewById(R.id.recyclerView);
        //  LinearLayoutManager layoutManager = new LinearLayoutManager(this); //設定此 layoutManager 為 linearlayout (類似ListView)
        //  layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        // recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)); //設定分割線
        recyclerView.setLayoutManager(gl); //設定 LayoutManager
        refresh();
    }

    public void refresh() {
        tpc = new RestController(progress_form, mContext, mydrawer, "https://hackathon-718718.appspot.com/plans/getplans", data, (CallBackFunction) mContext);
        tpc.execute();
    }

    @Override
    public void done(String result) {
        Log.e("ouputresult:",result);
        ArrayList<Travelpost> travelposts = new ArrayList<Travelpost>();
        try {
            JSONArray travelpostsary = new JSONArray(result);
            for (int i = 0; i < travelpostsary.length() ; i++) {
                Travelpost onepost = new Travelpost(travelpostsary.getJSONObject(i).getString(variable.values()[0].name()), travelpostsary.getJSONObject(i).getString(variable.values()[1].name()), travelpostsary.getJSONObject(i).getString(variable.values()[2].name()), travelpostsary.getJSONObject(i).getString(variable.values()[3].name()), travelpostsary.getJSONObject(i).getString(variable.values()[4].name()), travelpostsary.getJSONObject(i).getString(variable.values()[5].name()), travelpostsary.getJSONObject(i).getString(variable.values()[6].name()), travelpostsary.getJSONObject(i).getString(variable.values()[7].name()), travelpostsary.getJSONObject(i).getString(variable.values()[8].name()), travelpostsary.getJSONObject(i).getString(variable.values()[9].name()), travelpostsary.getJSONObject(i).getString(variable.values()[10].name()));
                travelposts.add(onepost);
            }
            Log.e("travelpost: ",travelpostsary.length()+"");
            // TravelPostAdapter myAdapter = new TravelPostAdapter(travelposts, mContext);
            // recyclerView.setAdapter(myAdapter); //設定 Adapter*/
          //  GridLayoutManager gl = new GridLayoutManager(this, 2);
            //  LinearLayoutManager layoutManager = new LinearLayoutManager(this); //設定此 layoutManager 為 linearlayout (類似ListView)
            //  layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            // recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL)); //設定分割線
            TravelPostAdapter myAdapter = new TravelPostAdapter(travelposts, mContext);
            recyclerView.setAdapter(myAdapter); //設定 Adapter*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Log.e("Show post", result);
    }
}
