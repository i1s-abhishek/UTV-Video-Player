package classesdef.browser.download;

import com.liulishuo.filedownloader.BaseDownloadTask;
import com.liulishuo.filedownloader.FileDownloadListener;

/* renamed from: ayk */
public abstract class ayk extends FileDownloadListener {
    /* access modifiers changed from: protected */
    /* renamed from: a */
    public abstract void pending(BaseDownloadTask alt, long j, long j2);


    public abstract void progress(BaseDownloadTask alt, long j, long j2);


    public abstract void paused(BaseDownloadTask alt, long j, long j2);


    public void pending(BaseDownloadTask alt, int i, int i2) {
    }

    public void connected(BaseDownloadTask alt, String str, boolean z, long j, long j2) {
    }


    public void connected(BaseDownloadTask alt, String str, boolean z, int i, int i2) {
    }


    public void progress(BaseDownloadTask alt, int i, int i2) {
    }


    public void retry(BaseDownloadTask alt, Throwable th, int i, long j) {
    }


    public void retry(BaseDownloadTask alt, Throwable th, int i, int i2) {
    }


    public void paused(BaseDownloadTask alt, int i, int i2) {
    }
}
