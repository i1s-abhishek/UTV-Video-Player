package video.downloader.videodownloader.view;

import android.os.Handler;
import android.os.Looper;

public final class Main_Looper {

    public static final Handler f13821a = new Handler(Looper.getMainLooper());

    static {
        if (Looper.getMainLooper() == null) {
            Looper.prepareMainLooper();
        }
    }
}
