package classesdef.xdplayer;

import android.content.Context;
import android.os.PowerManager;
import android.text.TextUtils;


import com.liulishuo.filedownloader.BaseDownloadTask;

import org.greenrobot.eventbus.EventBus;

import java.util.HashMap;

import classesdef.eventbus.bnv;

/* renamed from: bpe */
public class bpe {

    /* renamed from: a */
    private static bpe f16135a;

    /* renamed from: b */
    private PowerManager.WakeLock f16136b;

    /* renamed from: c */
    private HashMap<String, BaseDownloadTask> f16137c = new HashMap<>();

    /* renamed from: a */
    public static bpe m18520a() {
        if (f16135a == null) {
            f16135a = new bpe();
        }
        return f16135a;
    }

    /* renamed from: a */
    public void mo23314a(Context context) {
        try {
            if (this.f16136b == null) {
                this.f16136b = ((PowerManager) context.getSystemService("power")).newWakeLock(1, "instaget_background_run");
                this.f16136b.acquire();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: b */
    public void mo23317b() {
        try {
            if (!m18521e()) {
                if (this.f16136b != null && this.f16136b.isHeld()) {
                    this.f16136b.release();
                }
                this.f16136b = null;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    public int mo23318c() {
        if (this.f16137c != null) {
            return this.f16137c.size();
        }
        return 0;
    }

    /* renamed from: d */
    public HashMap<String, BaseDownloadTask> mo23319d() {
        if (this.f16137c == null) {
            this.f16137c = new HashMap<>();
        }
        return this.f16137c;
    }

    /* renamed from: a */
    public synchronized void mo23316a(String str, BaseDownloadTask aye) {
        if (this.f16137c == null) {
            this.f16137c = new HashMap<>();
        }
        if (!TextUtils.isEmpty(str) && aye != null && !this.f16137c.containsKey(str)) {
            this.f16137c.put(str, aye);
            EventBus.getDefault().post(new bnv());
        }
    }

    /* renamed from: a */
    public void mo23315a(String str) {
        if (this.f16137c != null && !TextUtils.isEmpty(str)) {
            this.f16137c.remove(str);
            EventBus.getDefault().post(new bnv());
        }
    }

    /* renamed from: e */
    private boolean m18521e() {
        if (this.f16137c == null) {
            return false;
        }
        try {
            for (String str : this.f16137c.keySet()) {
                BaseDownloadTask aye = this.f16137c.get(str);
                if (aye != null && (aye.getStatus() == 1 || aye.getStatus() == 2 || aye.getStatus() == 6 || aye.getStatus() == 5 || aye.getStatus() == 3)) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
