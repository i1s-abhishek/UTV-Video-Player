package com.abhishek.xplayer.application;

import android.content.Context;
import android.content.res.Resources;

import androidx.appcompat.app.AppCompatActivity;

import classesdef.inplayer.awt;

public abstract class BaseActivity extends AppCompatActivity {
    public void attachBaseContext(Context context) {
        MyApplication.m12033a(context.getResources(), MyApplication.myApplication().mo17875f());
        super.attachBaseContext(context);
    }

    public Resources getResources() {
        Resources resources = super.getResources();
        MyApplication.m12033a(resources, MyApplication.myApplication().mo17875f());
        return resources;
    }

    public boolean isInMultiWindowMode() {
        return awt.m7199a() && super.isInMultiWindowMode();
    }
}
