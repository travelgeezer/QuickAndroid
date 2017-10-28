package com.example.geezer.quickandroid.managers.app;

import android.app.Application;

import com.example.geezer.quickandroid.utils.Utils;


/**
 * Created by geezer. on 28/10/2017.
 */

public class SampleApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Utils.initialize(this);
    }
}
