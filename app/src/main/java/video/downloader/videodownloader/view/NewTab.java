package video.downloader.videodownloader.view;

import android.content.Context;
import android.graphics.Bitmap;

import classesdef.browser.bqt;
import classesdef.browser.bqw;
import hdplayer.xdplayer.videoplayer.R;


class NewTab {

    private static Bitmap f13871a;

    private static Bitmap f13872b;

    private Bitmap f13873c = null;

    private String f13874d;

    private final Context f13875e;

    public NewTab(Context context) {
        this.f13875e = context;
        this.f13874d = context.getString(R.string.action_new_tab);
    }

    public void mo21683a(Bitmap bitmap) {
        if (bitmap == null) {
            this.f13873c = null;
        } else {
            this.f13873c = bqw.m19010a(bitmap);
        }
    }

    private static Bitmap m15418a(Context context, boolean z) {
        if (z) {
            if (f13871a == null) {
                f13871a = bqt.m18990a(context, R.drawable.ic_webpage, true);
            }
            return f13871a;
        }
        if (f13872b == null) {
            f13872b = bqt.m18990a(context, R.drawable.ic_webpage, false);
        }
        return f13872b;
    }

    public void mo21684a(String str) {
        if (str == null) {
            this.f13874d = "";
        } else {
            this.f13874d = str;
        }
    }

    public String mo21682a() {
        return this.f13874d;
    }

    public Bitmap mo21681a(boolean z) {
        if (this.f13873c == null) {
            return m15418a(this.f13875e, z);
        }
        return this.f13873c;
    }
}
