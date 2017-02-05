package com.idi.marinamoreno.calculadora;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;


public class LoginActivity extends Activity implements View.OnClickListener {

    DataBaseHleper helper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        Button entra = (Button) findViewById(R.id.entrar);
        entra.setOnClickListener(this);

        Button reg = (Button) findViewById(R.id.registre);
        reg.setOnClickListener(this);
    }

    public void onClick(View v){
        switch (v.getId()){
            case R.id.entrar:{

                Log.v ( "LOGIN CLICK", "ENTRAR");
                EditText username = (EditText) findViewById(R.id.username);
                Log.v ( "LOGIN CLICK", "seguimos 1");
                String str = username.getText().toString();
                Log.v ( "LOGINNNNNNNN", str);
                EditText pass = (EditText) findViewById(R.id.password);
                Log.v ( "LOGIN CLICK", "seguimos 2");
                String pass_str = pass.getText().toString();
                Log.v ( "LOGINNNN", pass_str);

                if(pass_str.equals("") && str.equals("")) {
                    Log.v("TAG", "QWERTY");
                    Toast pass1 = Toast.makeText(LoginActivity.this, "Cal que escriguis el teu nom d'usuari i contrasenya", Toast.LENGTH_SHORT);
                    pass1.show();
                }
                else {
                    helper = new DataBaseHleper(this);
                    String password = helper.searchPass(str, pass_str);

                    if (pass_str.equals(password)) {
                        Intent i = new Intent(LoginActivity.this, BaseActivity.class);
                        i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY | FLAG_ACTIVITY_CLEAR_TOP);
                        startActivity(i);
                    } else {
                        Toast pass1 = Toast.makeText(LoginActivity.this, "La contrasenya i l'usuari no coincideixen", Toast.LENGTH_SHORT);
                        pass1.show();
                    }
                }
                break;

            }

            case R.id.registre:{
                Log.v ( "LOGIN", "REGISTRE");
                Intent i = new Intent(getApplicationContext(), SignUpActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY| FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        }
    }
}
