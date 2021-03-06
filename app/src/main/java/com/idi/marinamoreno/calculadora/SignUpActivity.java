package com.idi.marinamoreno.calculadora;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.content.Intent.FLAG_ACTIVITY_CLEAR_TOP;

/**
 * Created by marinamoreno on 3/2/17.
 */

public class SignUpActivity extends Activity  implements View.OnClickListener{

    DataBaseHelper helper;
    @Override
    public void onCreate(Bundle saveInstanceState){
        Log.v("SIGN UP", "CREATE");
        super.onCreate(saveInstanceState);
        setContentView(R.layout.acivity_signup);

        Button reg = (Button) findViewById(R.id.sign_up);
        reg.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Log.v("SIGN UP", "CLICK");
        if (v.getId() == R.id.sign_up){
            Log.v("SIGN UP", "JOJOJOJOJOJOO");
            EditText name = (EditText) findViewById(R.id.name);
            //EditText email = (EditText) findViewById(R.id.email);
            EditText uname = (EditText) findViewById(R.id.username);
            EditText pass1 = (EditText) findViewById(R.id.password);
            EditText pass2 = (EditText) findViewById(R.id.confirm_password);

            String namestr = name.getText().toString();
            //String emailstr = email.getText().toString();
            String unamestr = uname.getText().toString();
            String pass1str = pass1.getText().toString();
            String pass2str = pass2.getText().toString();

            if ( !pass1str.equals(pass2str)){
                Toast pass = Toast.makeText(SignUpActivity.this, "Les contrasenyes no coincideixen", Toast.LENGTH_SHORT);
                pass.show();
            }
            else {
                //insert details in DB

                Log.v("ENTRO", "!!!!!!!!!");
                Contact c = new Contact();
                c.setName(namestr);
                Log.v("NAME: ", c.getName());
                c.setUsername(unamestr);
                Log.v("USER: ", c.getUsername());
                c.setPassword(pass1str);
                Log.v("PASS: ", c.getPassword());

                helper = new DataBaseHelper(this);
                helper.insertContact(c);

                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                i.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY| FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(i);
            }
        }
    }


}
