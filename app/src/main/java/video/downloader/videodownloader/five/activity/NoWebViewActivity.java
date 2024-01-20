package video.downloader.videodownloader.five.activity;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import classesdef.browser.BrowserLogEvent;
import classesdef.browser.boq;
import hdplayer.vlcplayer.videoplayer.R;


public class NoWebViewActivity extends AppCompatActivity implements View.OnClickListener {
    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_no_webview);
        findViewById(R.id.iv_close).setOnClickListener(this);
        findViewById(R.id.tv_install).setOnClickListener(this);
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.iv_close) {
            BrowserLogEvent.downloaderLogEvent(this, "no webview activity", "close activity");
            finish();
            System.exit(0);
        } else if (id == R.id.tv_install) {
            BrowserLogEvent.downloaderLogEvent(this, "no webview activity", "go to google play");
            boq.m18382a().mo23296a(this, "com.google.android.webview");
            finish();
            System.exit(0);
        }
    }
}
