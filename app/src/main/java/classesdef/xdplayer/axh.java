package classesdef.xdplayer;

import android.content.Context;
import android.database.ContentObserver;
import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;

import java.util.HashSet;
import java.util.Set;

/* renamed from: axh */
public class axh {

    /* renamed from: a */
    private Context f6277a;

    /* renamed from: b */
    private ContentObserver f6278b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Handler f6279c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public C1349a f6280d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Set<Uri> f6281e = new HashSet();

    /* renamed from: axh$a */
    public interface C1349a {
        /* renamed from: a */
        void mo10977a(Set<Uri> set);
    }

    public axh(Context context, C1349a aVar, final int i) {
        this.f6277a = context;
        this.f6280d = aVar;
        this.f6279c = new Handler(context.getMainLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 801) {
                    axh.this.f6280d.mo10977a(axh.this.f6281e);
                    axh.this.f6281e.clear();
                }
            }
        };
        this.f6278b = new ContentObserver(this.f6279c) {
            public void onChange(boolean z, Uri uri) {
                super.onChange(z, uri);
                if (!z) {
                    axh.this.f6281e.add(uri);
                    axh.this.f6279c.removeMessages(801);
                    axh.this.f6279c.sendEmptyMessageDelayed(801, (long) i);
                }
            }
        };
    }

    /* renamed from: a */
    public void mo10973a() {
        this.f6277a.getContentResolver().registerContentObserver(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, true, this.f6278b);
        this.f6277a.getContentResolver().registerContentObserver(MediaStore.Video.Media.INTERNAL_CONTENT_URI, true, this.f6278b);
    }

    /* renamed from: b */
    public void mo10974b() {
        this.f6277a.getContentResolver().unregisterContentObserver(this.f6278b);
        this.f6279c.removeMessages(801);
    }
}
