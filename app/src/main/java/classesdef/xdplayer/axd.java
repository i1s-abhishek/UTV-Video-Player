package classesdef.xdplayer;

import android.app.Notification;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.widget.RemoteViews;

import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;

/* renamed from: axd */
public class axd extends SimpleTarget<Bitmap> {

    /* renamed from: a */
    private final RemoteViews[] f6258a;

    /* renamed from: b */
    private final Context f6259b;

    /* renamed from: c */
    private final int f6260c;

    /* renamed from: d */
    private final Notification f6261d;

    /* renamed from: e */
    private final int f6262e;

    /* renamed from: f */
    private final String f6263f;

    /* renamed from: g */
    private final C1342a f6264g;

    /* renamed from: axd$a */
    public interface C1342a {
        /* renamed from: a */
        boolean mo10963a(String str);
    }

    public axd(Context context, String str, int i, int i2, int i3, Notification notification, int i4, C1342a aVar, RemoteViews... remoteViewsArr) {
        super(i2, i3);
        if (context == null) {
            throw new NullPointerException("Context must not be null!");
        } else if (notification == null) {
            throw new NullPointerException("Notification object can not be null!");
        } else if (remoteViewsArr == null) {
            throw new NullPointerException("RemoteViews object can not be null!");
        } else {
            this.f6263f = str;
            this.f6259b = context;
            this.f6262e = i;
            this.f6261d = notification;
            this.f6260c = i4;
            this.f6258a = remoteViewsArr;
            this.f6264g = aVar;
        }
    }

    /* renamed from: a */
    private void m7306a() {
        try {
            ((NotificationManager) this.f6259b.getSystemService("notification")).notify(this.f6260c, this.f6261d);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    public void onResourceReady(Bitmap bitmap, GlideAnimation<? super Bitmap> gmVar) {
        if (bitmap != null && !bitmap.isRecycled()) {
            if (this.f6264g == null || this.f6264g.mo10963a(this.f6263f)) {
                if (this.f6258a != null) {
                    for (RemoteViews imageViewBitmap : this.f6258a) {
                        imageViewBitmap.setImageViewBitmap(this.f6262e, bitmap);
                    }
                }
                m7306a();
            }
        }
    }
}
