package com.example.hackathon2018.happytravel.UIActiviy;

import android.content.Context;
import android.os.Bundle;

import com.example.hackathon2018.happytravel.Controller.RestController;
import com.example.hackathon2018.happytravel.Function.CallBackFunction;
import com.example.hackathon2018.happytravel.Item.Travelpost;
import com.example.hackathon2018.happytravel.R;
import com.example.hackathon2018.happytravel.UIActiviy.BasicActivity.NoNavigationActivity;

import org.json.JSONArray;

import java.util.ArrayList;

public class PreviouspostActivity extends NoNavigationActivity implements CallBackFunction {

    private RestController tpc;
    private Context mContext;
    private enum variable {
        plan_id, title, country_id, routes, est_days, start_date, end_date, requirements, images, u_id,country
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_previouspost);
        super.onCreate(savedInstanceState);
        mContext = this;
       /* RecyclerView recyclerView;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<String> Dataset = new ArrayList<String>();
        for(int i = 0; i < 10; i++)
        {
            Dataset.add(i + "");
        }
        MyAdapter myAdapter = new MyAdapter(myDataset);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this); //設定此 layoutManager 為 linearlayout (類似ListView)
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL); 設定此 layoutManager 為垂直堆疊

                recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST)); //設定分割線
        recyclerView.setLayoutManager(layoutManager); //設定 LayoutManager
        recyclerView.setAdapter(myAdapter); //設定 Adapter*/
        refresh();
    }

    public void refresh() {
        //tpc = new RestController(progress_form, mContext,  drawer);
        //tpc.execute();
  //     tpc = new RestController(progress_form, mContext, mydrawer, "https://hackathon-718718.appspot.com/plans/getplans", data, (CallBackFunction) mContext);
  //      tpc.execute();
    }

    @Override
    public void done(String result) {
        ArrayList<Travelpost> travelposts = new ArrayList<Travelpost>();
        try {
            JSONArray travelpostsary = new JSONArray(result);
            for (int i = 0; i < travelpostsary.length() - 1; i++) {
                Travelpost onepost = new Travelpost(travelpostsary.getJSONObject(i).getString(variable.values()[0].name()), travelpostsary.getJSONObject(i).getString(variable.values()[1].name()), travelpostsary.getJSONObject(i).getString(variable.values()[2].name()), travelpostsary.getJSONObject(i).getString(variable.values()[3].name()), travelpostsary.getJSONObject(i).getString(variable.values()[4].name()), travelpostsary.getJSONObject(i).getString(variable.values()[5].name()), travelpostsary.getJSONObject(i).getString(variable.values()[6].name()), travelpostsary.getJSONObject(i).getString(variable.values()[7].name()), travelpostsary.getJSONObject(i).getString(variable.values()[8].name()), travelpostsary.getJSONObject(i).getString(variable.values()[9].name()), travelpostsary.getJSONObject(i).getString(variable.values()[10].name()));
                travelposts.add(onepost);
            }
            // TravelPostAdapter myAdapter = new TravelPostAdapter(travelposts, mContext);
            // recyclerView.setAdapter(myAdapter); //設定 Adapter*/
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        //Log.e("Show post", result);
    }
}
