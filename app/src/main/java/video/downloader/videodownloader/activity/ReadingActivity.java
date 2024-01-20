package video.downloader.videodownloader.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import classesdef.browser.C4740s;
import classesdef.browser.bmr;
import classesdef.browser.bpn;
import classesdef.browser.bpt;
import classesdef.browser.bqt;
import classesdef.browser.bqw;
import classesdef.browser.tab.C0053ad;
import classesdef.browser.tab.C4805t;
import classesdef.browser.tab.C4858u;
import classesdef.browser.tab.C4892v;
import classesdef.browser.tab.C4927w;
import hdplayer.vlcplayer.videoplayer.R;
import video.downloader.videodownloader.app.BrowserApp;

public class ReadingActivity extends AppCompatActivity {
    @Inject
     bpn f13510a;

    private boolean f13511b;

    private String f13512c = null;
    /* access modifiers changed from: private */

    public int f13513d;
    /* access modifiers changed from: private */

    public ProgressDialog f13514e;

    private C0053ad f13515f;
    @BindView(R.id.textViewBody)
    TextView mBody;
    @BindView(R.id.textViewTitle)
    TextView mTitle;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static float m15006b(int i) {
        switch (i) {
            case 0:
                return 10.0f;
            case 1:
                return 14.0f;
            case 2:
                return 18.0f;
            case 3:
                return 22.0f;
            case 4:
                return 26.0f;
            case 5:
                return 30.0f;
            default:
                return 18.0f;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        BrowserApp.m15129g().mo21498a(this);
        overridePendingTransition(R.anim.slide_in_from_right, R.anim.fade_out_scale);
        this.f13511b = this.f13510a.mo23481t();
        if (this.f13511b) {
            setTheme(R.style.Theme_SettingsTheme_Dark);
            getWindow().setBackgroundDrawable(new ColorDrawable(bqt.m18991b(this)));
        } else {
            setTheme(R.style.Theme_SettingsTheme);
            getWindow().setBackgroundDrawable(new ColorDrawable(bqt.m18986a((Context) this)));
        }
        super.onCreate(bundle);
        setContentView((int) R.layout.reading_view);
        ButterKnife.bind((Activity) this);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        this.f13513d = this.f13510a.mo23428A();
        this.mBody.setTextSize(m15006b(this.f13513d));
        this.mTitle.setText(getString(R.string.untitled));
        this.mBody.setText(getString(R.string.loading));
        this.mTitle.setVisibility(4);
        this.mBody.setVisibility(4);
        if (!m15005a(getIntent())) {
            m15003a(getString(R.string.untitled), getString(R.string.loading_failed));
        }
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.reading, menu);
        MenuItem findItem = menu.findItem(R.id.invert_item);
        MenuItem findItem2 = menu.findItem(R.id.text_size_item);
        int a = bqt.m18988a((Context) this, this.f13511b);
        if (!(findItem == null || findItem.getIcon() == null)) {
            findItem.getIcon().mutate().setColorFilter(a, PorterDuff.Mode.SRC_IN);
        }
        if (!(findItem2 == null || findItem2.getIcon() == null)) {
            findItem2.getIcon().mutate().setColorFilter(a, PorterDuff.Mode.SRC_IN);
        }
        return super.onCreateOptionsMenu(menu);
    }

