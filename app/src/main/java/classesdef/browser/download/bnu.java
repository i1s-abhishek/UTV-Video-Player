package classesdef.browser.download;

import com.liulishuo.filedownloader.BaseDownloadTask;

/* renamed from: bnu */
public class bnu {

    /* renamed from: a */
    public BaseDownloadTask f16005a;

    /* renamed from: b */
    public int f16006b;

    /* renamed from: c */
    public String f16007c;

    /* renamed from: d */
    public byte f16008d;

    /* renamed from: e */
    public long f16009e;

    /* renamed from: f */
    public long f16010f;

    /* renamed from: g */
    public long f16011g;

    /* renamed from: h */
    public boolean f16012h;

    public bnu(BaseDownloadTask aye, boolean z) {
        this(aye);
        this.f16012h = z;
    }

    public bnu(BaseDownloadTask aye) {
        if (aye != null) {
            this.f16005a = aye;
            this.f16006b = aye.getId();
            this.f16007c = aye.getPath();
            this.f16008d = aye.getStatus();
            this.f16009e = aye.getLargeFileSoFarBytes();
            this.f16010f = aye.getLargeFileTotalBytes();
            long b = bpa.m18486b(this.f16007c, this.f16009e);
            this.f16011g = b <= 0 ? (long) (aye.getSpeed() * 1024) : b;
            this.f16011g = Math.abs(this.f16011g);
        }
    }
}
