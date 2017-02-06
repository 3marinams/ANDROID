package com.idi.marinamoreno.calculadora;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;



public class BaseActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, View.OnClickListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_base);
        setView();

    }

    protected void setView() {

        Log.v("SSEEEEET vIEW", "entro");

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        setTitle("");

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);


        View hView =  navigationView.getHeaderView(0);
        SharedPreferences mPrefs = getSharedPreferences("usuari",0);
        String str = mPrefs.getString("foto", "");
        Log.v("STR:", str);
        ImageView imageView = (ImageView) hView.findViewById(R.id.perfil);
        Log.v("TAAAAAAAAAAG", "setvieeeeeeeeeew");
        Picasso.with(BaseActivity.this).load(Uri.parse(str)).into(imageView);

        ImageButton logout = (ImageButton) findViewById(R.id.logout);
        logout.setOnClickListener(this);

        navigationView.setNavigationItemSelectedListener(this);

    }

    protected void UpdateImage(Uri path){

        Log.v("TAG", "update image");
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);


        View hView =  navigationView.getHeaderView(0);
        SharedPreferences mPrefs = getSharedPreferences("usuari",0);
        SharedPreferences.Editor edit = mPrefs.edit();
        edit.putString("foto", path.toString());
        edit.apply();

        String str = mPrefs.getString("foto", "");
        Log.v("STR:", str);
        ImageView imageView = (ImageView) hView.findViewById(R.id.perfil);
        Log.v("TAAAAAAAAAAG", "setvieeeeeeeeeew");
        Picasso.with(BaseActivity.this).load(path).into(imageView);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        setView();
        switch (id){
            case R.id.activity_calculadora: {
                Intent i = new Intent(getApplicationContext(),CalculadoraActivity.class);
                //i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
                break;
            }
            case R.id.activity_settings:{
                Intent i = new Intent(getApplicationContext(),ProfileActivity.class);
                //i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
                break;
            }
            case R.id.activity_profile:{
                Intent i = new Intent(getApplicationContext(),ProfileActivity.class);
                //i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
                break;
            }
            case R.id.activity_music:{
                Intent i = new Intent(getApplicationContext(),MediaPlayerActivity.class);
                //i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
                break;
            }

            case R.id.activity_game:{
                Intent i = new Intent(getApplicationContext(),MemoryActivity.class);
                //i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
                break;
            }
            case R.id.activity_ranking:{
                Intent i = new Intent(getApplicationContext(),RankingActivity.class);
                //i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(i);
                break;
            }
            /*case R.id.logout: {
                Log.v("TAG", "entro al logout");
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                break;
            }*/

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    @Override
    public void setContentView(int layout){
        DrawerLayout full = (DrawerLayout) getLayoutInflater().inflate(R.layout.activity_base,null);
        FrameLayout frame = (FrameLayout) full.findViewById(R.id.frame_base);

        getLayoutInflater().inflate(layout, frame,true );
        super.setContentView(full);
        setView();
    }

    public void onClick(View v){

        switch (v.getId()){
            case R.id.logout: {
                Log.v("TAG", "entro al logout");
                Intent i = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(i);
                break;
            }
        }

    }


}