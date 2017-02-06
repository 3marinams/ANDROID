
package com.idi.marinamoreno.calculadora;

import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.MyViewHolder> {

    private List<Contact> contactsList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView username, intents;
        public View v;

        public MyViewHolder(View view) {
            super(view);
            username = (TextView) view.findViewById(R.id.cv_user);
            intents = (TextView) view.findViewById(R.id.cv_intents);
            v = view;

        }

    }

    public RankingAdapter(List<Contact> list) {
        this.contactsList = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_card, parent, false);
        CardView cv = (CardView) itemView.findViewById(R.id.cv);
        cv.setCardBackgroundColor(0xFFFFFFFF);

        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Contact c = contactsList.get(position);
        holder.username.setText(c.getUsername());
        holder.intents.setText(String.valueOf(c.getIntents()));
    }

    @Override
    public int getItemCount() {
        return contactsList.size();
    }

    public Contact getItem(int position){
        return contactsList.get(position);
    }

}