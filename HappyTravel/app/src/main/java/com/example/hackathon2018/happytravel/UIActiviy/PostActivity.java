package com.example.hackathon2018.happytravel.UIActiviy;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import com.example.hackathon2018.happytravel.Controller.RestController;
import com.example.hackathon2018.happytravel.Function.CallBackFunction;
import com.example.hackathon2018.happytravel.R;
import com.example.hackathon2018.happytravel.UIActiviy.BasicActivity.NoNavigationActivity;

public class PostActivity extends NoNavigationActivity implements CallBackFunction {

    private RestController tpc;
    private Context mContext;
    private Button btn_join;
    public static final String chosen1 = "Join now";
    public static final String chosen2 = "CANCEL APPLICATION";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_post);
        super.onCreate(savedInstanceState);
        btn_join = findViewById(R.id.btn_join);
        mContext = this;

        btn_join.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Dialog mydialog = new Dialog(mContext, R.style.Theme_AppCompat_DayNight_Dialog);
                switch (btn_join.getText().toString()) {
                    case chosen1:
                        mydialog.setContentView(R.layout.popup);
                        btn_join.setText("CANCEL APPLICATION");
                        break;
                    case chosen2:
                        mydialog.setContentView(R.layout.popup2);
                        btn_join.setText("Join now");
                        break;
                    default:
                        break;
                }

                mydialog.show();
                addTransparency(mydialog);
                //    btn_join.setEnabled(false);
                final Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mydialog.dismiss();
                    }
                }, 800);
            }
        });
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

    public void addTransparency(Dialog mydialog) {
        mydialog.getWindow().setBackgroundDrawable(
                new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    public void refresh() {
        //tpc = new RestController(progress_form, mContext,  drawer);
        //tpc.execute();
    }

    @Override
    public void done(String result) {

    }
}
