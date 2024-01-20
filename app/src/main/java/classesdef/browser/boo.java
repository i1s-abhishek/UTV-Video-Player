package classesdef.browser;

import android.content.Context;
import android.os.Environment;
import android.text.TextUtils;

import java.io.File;

import classesdef.xdplayer.bpj;

public class boo {

    private static String f16074a;


    private static String f16075b;


    public static String m18377a(Context context) {
        File file;
        if (TextUtils.isEmpty(f16074a)) {
            if (Environment.getExternalStorageState().equals("mounted")) {
                file = new File(Environment.getExternalStorageDirectory() + "/VideoPlayerHD" + "/crash/");
            } else {
                file = new File(context.getCacheDir().getAbsolutePath() + "/crash/");
            }
            if (!file.exists()) {
                file.mkdirs();
                if (!file.isDirectory()) {
                    file.mkdirs();
                }
            }
            f16074a = file.getAbsolutePath();
        }
        return f16074a;
    }


    public static synchronized String m18378b(Context context) {
        String str;
        File file;
        synchronized (boo.class) {
            if (TextUtils.isEmpty(f16075b)) {
                if (Environment.getExternalStorageState().equals("mounted")) {
                    file = new File(Environment.getExternalStorageDirectory() + "/VideoPlayerHD" + "/Download/");
                } else {
                    file = new File(context.getCacheDir().getAbsolutePath() + "/Download/");
                }
                if (!file.exists()) {
                    file.mkdirs();
                    if (!file.isDirectory()) {
                        file.mkdirs();
                    }
                }
                f16075b = file.getAbsolutePath();
            }
            str = f16075b;
        }
        return str;
    }


    public static String m18379c(Context context) {
        String u = bpj.m18578a(context).mo23414u();
        if (!TextUtils.isEmpty(u)) {
            File file = new File(u);
            if (file.exists() && file.canWrite()) {
                return u;
            }
        }
        bpj.m18578a(context).mo23382c(m18378b(context));
        bpj.m18578a(context).mo23375b(context);
        return m18378b(context);
    }
}
