package classesdef.browser;

import android.content.Context;
import android.support.v4.media.session.PlaybackStateCompat;

import com.liulishuo.filedownloader.util.FileDownloadHelper;


/* renamed from: bnc */
public class bnc implements FileDownloadHelper.ConnectionCountAdapter {

    /* renamed from: a */
    private Context f15819a;

    public bnc(Context context) {
        this.f15819a = context;
    }

    /* renamed from: a */
    public int determineConnectionCount(int i, String str, String str2, long j) {
        if (j < PlaybackStateCompat.ACTION_SET_CAPTIONING_ENABLED) {
            return 1;
        }
        return bqq.m18970a(this.f15819a);
    }
}
