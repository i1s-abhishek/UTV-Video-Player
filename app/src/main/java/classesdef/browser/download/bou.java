package classesdef.browser.download;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.support.v4.media.session.PlaybackStateCompat;
import android.text.TextUtils;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloader;
import com.liulishuo.filedownloader.util.FileDownloadHelper;
import com.mopub.common.Constants;
import com.orhanobut.logger.Logger;


import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;

import classesdef.browser.DownloadFinishedFragment;
import classesdef.browser.bok;
import classesdef.browser.BrowserLogEvent;
import classesdef.browser.BrowserData;
import classesdef.browser.bov;
import classesdef.browser.bph;
import classesdef.browser.bqw;
import classesdef.database.bnm;
import classesdef.eventbus.awj;
import classesdef.xdplayer.bpe;
import classesdef.xdplayer.bpj;
import es.dmoral.toasty.Toasty;
import hdplayer.xdplayer.videoplayer.R;

public class bou {


    private static bou f16093b;


    private static ayk f16094d;
    /* access modifiers changed from: private */


    public ArrayList<String> f16095a = new ArrayList<>();


    private long f16096c = System.currentTimeMillis();


    private void m18414a(long j, long j2) {
    }

    /* renamed from: a */
    public static bou m18412a() {
        if (f16093b == null) {
            f16093b = new bou();
        }
        return f16093b;
    }

    /* renamed from: a */
    public void mo23299a(Context context, bph bph, boolean z) {
        if (!FileDownloader.getImpl().isServiceConnected()) {
            FileDownloader.getImpl().bindService();
        }
        BaseDownloadTask b = FileDownloader.getImpl().create(bph.mo23339c()).setPath(bph.mo23334b(context)).setTag((Object) bph)
                .setWifiRequired(!bpj.m18578a(context).mo23412s())
                .setAutoRetryTimes(2)
                .setCallbackProgressMinInterval((int) Constants.TEN_SECONDS_MILLIS)
                .setCallbackProgressTimes(1000);
        if (bph.mo23334b(context).contains("abmp3songs.in")) {
            b.addHeader("Referer", "http://www.sabsongs.net");
        }
        if (!TextUtils.isEmpty(bph.mo24644s())) {
            b.addHeader("Referer", bph.mo24644s());
        }
        if (!TextUtils.isEmpty(bph.mo23362q())) {
            b.addHeader("cookie", bph.mo23362q());
        }
        if (!TextUtils.isEmpty(bph.mo23363r())) {
            b.addHeader("User-Agent", bph.mo23363r());
        }
        b.asInQueueTask().enqueue();
        f16094d = m18426b();
        b.setListener( f16094d);
        FileDownloader.getImpl().start( f16094d, false);
        bpe.m18520a().mo23316a(bph.mo23334b(context), b);
        bpe.m18520a().mo23314a(FileDownloadHelper.getAppContext());
    }

    /* access modifiers changed from: private */
    public void m18415a(BaseDownloadTask aye) {
        Logger.e("pending", new Object[0]);
        EventBus.getDefault().post(new bnu(aye));
        bpe.m18520a().mo23316a(aye.getPath(), aye);
        bow.m18450a().mo23302a(FileDownloadHelper.getAppContext(), aye);
    }

    /* access modifiers changed from: private */
    public void m18427b(BaseDownloadTask aye) {
        Logger.e("started", new Object[0]);
        EventBus.getDefault().post(new bnu(aye));
        bpe.m18520a().mo23316a(aye.getPath(), aye);
        bow.m18450a().mo23302a(FileDownloadHelper.getAppContext(), aye);
    }

    /* access modifiers changed from: private */
    public void m18419a(BaseDownloadTask aye, boolean z) {
        Logger.e("connected , isContinue = " + z, new Object[0]);
        EventBus.getDefault().post(new bnu(aye));
        bpe.m18520a().mo23316a(aye.getPath(), aye);
        bow.m18450a().mo23302a(FileDownloadHelper.getAppContext(), aye);
        bok.m18344c(FileDownloadHelper.getAppContext(), aye.getPath());
    }

