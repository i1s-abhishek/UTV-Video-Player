package com.abhishek.xplayer.content;

import java.util.List;

/* renamed from: com.inshot.xplayer.content.a */
public class MediaFolder {

    /* renamed from: a */
    public String f10545a;

    /* renamed from: b */
    public String f10546b;

    /* renamed from: c */
    public List<MediaFileInfo> f10547c;

    /* renamed from: d */
    public boolean f10548d = false;

    /* renamed from: e */
    public int f10549e;

    /* renamed from: f */
    public List<MediaFileInfo> f10550f;

    /* renamed from: g */
    private long f10551g = -1;

    /* renamed from: h */
    private int f10552h = -1;

    /* renamed from: i */
    private long f10553i = -1;

    /* renamed from: j */
    private int f10554j = -1;

    /* renamed from: k */
    private MediaFileInfo mediaFileInfo;

    /* renamed from: l */
    private long f10556l;

    /* renamed from: m */
    private boolean f10557m;

    public MediaFolder(String str, String str2, List<MediaFileInfo> list) {
        this.f10545a = str;
        this.f10546b = str2;
        this.f10547c = list;
    }

    public MediaFolder(String str, String str2, List<MediaFileInfo> list, long j) {
        this.f10545a = str;
        this.f10546b = str2;
        this.f10547c = list;
        this.f10556l = j;
    }

    /* renamed from: a */
    public int mo17924a() {
        if (this.f10547c != null) {
            return this.f10547c.size();
        }
        return 0;
    }

    /* renamed from: a */
    public void mo17925a(boolean z) {
        this.f10557m = z;
    }

    /* renamed from: b */
    public boolean mo17926b() {
        return this.f10557m;
    }

    /* renamed from: c */
    public long mo17927c() {
        if (this.f10551g < 0 || this.f10552h != mo17924a()) {
            this.f10551g = 0;
            this.f10552h = mo17924a();
            if (this.f10547c != null) {
                for (MediaFileInfo mediaFileInfo : this.f10547c) {
                    this.f10551g += mediaFileInfo.f10496a;
                }
            }
        }
        return this.f10551g;
    }

    /* renamed from: d */
    public long mo17928d() {
        long j = 0;
        if (this.f10553i < 0 || this.f10554j != mo17924a()) {
            this.f10553i = 0;
            this.mediaFileInfo = null;
            this.f10554j = mo17924a();
            if (this.f10547c != null) {
                for (MediaFileInfo next : this.f10547c) {
                    long h = next.mo17895h();
                    if (next.mo17880a() == null) {
                        this.f10553i = Math.max(h, this.f10553i);
                    }
                    if (h > j) {
                        this.mediaFileInfo = next;
                        j = h;
                    }
                }
            }
        }
        return this.f10553i;
    }

    /* renamed from: e */
    public void mo17929e() {
        this.f10553i = -1;
    }

    /* renamed from: f */
    public long mo17930f() {
        return this.f10556l;
    }
}
