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


public class MediaPlayerActivity extends BaseActivity implements View.OnClickListener{


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        super.setContentView(R.layout.activity_mediaplayer);

        ImageButton openFile = (ImageButton) this.findViewById(R.id.play);
        openFile.setOnClickListener(this);

        ImageButton pauseFile = (ImageButton) this.findViewById(R.id.pause);
        pauseFile.setOnClickListener(this);

        ImageButton stopFile = (ImageButton) this.findViewById(R.id.stop);
        stopFile.setOnClickListener(this);

        ImageButton selectFile = (ImageButton) this.findViewById(R.id.select);
        selectFile.setOnClickListener(this);

    }

    public void onClick(View v) {
        MediaPlayer mp = new MediaPlayer();
        switch(v.getId()) {
            case R.id.play: {
                Log.v("AUDIO", "PLAY");
                mp.start();
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
                selectSong();
            }
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (resultCode == RESULT_OK) {
            Log.v("AUDIO", "RESULT OK");
            if (requestCode == 10) {
                Uri selectedMusicUri = data.getData();
                if (selectedMusicUri != null) {
                    Log.v("TAG", "PLAAAAAAAAAY");
                    String pathFromUri = selectedMusicUri.getPath();
                    MediaPlayer mp = new MediaPlayer();
                    try {
                        Log.v("TAAAAAAAAAAAAAAG", pathFromUri);

                        mp.setDataSource(this, Uri.parse(pathFromUri));
                        //mp.prepare();
                        Log.v("TAG", "STAAAAAAAART");
                        mp.start();

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
        startActivityForResult(intent, 10);
    }

}