    /* access modifiers changed from: private */
    public void m18417a(BaseDownloadTask aye, long j, long j2) {
        if (!bpa.m18487b(aye.getPath())) {
            bpa.m18485a(aye.getPath(), j);
        }
        if (System.currentTimeMillis() - this.f16096c >= 1000) {
            this.f16096c = System.currentTimeMillis();
            m18414a(j2, j);
            EventBus.getDefault().post(new bnu(aye));
            bow.m18450a().mo23302a(FileDownloadHelper.getAppContext(), aye);
            bpe.m18520a().mo23316a(aye.getPath(), aye);
            return;
        }
        bpa.m18485a(aye.getPath(), j);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m18429c(BaseDownloadTask aye) {
        Logger.e("completed", new Object[0]);
        m18435f(aye);
        EventBus.getDefault().post(new bnu(aye));
        bpe.m18520a().mo23315a(aye.getPath());
        bpe.m18520a().mo23317b();
        bow.m18450a().mo23301a(FileDownloadHelper.getAppContext(), aye.getId());
        bok.m18344c(FileDownloadHelper.getAppContext(), aye.getPath());
        if (DownloadFinishedFragment.m18279g() != null) {
            DownloadFinishedFragment.m18279g().remove(aye.getUrl());
        }
        bpa.m18484a(aye.getPath());
        Context a = FileDownloadHelper.getAppContext();
        if (a != null && bpj.m18578a(a).mo23408o() < 2) {
            bpj.m18578a(a).mo23393f(bpj.m18578a(a).mo23409p() + 1);
            bpj.m18578a(a).mo23375b(a);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m18431d(BaseDownloadTask aye) {
        Logger.e("paused", new Object[0]);
        EventBus.getDefault().post(new bnu(aye));
        bpe.m18520a().mo23315a(aye.getPath());
        bpe.m18520a().mo23317b();
        bow.m18450a().mo23301a(FileDownloadHelper.getAppContext(), aye.getId());
        bpa.m18484a(aye.getPath());
    }

    /* access modifiers changed from: private */
    public void m18418a(final BaseDownloadTask aye, Throwable th) {
        EventBus cVar;
        bnu bnu;
        try {
            bpe.m18520a().mo23315a(aye.getPath());
            bpe.m18520a().mo23317b();
            if (bpj.m18578a(FileDownloadHelper.getAppContext()).mo23412s() && !bov.m18446a(FileDownloadHelper.getAppContext())) {
                final bph bph = (bph) aye.getTag();
                new Handler().postDelayed(new Runnable() {
                    public void run() {
                        if (bph != null && bov.m18447b(FileDownloadHelper.getAppContext()) && bou.this.f16095a != null && !bou.this.f16095a.contains(aye.getPath())) {
                            bou.this.f16095a.add(aye.getPath());
                            bou.this.mo23299a(FileDownloadHelper.getAppContext(), bph, true);
                        }
                    }
                }, 3000);
            }
            String message = th == null ? "" : th.getMessage();
            boolean z = !TextUtils.isEmpty(message) && message.contains("Only allows downloading this task on the wifi network type");
            bok.m18340a(FileDownloadHelper.getAppContext(), aye.getPath(), message);
            bow.m18450a().mo23301a(FileDownloadHelper.getAppContext(), aye.getId());
            bpa.m18484a(aye.getPath());
            if (aye.getRetryingTimes() == 2 || z || (th instanceof baa)) {
                boolean a = (this.f16095a == null || !bov.m18447b(FileDownloadHelper.getAppContext()) || this.f16095a.contains(aye.getPath())) ? false : m18425a(th, aye, message);
                if (!a) {
                    Context a2 = FileDownloadHelper.getAppContext();
                    bpd.m18514d(a2, ((bph) aye.getTag()).mo23352h() + "");
                }
                Logger.e("error = " + message, new Object[0]);
                if (!z && !a) {
                    Context a3 = FileDownloadHelper.getAppContext();
                    BrowserLogEvent.downloaderLogEvent(a3, "新下载器下载失败", "error message = " + message);
                    BrowserLogEvent.downloaderLogEvent(FileDownloadHelper.getAppContext(), "新下载器下载失败URL", aye.getUrl());
                    BrowserLogEvent.downloaderLogEvent(FileDownloadHelper.getAppContext(), "新下载器下载失败URL统计", bqw.m19011a(aye.getUrl()));
                }
                if (!TextUtils.isEmpty(message) && message.contains("The file is too large to store")) {
                    Toasty.custom(FileDownloadHelper.getAppContext(), FileDownloadHelper.getAppContext().getString(R.string.not_enough_space).toLowerCase(), (Drawable) null, FileDownloadHelper.getAppContext().getResources().getColor(R.color.toast_error), 1, false, true).show();
                }
                Context a4 = FileDownloadHelper.getAppContext();
                BrowserData.m18388a(a4, "下载失败 errorMessage = " + message + "...downloadUrl = " + aye.getUrl() + "...filePath = " + aye.getPath());
            }
            cVar = EventBus.getDefault();
            bnu = new bnu(aye);
        } catch (Exception e) {
            e.printStackTrace();
            cVar = EventBus.getDefault();
            bnu = new bnu(aye);
        } catch (Throwable th2) {
            EventBus.getDefault().post(new bnu(aye));
            throw th2;
        }
        cVar.post(bnu);
    }

    private boolean m18425a(Throwable th, BaseDownloadTask aye, String str) {
        bph bph;
        if ((!(th instanceof baa) && !str.toLowerCase().equals("timeout") && !str.toLowerCase().contains("not equal total") && !str.toLowerCase().contains("stream was reset:")) || (bph = (bph) aye.getTag()) == null) {
            return false;
        }
        mo23299a(FileDownloadHelper.getAppContext(), bph, true);
        this.f16095a.add(aye.getPath());
        return true;
    }

    /* access modifiers changed from: private */
    public void m18433e(BaseDownloadTask aye) {
        Logger.e("warn", new Object[0]);
        EventBus.getDefault().post(new bnu(aye));
        bow.m18450a().mo23302a(FileDownloadHelper.getAppContext(), aye);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m18416a(BaseDownloadTask aye, int i) {
        Logger.e("retry retryingTimes = " + i, new Object[0]);
        EventBus.getDefault().post(new bnu(aye));
        bow.m18450a().mo23302a(FileDownloadHelper.getAppContext(), aye);
    }


    private void m18435f(BaseDownloadTask aye) {
        Context a = FileDownloadHelper.getAppContext();
        if (a != null) {
            int h = ((bph) aye.getTag()).mo23352h();
            bpd.m18513c(a, h + "");
            if (bpj.m18578a(a).mo23404k()) {
                bpd.m18508a(a, aye.getPath());
            }
            bpj.m18578a(a).mo23368a(bpj.m18578a(a).mo23379c() + 1);
            bpj.m18578a(a).mo23380c(bpj.m18578a(a).mo23406m() + 1);
            bpj.m18578a(a).mo23375b(a);
            bnm.m18246a().mo23222a(a, aye.getFilename(), 2);
            Toasty.custom(a, a.getString(R.string.downloaded, new Object[]{((bph) aye.getTag()).mo23346e()}), (Drawable) null, a.getResources().getColor(R.color.toast_finish), 1, false, true).show();
            if (aye.getLargeFileTotalBytes() < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
                BrowserLogEvent.m18381a(a, "less 1M", bqw.m19011a(aye.getUrl()), aye.getUrl());
            }
            BrowserLogEvent.downloaderLogEvent(a, "download finished file size", bpd.m18503a(a, aye.getLargeFileTotalBytes()));
            if (h == 2 || h == 1) {
                EventBus.getDefault().post(new awj());
            }
        }
    }


    private ayk m18426b() {
        if (f16094d == null) {
            f16094d = new ayk() {
                /* access modifiers changed from: protected */
                public void pending(BaseDownloadTask aye, long j, long j2) {
                    bou.this.m18415a(aye);
                }

                /* access modifiers changed from: protected */
                public void started(BaseDownloadTask aye) {
                    bou.this.m18427b(aye);
                }

                /* access modifiers changed from: protected */
                public void connected(BaseDownloadTask aye, String str, boolean z, long j, long j2) {
                    bou.this.m18419a(aye, z);
                }

                /* access modifiers changed from: protected */
                public void progress(BaseDownloadTask aye, long j, long j2) {
                    bou.this.m18417a(aye, j, j2);
                }

                /* access modifiers changed from: protected */
                public void completed(BaseDownloadTask aye) {
                    bou.this.m18429c(aye);
                }

                /* access modifiers changed from: protected */
                public void paused(BaseDownloadTask aye, long j, long j2) {
                    bou.this.m18431d(aye);
                }

                /* access modifiers changed from: protected */
                public void error(BaseDownloadTask aye, Throwable th) {
                    bou.this.m18418a(aye, th);
                }

                /* access modifiers changed from: protected */
                public void warn(BaseDownloadTask aye) {
                    bou.this.m18433e(aye);
                }

                /* access modifiers changed from: protected */
                public void retry(BaseDownloadTask aye, Throwable th, int i, long j) {
                    bou.this.m18416a(aye, i);
                }
            };
        }
        return f16094d;
    }
}
