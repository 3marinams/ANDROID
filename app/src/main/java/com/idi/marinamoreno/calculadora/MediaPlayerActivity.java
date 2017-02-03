package com.idi.marinamoreno.calculadora;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.IBinder;
import android.provider.MediaStore;
import android.support.v4.content.CursorLoader;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.IOException;


public class MediaPlayerActivity extends BaseActivity implements View.OnClickListener, MediaPlayer.OnPreparedListener {

    private MediaPlayer mp;
    private Boolean selected = false;

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_mediaplayer);

        ImageButton playFile = (ImageButton) this.findViewById(R.id.play);
        playFile.setOnClickListener(this);

        ImageButton pauseFile = (ImageButton) this.findViewById(R.id.pause);
        pauseFile.setOnClickListener(this);

        ImageButton stopFile = (ImageButton) this.findViewById(R.id.stop);
        stopFile.setOnClickListener(this);

        ImageButton selectFile = (ImageButton) this.findViewById(R.id.select);
        selectFile.setOnClickListener(this);

        mp = new MediaPlayer();

        mp.setOnPreparedListener(this);

    }

    public void onClick(View v) {
        switch(v.getId()) {
            case R.id.play: {
                Log.v("AUDIO", "PLAY");
                if (selected) mp.prepareAsync();
            }
            case R.id.pause:{
                Log.v("AUDIO", "PAUSE");
                mp.pause();
            }
            case R.id.stop:{
                Log.v("AUDIO", "STOP");
                //mp.prepare();
                mp.stop();
            }
            case R.id.select:{
                Log.v("AUDIO", "SELECT");
                selected = true;
                selectSong();
            }
        }
    }

    public void onPrepared(MediaPlayer player) {
        player.start();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            Log.v("AUDIO", "RESULT OK");
            if (requestCode == 10) {
                Uri selectedMusicUri = data.getData();
                if (selectedMusicUri != null) {
                    Log.v("TAG", "PLAAAAAAAAAY");
                    try {

                        mp.setDataSource(this, selectedMusicUri);
                        //mp.prepare();
                        Log.v("TAG", "STAAAAAAAART");
                        mp.prepareAsync();

                    } catch (SecurityException e) {
                        e.printStackTrace();
                    } catch (IllegalStateException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    private void selectSong() {
        if (android.os.Build.VERSION.SDK_INT > Build.VERSION_CODES.M) {
            Log.v("TAG","versió mes alta d'API 23");
            int hasWriteContactsPermission = checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (hasWriteContactsPermission != PackageManager.PERMISSION_GRANTED) {
                Log.v("TAG","NO TINC PERMIS");
                requestPermissions(new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        0);
                return;
            }
        }

        Intent intent = new Intent(Intent.ACTION_PICK, android.provider.MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        Log.v("AUDIO", "VAIG A LLENÇAR INTENT");
        //intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
        startActivityForResult(intent, 10);
    }

}