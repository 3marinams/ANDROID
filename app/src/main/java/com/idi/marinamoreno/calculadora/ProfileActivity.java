package com.idi.marinamoreno.calculadora;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.Log;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Switch;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;


public class ProfileActivity extends BaseActivity implements View.OnClickListener {

    private Switch estat;
    private Switch toast;
    private ImageView ivImage;
    private String direccion_imagen = "";
    private SharedPreferences sp;
    private Boolean bEstat;
    private Boolean bToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        toast = (Switch) findViewById(R.id.S_toast);
        toast.setOnClickListener(this);


        estat = (Switch) findViewById(R.id.S_estat);
        estat.setOnClickListener(this);


        ImageButton ib = (ImageButton) findViewById(R.id.fotoperfil);

        ib.setOnClickListener(this);


        sp = getSharedPreferences("usuari", MODE_PRIVATE);
        bEstat = sp.getBoolean("notification_estat", false);
        //System.out.println(hideNotificationEstat);
        estat.setChecked(bEstat);

        bToast = sp.getBoolean("notification_toast", false);
        //System.out.println(hideNotificationEstat);
        toast.setChecked(bToast);

        Uri foto = Uri.parse(sp.getString("foto", ""));
        Picasso.with(ProfileActivity.this).load(foto).into(ib);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            Uri foto = data.getData();
            if (requestCode == 0) {

                ImageButton ib = (ImageButton) findViewById(R.id.fotoperfil);
                Picasso.with(ProfileActivity.this).load(foto).into(ib);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("foto", foto.toString());
                editor.apply();

            } else if (requestCode == 1) {

                ImageButton ib = (ImageButton) findViewById(R.id.fotoperfil);
                Picasso.with(ProfileActivity.this).load(foto).into(ib);
                SharedPreferences.Editor editor = sp.edit();
                editor.putString("foto", foto.toString());
                editor.apply();
            }
            super.UpdateImage(foto);
        }
    }


    public void onClick(View v){
        switch (v.getId()){
            case R.id.S_estat: {
                bEstat = estat.isChecked();
                if (bEstat) {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("notification_estat", true);
                    editor.apply();
                } else {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("notification_estat", false);
                    editor.apply();
                }
                break;
            }

            case R.id.S_toast:{
                bToast = toast.isChecked();
                if (bToast){
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("notification_toast", true);
                    editor.apply();

                } else {
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putBoolean("notification_toast", false);
                    editor.apply();
                }
                    break;
            }

            case R.id.fotoperfil:{
                Log.v("TAG", "FOTO PERFIL");
                final CharSequence[] items = { "Cámara", "Galeria",
                        "Cancelar" };
                AlertDialog.Builder builder = new AlertDialog.Builder(ProfileActivity.this);
                //builder.setTitle("Add Photo!");
                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int item) {
                        if (items[item].equals("Cámara")) {
                            /*Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            File f = new File(android.os.Environment
                                    .getExternalStorageDirectory(), "temp.jpg");
                            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));*/
                            Intent intent  = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                            //intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            startActivityForResult(intent, 0);
                        } else if (items[item].equals("Galeria")) {
                            Intent intent = new Intent(
                                    Intent.ACTION_PICK,
                                    android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                            intent.setType("image/*");
                            //intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                            startActivityForResult(
                                    Intent.createChooser(intent, "Select File"),
                                    1);
                        } else if (items[item].equals("Cancelar")) {
                            dialog.dismiss();
                        }
                    }
                });
                builder.show();
            }

            default:
                break;

        }


    }
}
