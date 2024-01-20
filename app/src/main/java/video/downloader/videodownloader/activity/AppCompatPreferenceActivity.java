package video.downloader.videodownloader.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.appcompat.app.AppCompatCallback;
import androidx.appcompat.app.AppCompatDelegate;

import hdplayer.vlcplayer.videoplayer.R;


public abstract class AppCompatPreferenceActivity extends PreferenceActivity {

    private AppCompatDelegate f13353a;

    public void onCreate(Bundle bundle) {
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out_scale);
        m14831a().installViewFactory();
        m14831a().onCreate(bundle);
        super.onCreate(bundle);
    }

    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        m14831a().onPostCreate(bundle);
    }

    public MenuInflater getMenuInflater() {
        return m14831a().getMenuInflater();
    }

    public void setContentView(int i) {
        m14831a().setContentView(i);
    }

    public void setContentView(View view) {
        m14831a().setContentView(view);
    }

    public void setContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m14831a().setContentView(view, layoutParams);
    }

    public void addContentView(View view, ViewGroup.LayoutParams layoutParams) {
        m14831a().addContentView(view, layoutParams);
    }

    public void onPostResume() {
        super.onPostResume();
        m14831a().onPostResume();
    }

    public void onTitleChanged(CharSequence charSequence, int i) {
        super.onTitleChanged(charSequence, i);
        m14831a().setTitle(charSequence);
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m14831a().onConfigurationChanged(configuration);
    }

    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            overridePendingTransition(R.anim.fade_in_scale, R.anim.slide_out_to_right);
        }
    }

    public void onStop() {
        super.onStop();
        m14831a().onStop();
    }

    public void onDestroy() {
        super.onDestroy();
        m14831a().onDestroy();
    }

    public void invalidateOptionsMenu() {
        m14831a().invalidateOptionsMenu();
    }


    private AppCompatDelegate m14831a() {
        if (this.f13353a == null) {
            this.f13353a = AppCompatDelegate.create((Activity) this, (AppCompatCallback) null);
        }
        return this.f13353a;
    }
}
