package classesdef.browser;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.text.TextUtils;

import java.util.List;

@SuppressLint({"NewApi"})
/* renamed from: boj */
public class boj {

    /* renamed from: a */
    private static boj f16064a;

    private boj() {
    }

    /* renamed from: a */
    public static synchronized boj m18335a() {
        boj boj;
        synchronized (boj.class) {
            if (f16064a == null) {
                f16064a = new boj();
            }
            boj = f16064a;
        }
        return boj;
    }

    /* renamed from: a */
    public boolean mo23279a(Context context) {
        try {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(8192);
            if (installedPackages == null || installedPackages.size() <= 0) {
                return false;
            }
            for (PackageInfo next : installedPackages) {
                if (!TextUtils.isEmpty(next.packageName) && next.packageName.equals("com.google.android.gm")) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } catch (Error e2) {
            e2.printStackTrace();
            return false;
        }
    }

    /* renamed from: b */
    public boolean mo23280b(Context context) {
        try {
            List<PackageInfo> installedPackages = context.getPackageManager().getInstalledPackages(8192);
            if (installedPackages == null || installedPackages.size() <= 0) {
                return false;
            }
            for (PackageInfo next : installedPackages) {
                if (!TextUtils.isEmpty(next.packageName) && next.packageName.equals("com.android.email")) {
                    return true;
                }
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        } catch (Error e2) {
            e2.printStackTrace();
            return false;
        }
    }
}
