package video.downloader.videodownloader.five.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentActivity;

import com.bumptech.glide.Glide;
import com.github.chrisbanes.photoview.PhotoView;

import java.io.File;

import classesdef.browser.bph;
import classesdef.xdplayer.LogEvents;
import hdplayer.vlcplayer.videoplayer.R;


public class ImagePreActivity extends AppCompatActivity {

    /* renamed from: a */
    private PhotoView f13715a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_image_pre);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setTitle((CharSequence) "");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.f13715a = (PhotoView) findViewById(R.id.iv_zoom);
        bph bph = (bph) getIntent().getSerializableExtra("record");
        if (bph == null) {
            finish();
            return;
        }
        File a = bph.mo23327a((Context) this);
        if (a.exists()) {
            Glide.with((FragmentActivity) this).load(a.getAbsolutePath()).into((ImageView) this.f13715a);
        } else {
            Glide.with((FragmentActivity) this).load(bph.mo23339c()).into((ImageView) this.f13715a);
        }
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        LogEvents.m18498d("ImagePreview");
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() == 16908332) {
            finish();
        }
        return super.onOptionsItemSelected(menuItem);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f13715a = null;
        Glide.with((Context) this).onLowMemory();
        System.gc();
    }
}
