package video.downloader.videodownloader.five.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

import classesdef.browser.bni;
import classesdef.browser.boe;
import classesdef.browser.BrowserLogEvent;
import hdplayer.xdplayer.videoplayer.R;
import video.downloader.videodownloader.five.view.MyViewPager;

public class HelpActivity extends AppCompatActivity {

    /* renamed from: a */
    public MyViewPager f13714a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_help);
        this.f13714a = (MyViewPager) findViewById(R.id.viewpager);
        ArrayList arrayList = new ArrayList();
        boe a = boe.m18293a(0);
        a.mo23260a(0, this.f13714a);
        arrayList.add(a);
        boe a2 = boe.m18293a(1);
        a2.mo23260a(1, this.f13714a);
        arrayList.add(a2);
        boe a3 = boe.m18293a(2);
        a3.mo23260a(2, this.f13714a);
        arrayList.add(a3);
        boe a4 = boe.m18293a(3);
        a4.mo23260a(3, this.f13714a);
        arrayList.add(a4);
        this.f13714a.setAdapter(new bni(getSupportFragmentManager(), arrayList));
        this.f13714a.setEnableScroll(true);
        this.f13714a.setOffscreenPageLimit(2);
    }

    public void onBackPressed() {
        super.onBackPressed();
        BrowserLogEvent.downloaderLogEvent(this, "guide", "直接关闭");
    }
}
