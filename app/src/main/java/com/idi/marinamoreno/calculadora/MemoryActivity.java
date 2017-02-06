package com.idi.marinamoreno.calculadora;


import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

//import com.example.material.joanbarroso.flipper.CoolImageFlipper;

import com.squareup.picasso.Picasso;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MemoryActivity extends BaseActivity implements View.OnClickListener {

    private Integer[] cardVector = {0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6, 7, 7};
    private List<Integer> card;
    Integer trobats = 0;
    private DataBaseHelper helper;
    private Integer attempts = 0;
    private Integer anterior = -1;
    private Integer actual = -1;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory);
        set();

    }

    private void set(){
        helper = new DataBaseHelper(this);

        ImageButton memory_card0 = (ImageButton) findViewById(R.id.memory_card0);
        memory_card0.setOnClickListener(this);

        ImageButton memory_card1 = (ImageButton) findViewById(R.id.memory_card1);
        memory_card1.setOnClickListener(this);

        ImageButton memory_card2 = (ImageButton) findViewById(R.id.memory_card2);
        memory_card2.setOnClickListener(this);

        ImageButton memory_card3 = (ImageButton) findViewById(R.id.memory_card3);
        memory_card3.setOnClickListener(this);

        ImageButton memory_card4 = (ImageButton) findViewById(R.id.memory_card4);
        memory_card4.setOnClickListener(this);

        ImageButton memory_card5 = (ImageButton) findViewById(R.id.memory_card5);
        memory_card5.setOnClickListener(this);

        ImageButton memory_card6 = (ImageButton) findViewById(R.id.memory_card6);
        memory_card6.setOnClickListener(this);

        ImageButton memory_card7 = (ImageButton) findViewById(R.id.memory_card7);
        memory_card7.setOnClickListener(this);

        ImageButton memory_card8 = (ImageButton) findViewById(R.id.memory_card8);
        memory_card8.setOnClickListener(this);

        ImageButton memory_card9 = (ImageButton) findViewById(R.id.memory_card9);
        memory_card9.setOnClickListener(this);

        ImageButton memory_card10 = (ImageButton) findViewById(R.id.memory_card10);
        memory_card10.setOnClickListener(this);

        ImageButton memory_card11 = (ImageButton) findViewById(R.id.memory_card11);
        memory_card11.setOnClickListener(this);

        ImageButton memory_card12 = (ImageButton) findViewById(R.id.memory_card12);
        memory_card12.setOnClickListener(this);

        ImageButton memory_card13 = (ImageButton) findViewById(R.id.memory_card13);
        memory_card13.setOnClickListener(this);

        ImageButton memory_card14 = (ImageButton) findViewById(R.id.memory_card14);
        memory_card14.setOnClickListener(this);

        ImageButton memory_card15 = (ImageButton) findViewById(R.id.memory_card15);
        memory_card15.setOnClickListener(this);

        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(this);

        card = Arrays.asList(cardVector);
        Collections.shuffle(card);
        card.toArray(cardVector);
    }

    private void reset_image (Integer idb1, Integer idb2) {
        ImageButton memory_card1 = (ImageButton) findViewById(getResources().getIdentifier("memory_card"+idb1,"id",MemoryActivity.this.getPackageName()));
        ImageButton memory_card2 = (ImageButton) findViewById(getResources().getIdentifier("memory_card"+idb2,"id",MemoryActivity.this.getPackageName()));
        memory_card1.setImageResource(R.mipmap.ic_play_circle);
        memory_card1.setBackgroundResource(R.drawable.memory_fons);
        memory_card2.setImageResource(R.mipmap.ic_play_circle);
        memory_card2.setBackgroundResource(R.drawable.memory_fons);
    }

    private void image_memory (Integer idboto){
        ImageButton memory_card = (ImageButton) findViewById(getResources().getIdentifier("memory_card"+idboto,"id",MemoryActivity.this.getPackageName()));
        Integer idfoto = cardVector[idboto];
        memory_card.setBackgroundResource(R.color.colorPrimary);
        switch (idfoto) {
            case 0:
                Picasso.with(MemoryActivity.this).load(R.mipmap.ic_account).into(memory_card);
                break;
            case 1:
                Picasso.with(MemoryActivity.this).load(R.mipmap.ic_apps).into(memory_card);
                break;
            case 2:
                Picasso.with(MemoryActivity.this).load(R.mipmap.ic_calculator).into(memory_card);
                break;
            case 3:
                Picasso.with(MemoryActivity.this).load(R.mipmap.ic_earth).into(memory_card);
                break;
            case 4:
                Picasso.with(MemoryActivity.this).load(R.mipmap.ic_lock).into(memory_card);
                break;
            case 5:
                Picasso.with(MemoryActivity.this).load(R.mipmap.ic_music_note).into(memory_card);
                break;
            case 6:
                Picasso.with(MemoryActivity.this).load(R.mipmap.ic_phone_in_talk).into(memory_card);
                break;
            case 7:
                Picasso.with(MemoryActivity.this).load(R.mipmap.ic_cloud_circle).into(memory_card);
                break;
        }
    }

    @Override
    public void onClick(View view) {
        TextView text_attempts = (TextView) findViewById(R.id.intents);
        switch (view.getId()) {
            case R.id.memory_card0:
                if (attempts%2==0) anterior = 0;
                else actual = 0;
                image_memory(0);
                break;
            case R.id.memory_card1:
                if (attempts%2==0) anterior = 1;
                else actual = 1;
                image_memory(1);
                break;
            case R.id.memory_card2:
                if (attempts%2==0) anterior = 2;
                else actual = 2;
                image_memory(2);
                break;
            case R.id.memory_card3:
                if (attempts%2==0) anterior = 3;
                else actual = 3;
                image_memory(3);
                break;
            case R.id.memory_card4:
                if (attempts%2==0) anterior = 4;
                else actual = 4;
                image_memory(4);
                break;
            case R.id.memory_card5:
                if (attempts%2==0) anterior = 5;
                else actual = 5;
                image_memory(5);
                break;
            case R.id.memory_card6:
                if (attempts%2==0) anterior = 6;
                else actual = 6;
                image_memory(6);
                break;
            case R.id.memory_card7:
                if (attempts%2==0) anterior = 7;
                else actual = 7;
                image_memory(7);
                break;
            case R.id.memory_card8:
                if (attempts%2==0) anterior = 8;
                else actual = 8;
                image_memory(8);
                break;
            case R.id.memory_card9:
                if (attempts%2==0) anterior = 9;
                else actual = 9;
                image_memory(9);
                break;
            case R.id.memory_card10:
                if (attempts%2==0) anterior = 10;
                else actual = 10;
                image_memory(10);
                break;
            case R.id.memory_card11:
                if (attempts%2==0) anterior = 11;
                else actual = 11;
                image_memory(11);
                break;
            case R.id.memory_card12:
                if (attempts%2==0) anterior = 12;
                else actual = 12;
                image_memory(12);
                break;
            case R.id.memory_card13:
                if (attempts%2==0) anterior = 13;
                else actual = 13;
                image_memory(13);
                break;
            case R.id.memory_card14:
                if (attempts%2==0) anterior = 14;
                else actual = 14;
                image_memory(14);
                break;
            case R.id.memory_card15:
                if (attempts%2==0) anterior = 15;
                else actual = 15;
                image_memory(15);
                break;

            case R.id.reset:
                reset_memory();
        }

        if (anterior != actual) { //no ha encertat la parella
            ++attempts;
            if (attempts % 2 == 0) {
                Integer aux = attempts/2;
                text_attempts.setText(aux.toString());
                if (cardVector[anterior] != cardVector[actual]) {
                    Handler handler = new Handler();
                    handler.postDelayed(new Runnable() {
                        public void run() {
                            reset_image(anterior, actual);
                            anterior = -1;
                            actual = -1;
                        }
                    }, 1000);
                }
                else {
                    ++trobats;
                    ImageButton memory_card1 = (ImageButton) findViewById(getResources().getIdentifier("memory_card"+actual,"id",MemoryActivity.this.getPackageName()));
                    ImageButton memory_card2 = (ImageButton) findViewById(getResources().getIdentifier("memory_card"+anterior,"id",MemoryActivity.this.getPackageName()));
                    memory_card1.setOnClickListener(null);
                    memory_card2.setOnClickListener(null);
                }
            }
        }
        if (trobats == 8) {
            Log.v("HE ACABAT", "!!!!!");
            helper.setIntents(attempts);
            reset_memory();
            set();
        }
    }

    public void reset_memory(){
        for(int i = 0; i < 16; ++i){
            ImageButton memory = (ImageButton) findViewById(getResources().getIdentifier("memory_card"+i,"id",MemoryActivity.this.getPackageName()));
            memory.setBackgroundResource(R.drawable.memory_fons);
        }
        TextView text_attempts = (TextView) findViewById(R.id.intents);
        text_attempts.setText("0");
        attempts = 0;
    }
}