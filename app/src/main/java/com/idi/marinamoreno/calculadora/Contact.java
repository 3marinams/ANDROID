package com.idi.marinamoreno.calculadora;

import android.support.v7.app.AppCompatActivity;

/**
 * Created by marinamoreno on 3/2/17.
 */

public class Contact {
    //private int id;
    private String name, email, username,pass;

    /*public void setId(int id){
        this.id = id;
    }*/

    /*public int getId(){
        return this.id;
    }*/

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }

    public void setUsername(String user){
        this.username = user;
    }

    public String getUsername(){
        return this.username;
    }

    public void setPassword(String password){
        this.pass = password;
    }

    public String getPassword(){
        return this.pass;
    }
}
