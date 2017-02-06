package com.idi.marinamoreno.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.List;

public class RankingActivity extends BaseActivity {
    private  RecyclerView recyclerView;
    private RankingAdapter rankingAdapter;
    private DataBaseHelper helper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);
        Log.d("jjjjjjjjjjjjjj", "onCreateeeeeee: ");

        recyclerView = (RecyclerView) findViewById(R.id.rec);
        helper = new DataBaseHelper(this);
        List<Contact> contacts = helper.getAllContactsOrdByIntents();
        rankingAdapter = new RankingAdapter(contacts);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(rankingAdapter);
    }
}