    /* renamed from: a */
    private boolean m15005a(Intent intent) {
        if (intent == null) {
            return false;
        }
        this.f13512c = intent.getStringExtra("ReadingUrl");
        if (this.f13512c == null) {
            return false;
        }
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle((CharSequence) bqw.m19011a(this.f13512c));
        }
        this.f13515f = m15002a(this.f13512c).mo24966a(C4740s.m21405c()).mo24968b(C4740s.m21406d()).mo23840a(new C4892v<C3507a>() {
            /* renamed from: b */
            public void mo21416b() {
                ProgressDialog unused = ReadingActivity.this.f13514e = new ProgressDialog(ReadingActivity.this);
                ReadingActivity.this.f13514e.setProgressStyle(0);
                ReadingActivity.this.f13514e.setCancelable(false);
                ReadingActivity.this.f13514e.setIndeterminate(true);
                ReadingActivity.this.f13514e.setMessage(ReadingActivity.this.getString(R.string.loading));
                ReadingActivity.this.f13514e.show();
                bmr.m18088a(ReadingActivity.this, ReadingActivity.this.f13514e);
            }

            /* renamed from: a */
            public void mo21366a(C3507a aVar) {
                if (aVar == null || aVar.mo21422a().isEmpty() || aVar.mo21423b().isEmpty()) {
                    ReadingActivity.this.m15003a(ReadingActivity.this.getString(R.string.untitled), ReadingActivity.this.getString(R.string.loading_failed));
                } else {
                    ReadingActivity.this.m15003a(aVar.mo21422a(), aVar.mo21423b());
                }
            }

            /* renamed from: a */
            public void mo21364a(Throwable th) {
                ReadingActivity.this.m15003a(ReadingActivity.this.getString(R.string.untitled), ReadingActivity.this.getString(R.string.loading_failed));
                if (ReadingActivity.this.f13514e != null && ReadingActivity.this.f13514e.isShowing()) {
                    ReadingActivity.this.f13514e.dismiss();
                    ProgressDialog unused = ReadingActivity.this.f13514e = null;
                }
            }

            /* renamed from: a */
            public void mo21414a() {
                if (ReadingActivity.this.f13514e != null && ReadingActivity.this.f13514e.isShowing()) {
                    ReadingActivity.this.f13514e.dismiss();
                    ProgressDialog unused = ReadingActivity.this.f13514e = null;
                }
            }
        });
        return true;
    }

    /* renamed from: a */
    private static C4805t<C3507a> m15002a(final String str) {
        return C4805t.m21581a(new C4858u<C3507a>() {
            /* renamed from: a */
            public void mo21407a(C4927w<C3507a> wVar) {
                try {
                    bpt a=null;// = //new bpr().mo23493a(str, (int) DefaultRetryPolicy.DEFAULT_TIMEOUT_MS, true);
                    wVar.mo25115a(new C3507a(a.mo23515i(), a.mo23513h()));
                } catch (Exception e) {
                    wVar.mo24022a(new Throwable("Encountered exception"));
                    Log.e("ReadingActivity", "Error parsing page", e);
                } catch (OutOfMemoryError e2) {
                    System.gc();
                    wVar.mo24022a(new Throwable("Out of memory"));
                    Log.e("ReadingActivity", "Out of memory", e2);
                }
                wVar.mo23729a();
            }
        });
    }

    /* renamed from: video.downloader.video.downloader.videodownloader.activity.ReadingActivity$a */
    private static class C3507a {

        /* renamed from: a */
        private final String f13521a;

        /* renamed from: b */
        private final String f13522b;

        public C3507a(String str, String str2) {
            this.f13521a = str;
            this.f13522b = str2;
        }

        /* renamed from: a */
        public String mo21422a() {
            return this.f13521a;
        }

        /* renamed from: b */
        public String mo21423b() {
            return this.f13522b;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m15003a(String str, String str2) {
        if (this.mTitle != null && this.mBody != null) {
            if (this.mTitle.getVisibility() == 4) {
                this.mTitle.setAlpha(0.0f);
                this.mTitle.setVisibility(0);
                this.mTitle.setText(str);
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mTitle, "alpha", new float[]{1.0f});
                ofFloat.setDuration(300);
                ofFloat.start();
            } else {
                this.mTitle.setText(str);
            }
            if (this.mBody.getVisibility() == 4) {
                this.mBody.setAlpha(0.0f);
                this.mBody.setVisibility(
                        0);
                this.mBody.setText(str2);
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mBody, "alpha", new float[]{1.0f});
                ofFloat2.setDuration(300);
                ofFloat2.start();
                return;
            }
            this.mBody.setText(str2);
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.f13515f.mo281c();
        if (this.f13514e != null && this.f13514e.isShowing()) {
            this.f13514e.dismiss();
            this.f13514e = null;
        }
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        if (isFinishing()) {
            overridePendingTransition(R.anim.fade_in_scale, R.anim.slide_out_to_right);
        }
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        int itemId = menuItem.getItemId();
        if (itemId == R.id.invert_item) {
            this.f13510a.mo23463e(!this.f13511b);
            Intent intent = new Intent(this, ReadingActivity.class);
            intent.putExtra("ReadingUrl", this.f13512c);
            startActivity(intent);
            finish();
        } else if (itemId != R.id.text_size_item) {
            finish();
        } else {
            View inflate = LayoutInflater.from(this).inflate(R.layout.dialog_seek_bar, (ViewGroup) null);
            final SeekBar seekBar = (SeekBar) inflate.findViewById(R.id.text_size_seekbar);
            seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
                public void onStartTrackingTouch(SeekBar seekBar) {
                }

                public void onStopTrackingTouch(SeekBar seekBar) {
                }

                public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                    ReadingActivity.this.mBody.setTextSize(ReadingActivity.m15006b(i));
                }
            });
            seekBar.setMax(5);
            seekBar.setProgress(this.f13513d);
            bmr.m18088a(this, new AlertDialog.Builder(this).setView(inflate).setTitle((int) R.string.size).setPositiveButton(17039370, (DialogInterface.OnClickListener) new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i) {
                    int unused = ReadingActivity.this.f13513d = seekBar.getProgress();
                    ReadingActivity.this.mBody.setTextSize(ReadingActivity.m15006b(ReadingActivity.this.f13513d));
                    ReadingActivity.this.f13510a.mo23449a(seekBar.getProgress());
                }
            }).show());
        }
        return super.onOptionsItemSelected(menuItem);
    }
}
