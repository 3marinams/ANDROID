package com.idi.marinamoreno.calculadora;

import android.support.annotation.BoolRes;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by marinamoreno on 3/2/17.
 */

public class Contact {

    private String name, username,pass;
    private Integer intents;

    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
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

    public void setIntents(Integer intents){
        this.intents = intents;
    }

    public Integer getIntents(){
        return this.intents;
    }
}
