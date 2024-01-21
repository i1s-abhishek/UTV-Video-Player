package com.abhishek.xplayer.application;

import android.app.Activity;
import android.os.Bundle;
import android.view.ViewGroup;

import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import classesdef.inplayer.SharedPrefrence;
import hdplayer.xdplayer.videoplayer.R;


public abstract class AppActivity extends BaseActivity {

    
    private Toolbar toolbar;

    
    protected ViewGroup bacgrountActivity;

    
    private int theme;

    
    private Toolbarinterface toolbarinterface;

    public interface Toolbarinterface {
        
        boolean setToolbar();
    }

    public abstract int loadActivity();

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        InitilizationActivity.addInitilize((Activity) this);
        setTheme();
        setContentView(loadActivity());
        setVolumeControlStream(3);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            setSupportActionBar(toolbar);
            this.toolbar = toolbar;
        }
        this.bacgrountActivity = (ViewGroup) findViewById(R.id.act_bg);
    }

    
    private void setTheme() {
        SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).edit().putBoolean("darkTheme", true).apply();
        if (SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("darkTheme", false)) {
            this.theme = R.style.DarkTheme;
            setTheme(R.style.DarkTheme);
            return;
        }
        this.theme = R.style.NormalTheme;
        setTheme(R.style.NormalTheme);
    }

    
    public Toolbar mo17862d() {
        return this.toolbar;
    }

    
    public static void loadFragmet(FragmentManager fragmentManager, Fragment fragment, boolean z) {
        FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
        beginTransaction.replace(R.id.body, fragment);
        if (z) {
            beginTransaction.addToBackStack(fragment.getClass().getSimpleName());
        }
        beginTransaction.commitAllowingStateLoss();
    }

    
    public void setToolbarInstance(Toolbarinterface aVar) {
        this.toolbarinterface = aVar;
    }

    public void onBackPressed() {
        if (this.toolbarinterface == null || !this.toolbarinterface.setToolbar()) {
            super.onBackPressed();
        }
    }
}
