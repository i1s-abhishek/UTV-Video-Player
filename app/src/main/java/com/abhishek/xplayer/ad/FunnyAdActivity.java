package com.abhishek.xplayer.ad;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import classesdef.inplayer.SharedPrefrence;
import classesdef.xdplayer.axy;
import hdplayer.xdplayer.videoplayer.R;


public class FunnyAdActivity extends AppCompatActivity {

    private FunnyCardNativeAd funnyCardNativeAd;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setWindow();
        setContentView((int) R.layout.funny_ad_activity);
        boolean themeStyle = false;
        if (getIntent() != null && getIntent().getBooleanExtra("blackStyle", false)) {
            themeStyle = true;
        }
        changeLanguage(this, SharedPrefrence.language(this));
        this.funnyCardNativeAd = FunnyCardAd.createInstance().mo16927c();
        if ( this.funnyCardNativeAd == null) {
            finish();
            return;
        }
        else{
        this.funnyCardNativeAd.mo16995a(this, (FrameLayout) findViewById(R.id.funny_ad_container), themeStyle);
            setBacgroundColor(themeStyle);
        }
    }


    private void setBacgroundColor(boolean z) {
        View findViewById = findViewById(R.id.effects_view);
        if (z) {
            if (findViewById != null) {
                findViewById.setBackgroundColor(-671088640);
            }
            View findViewById2 = findViewById(R.id.close_button);
            if (findViewById2 instanceof ImageView) {
                ((ImageView) findViewById2).setImageResource(R.mipmap.close);
            }
        }
    }


    public void changeLanguage(Context context, int i) {
        try {
            Configuration configuration = context.getResources().getConfiguration();
            configuration.locale = axy.getLocal(context, i);
            SharedPrefrence.setLangusgeType(context, i);
            context.getResources().updateConfiguration(configuration, (DisplayMetrics) null);
        } catch (Exception unused) {
        }
    }


    private void setWindow() {
        if (Build.VERSION.SDK_INT < 16) {
            getWindow().setFlags(1024, 1024);
        } else {
            getWindow().getDecorView().setSystemUiVisibility(4);
        }
    }

    public void onResume() {
        super.onResume();
        setWindow();
    }

    public void onDestroy() {
        super.onDestroy();
        if (this.funnyCardNativeAd != null) {
            this.funnyCardNativeAd.destroyad();
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4 || ( this.funnyCardNativeAd) == null || !this.funnyCardNativeAd.destroyad()) {
            return super.onKeyDown(i, keyEvent);
        }
        finish();
        return true;
    }
}
