package classesdef.browser;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

/* renamed from: bqu */
public class bqu {
    /* renamed from: a */
    public static Drawable m18999a(Context context, PackageManager packageManager, String str) {
        try {
            PackageInfo packageArchiveInfo = packageManager.getPackageArchiveInfo(str, 0);
            if (packageArchiveInfo == null) {
                return null;
            }
            ApplicationInfo applicationInfo = packageArchiveInfo.applicationInfo;
            applicationInfo.sourceDir = str;
            applicationInfo.publicSourceDir = str;
            return applicationInfo.loadIcon(packageManager);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
