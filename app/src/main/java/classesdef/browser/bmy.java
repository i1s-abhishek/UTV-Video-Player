package classesdef.browser;

import android.app.Application;
import android.graphics.Bitmap;
import android.net.Uri;
import android.util.Log;
import android.util.LruCache;

import java.io.Closeable;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

import javax.inject.Inject;
import javax.inject.Singleton;

import classesdef.browser.tab.C3659b;
import classesdef.browser.tab.C4067c;
import classesdef.browser.tab.C4165e;
import classesdef.browser.tab.C4805t;
import classesdef.browser.tab.C4858u;
import classesdef.browser.tab.C4927w;

@Singleton
/* renamed from: bmy */
public class bmy {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final bnb f15805a = new bnb();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Application f15806b;

    /* renamed from: c */
    private final LruCache<String, Bitmap> f15807c = new LruCache<String, Bitmap>((int) bqi.m18945a(1)) {
        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int sizeOf(String str, Bitmap bitmap) {
            return bitmap.getByteCount();
        }
    };

    @Inject
    public bmy(Application application) {
        this.f15806b = application;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public Bitmap m18152a(String str) {
        Bitmap bitmap;
        bql.m18952a(str);
        synchronized (this.f15807c) {
            bitmap = this.f15807c.get(str);
        }
        return bitmap;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static File m18155b(Application application, Uri uri) {
        bna.m18171a(uri);
        String valueOf = String.valueOf(uri.getHost().hashCode());
        File cacheDir = application.getCacheDir();
        return new File(cacheDir, valueOf + ".png");
    }

    /* renamed from: a */
    public C4805t<Bitmap> mo23133a(final String str, final Bitmap bitmap, boolean z) {
        return C4805t.m21581a(new C4858u<Bitmap>() {
            /* renamed from: a */
            public void mo21407a(C4927w<Bitmap> wVar) {
                Uri a = bna.m18170a(str);
                if (a == null) {
                    wVar.mo25115a(bqw.m19010a(bitmap));
                    wVar.mo23729a();
                    return;
                }
                File a2 = bmy.m18155b(bmy.this.f15806b, a);
                Bitmap a3 = bmy.this.m18152a(str);
                if (a2.exists() && a3 == null) {
                    a3 = bmy.this.f15805a.mo23141a(a2);
                }
                if (a3 == null) {
                    wVar.mo25115a(bqw.m19010a(bitmap));
                    wVar.mo23729a();
                    return;
                }
                wVar.mo25115a(bqw.m19010a(a3));
                wVar.mo23729a();
            }
        });
    }

    /* renamed from: a */
    public C3659b mo23132a(final Bitmap bitmap, final String str) {
        return C3659b.m15696a((C4067c) new C4067c() {
            /* renamed from: a */
            public void mo21407a(C4165e eVar) {
                Uri a = bna.m18170a(str);
                if (a == null) {
                    eVar.mo23729a();
                    return;
                }
                Log.d("FaviconModel", "Caching icon for " + a.getHost());
                FileOutputStream fileOutputStream = null;
                try {
                    FileOutputStream fileOutputStream2 = new FileOutputStream(bmy.m18155b(bmy.this.f15806b, a));
                    try {
                        bitmap.compress(Bitmap.CompressFormat.PNG, 100, fileOutputStream2);
                        fileOutputStream2.flush();
                        bqw.m19016a((Closeable) fileOutputStream2);
                    } catch (IOException e) {
                        e = e;
                        fileOutputStream = fileOutputStream2;
                        try {
                            Log.e("FaviconModel", "Unable to cache favicon", e);
                            bqw.m19016a((Closeable) fileOutputStream);
                        } catch (Throwable th) {
                            th = th;
                            bqw.m19016a((Closeable) fileOutputStream);
                           // throw th;
                        }
                    } catch (Throwable th) {
                        th = th;
                        fileOutputStream = fileOutputStream2;
                        bqw.m19016a((Closeable) fileOutputStream);
                       // throw th;
                    }
                } catch (IOException e) {
                    e = e;
                    Log.e("FaviconModel", "Unable to cache favicon", e);
                    bqw.m19016a((Closeable) fileOutputStream);
                }
            }
        });
    }
}
