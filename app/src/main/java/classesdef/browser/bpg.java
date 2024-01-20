package classesdef.browser;

import android.content.ContentUris;
import android.net.Uri;

/* renamed from: bpg */
public class bpg {

    /* renamed from: a */
    private String f16139a = "";

    /* renamed from: b */
    private long f16140b;

    /* renamed from: c */
    private String f16141c;

    /* renamed from: a */
    public long mo23320a() {
        return this.f16140b;
    }

    /* renamed from: a */
    public void mo23321a(long j) {
        this.f16140b = j;
    }

    /* renamed from: b */
    public String mo23323b() {
        return this.f16139a;
    }

    /* renamed from: a */
    public void mo23322a(String str) {
        this.f16139a = str;
    }

    /* renamed from: c */
    public Uri mo23325c() {
        return ContentUris.withAppendedId(Uri.parse("content://media/external/audio/albumart"), mo23320a());
    }

    /* renamed from: d */
    public String mo23326d() {
        return this.f16141c;
    }

    /* renamed from: b */
    public void mo23324b(String str) {
        this.f16141c = str;
    }
}
