package com.abhishek.xplayer.activities;

import android.os.Bundle;

import com.abhishek.xplayer.application.AppActivity;
import com.abhishek.xplayer.fragments.PasswordFragment;
import com.abhishek.xplayer.fragments.PermissionFragment;

import hdplayer.xdplayer.videoplayer.R;


public class SimpleFragmentActivity extends AppActivity {


    public int loadActivity() {
        return R.layout.activity_simple;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (getIntent() != null) {
            switch (getIntent().getIntExtra("_mode", 0)) {
                case 1:
                    AppActivity.loadFragmet(getSupportFragmentManager(), PasswordFragment.m12270a(3), false);
                    return;
                case 2:
                    AppActivity.loadFragmet(getSupportFragmentManager(), PermissionFragment.m12280a(), false);
                    return;
                default:
                    return;
            }
        }
    }

    /* renamed from: a */
    public void setTheme() {
        setResult(-1);
        finish();
    }
}
