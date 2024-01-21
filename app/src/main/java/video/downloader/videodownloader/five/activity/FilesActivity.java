package video.downloader.videodownloader.five.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;

import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.bottomnavigation.BottomNavigationItemView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.ittianyu.bottomnavigationviewex.BottomNavigationViewEx;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;

import classesdef.browser.bni;
import classesdef.browser.bnq;
import classesdef.browser.DownloadFinishedFragment;
import classesdef.browser.bof;
import classesdef.browser.BrowserLogEvent;
import classesdef.eventbus.bnv;
import classesdef.xdplayer.LogEvents;
import classesdef.xdplayer.bpe;
import classesdef.xdplayer.bpj;
import hdplayer.xdplayer.videoplayer.R;

import q.rorbin.badgeview.QBadgeView;
import video.downloader.videodownloader.activity.MainActivity;
import video.downloader.videodownloader.five.view.MyViewPager;


public class FilesActivity extends BasePermissionActivity {

    public Toolbar toolbar;


    private MyViewPager f13705d;

    private DownloadFinishedFragment f13706e;

    private QBadgeView qBadgeView;
    
    public BottomNavigationItemView f13708h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public float f13709i;

    /* renamed from: j */
    private QBadgeView qBadgeView2;

    /* renamed from: b */
    private void m15225b() {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_files);
        EventBus.getDefault().register((Object) this);
        int intExtra = getIntent().getIntExtra("position", 2);
        if (getIntent().hasExtra("curRecordId")) {
            getIntent().getLongExtra("curRecordId", -1);
        }
        this.toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (intExtra == 1) {
            this.toolbar.setTitle((CharSequence) getString(R.string.progress).toUpperCase());
        } else if (intExtra == 2) {
            this.toolbar.setTitle((CharSequence) getString(R.string.finished).toUpperCase());
        }
        this.toolbar.setTitle((int) R.string.downloads);
        setSupportActionBar(this.toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        this.toolbar.setNavigationIcon((int) R.mipmap.close);
        BottomNavigationViewEx bottomNavigationViewEx = (BottomNavigationViewEx) findViewById(R.id.bottom_nav_view);
        this.f13705d = (MyViewPager) findViewById(R.id.viewpager);
        ArrayList arrayList = new ArrayList();
        arrayList.add(bof.m18298a(0));
        this.f13706e = new DownloadFinishedFragment();
        arrayList.add(this.f13706e);
        this.f13705d.setAdapter(new bni(getSupportFragmentManager(), arrayList));
        this.f13705d.setEnableScroll(false);
        this.f13705d.setCurrentItem(intExtra);
        this.f13705d.setOffscreenPageLimit(3);
        bottomNavigationViewEx.setCurrentItem(intExtra);
        bottomNavigationViewEx.setupWithViewPager((ViewPager) this.f13705d, false);
        bottomNavigationViewEx.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            /* renamed from: a */
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.getItemId() != R.id.menu_tab) {
                    return true;
                }
                Intent intent = new Intent(FilesActivity.this, MainActivity.class);
                intent.setFlags(131072);
                FilesActivity.this.startActivity(intent);
                FilesActivity.this.finish();
                BrowserLogEvent.downloaderLogEvent(FilesActivity.this, "main page", "bottom menu:click browser tab");
                return true;
            }
        });
        this.f13705d.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            public void onPageScrollStateChanged(int i) {
            }

            public void onPageScrolled(int i, float f, int i2) {
            }

            public void onPageSelected(int i) {
                if (i == 1) {
                    FilesActivity.this.toolbar.setTitle((CharSequence) FilesActivity.this.getString(R.string.progress).toUpperCase());
                } else if (i == 2) {
                    FilesActivity.this.toolbar.setTitle((CharSequence) FilesActivity.this.getString(R.string.finished).toUpperCase());
                }
            }
        });
        this.f13708h = (BottomNavigationItemView) bottomNavigationViewEx.findViewById(R.id.menu_progress);
        this.f13708h.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
                float unused = FilesActivity.this.f13709i = (float) FilesActivity.this.f13708h.getWidth();
                FilesActivity.this.m15224a();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        LogEvents.m18498d("DownloadsPage");
    }

    /* access modifiers changed from: private */
    public void m15224a() {
        if (this.qBadgeView == null) {
            this.qBadgeView = new QBadgeView(this);
        }
        this.qBadgeView.bindTarget((View) this.f13708h).setBadgeGravity(8388661).setGravityOffset(this.f13709i * 0.3f, 0.0f, false).setBadgeNumber(bpe.m18520a().mo23318c());
    }

    public void onResume() {
        super.onResume();
        bpj.m18578a((Context) this).mo23380c(0);
        bpj.m18578a((Context) this).mo23375b((Context) this);
        m15225b();
    }

    public void onPause() {
        super.onPause();
        bpj.m18578a((Context) this).mo23380c(0);
        bpj.m18578a((Context) this).mo23375b((Context) this);
    }

    public void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(bnv bnv) {
        if (this.qBadgeView != null) {
            m15224a();
        }
        if (this.qBadgeView2 != null && this.f13705d.getCurrentItem() != 2) {
            m15225b();
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEventMainThread(bnq bnq) {
        if (this.f13705d != null && this.f13705d.getCurrentItem() != bnq.f16002a) {
            this.f13705d.setCurrentItem(bnq.f16002a);
        }
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i != 4) {
            return super.onKeyDown(i, keyEvent);
        }
        if (this.f13705d == null || this.f13706e == null || this.f13705d.getCurrentItem() != 1 || this.f13706e.f16022a != 1) {
            finish();
            BrowserLogEvent.downloaderLogEvent(this, "main page", "click physic back");
            return true;
        }
        this.f13706e.mo23248f();
        return true;
    }
}
