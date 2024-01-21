package video.downloader.videodownloader.five.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import java.io.File;
import java.util.ArrayList;

import classesdef.browser.bnp;
import classesdef.browser.BrowserLogEvent;
import classesdef.browser.bot;
import classesdef.xdplayer.bpj;
import hdplayer.xdplayer.videoplayer.R;
import video.downloader.videodownloader.activity.FolderSelectActivity;


public class ChooseStorageActivity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<String> f13700b;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_choose_storage);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.f13700b = getIntent().getStringArrayListExtra("allPath");
        findViewById(R.id.rl_phone).setOnClickListener(this);
        findViewById(R.id.rl_sdcard).setOnClickListener(this);
        TextView textView = (TextView) findViewById(R.id.tv_phone_space);
        TextView textView2 = (TextView) findViewById(R.id.tv_sdcard_space);
        if (this.f13700b == null || this.f13700b.size() < 2) {
            finish();
            return;
        }
        textView.setText(bot.m18411a(this, this.f13700b.get(0)));
        textView2.setText(bot.m18411a(this, this.f13700b.get(1)));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        if (menuItem.getItemId() != 16908332) {
            return super.onOptionsItemSelected(menuItem);
        }
        onBackPressed();
        return true;
    }

    public void onClick(View view) {
        int id = view.getId();
        if (id == R.id.rl_phone) {
            BrowserLogEvent.downloaderLogEvent(this, "setting activity", "click download location select phone");
            startActivityForResult(new Intent(this, FolderSelectActivity.class), 108);
        } else if (id == R.id.rl_sdcard) {
            BrowserLogEvent.downloaderLogEvent(this, "setting activity", "click download location select sdcard");
            bnp bnp = new bnp();
            bnp.mo23236a((bnp.C3971a) new bnp.C3971a() {
                /* renamed from: a */
                public void mo21549a() {
                    BrowserLogEvent.downloaderLogEvent(ChooseStorageActivity.this, "choose storage activity", "select sdcard");
                    File file = new File(ChooseStorageActivity.this.f13700b.get(1));
                    if (file.exists() && file.canWrite()) {
                        bpj.m18578a((Context) ChooseStorageActivity.this).mo23382c(ChooseStorageActivity.this.f13700b.get(1));
                        bpj.m18578a((Context) ChooseStorageActivity.this).mo23375b((Context) ChooseStorageActivity.this);
                    }
                    ChooseStorageActivity.this.setResult(-1, new Intent());
                    ChooseStorageActivity.this.finish();
                }
            });
            bnp.mo23235a((Context) this);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 108 && i2 == -1) {
            setResult(-1, new Intent());
            finish();
        }
    }
}
