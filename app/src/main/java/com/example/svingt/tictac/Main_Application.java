package com.example.svingt.tictac;

import android.app.Application;

/**
 * Created by svingt on 8/26/14.
 */
public class Main_Application extends Application {
    private int someInt = 20;

    public int getSomeInt(){
        return someInt;
    }
    public void addInt(){ someInt++; }
}
