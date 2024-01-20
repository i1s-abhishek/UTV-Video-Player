package classesdef.inplayer;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.Patterns;
import android.widget.ImageView;

import com.mopub.common.privacy.AdvertisingId;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;


public class awt {


    private static int f6148a = -1;


    private static String f6149b;


    private static String f6150c;


    public static boolean m7200a(int i, int i2) {
        return (i & i2) > 0;
    }


    public static int m7204b(long j, long j2) {
        int i = (j > j2 ? 1 : (j == j2 ? 0 : -1));
        if (i < 0) {
            return -1;
        }
        return i == 0 ? 0 : 1;
    }


    public static boolean m7199a() {
        return Build.VERSION.SDK_INT >= 24;
    }


    public static boolean m7206b() {
        return Build.VERSION.SDK_INT >= 21;
    }


    public static boolean m7202a(Context context, String packageName) {
        if (context == null || packageName == null || packageName.isEmpty()) {
            return false;
        }
        try {
            int applicationEnabledSetting = context.getPackageManager().getApplicationEnabledSetting(packageName);
            return applicationEnabledSetting == 0 || applicationEnabledSetting == 1;
        } catch (IllegalArgumentException | NullPointerException unused) {
            return false;
        }
    }


    public static void m7198a(ImageView imageView, int i) {
        if (imageView != null) {
            try {
                imageView.setImageResource(i);
            } catch (OutOfMemoryError e) {
                e.printStackTrace();
                imageView.setImageResource(0);
                imageView.setImageBitmap((Bitmap) null);
            }
        }
    }


    public static int m7194a(Context context) {
        if (f6148a == -1) {
            m7209e(context);
        }
        return f6148a;
    }


    public static String m7205b(Context context) {
        if (f6150c == null) {
            m7209e(context);
        }
        return f6150c;
    }


    public static String m7207c(Context context) {
        if (f6149b == null) {
            m7209e(context);
        }
        return f6149b;
    }


    private static void m7209e(Context context) {
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            f6148a = packageInfo.versionCode;
            f6149b = packageInfo.versionName;
            f6150c = packageInfo.packageName;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }


    public static <T> T[] m7203a(T[] tArr) {
        Random random = new Random();
        for (int length = tArr.length - 1; length >= 0; length--) {
            int nextInt = random.nextInt(length + 1);
            T t = tArr[length];
            tArr[length] = tArr[nextInt];
            tArr[nextInt] = t;
        }
        return tArr;
    }
    public static String m7196a(long j) {
        if (j <= 0) {
            return "0";
        }
        double d = (double) j;
        int log10 = (int) (Math.log10(d) / Math.log10(1024.0d));
        return new DecimalFormat("#,##0.#").format(d / Math.pow(1024.0d, (double) log10)) + " " + new String[]{"B", "kB", "MB", "GB", "TB"}[log10];
    }


    public static int m7195a(String str, int i) {
        if (str != null) {
            try {
                return Integer.parseInt(str);
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }


    public static void m7197a(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }


    public static class C1309a<T> {


        public T f6151a;

        public C1309a(T t) {
            this.f6151a = t;
        }
    }


    public static List<String> m7208d(Context context) {
        ArrayList arrayList = new ArrayList(3);
        Pattern pattern = Patterns.EMAIL_ADDRESS;
        try {
            for (Account account : AccountManager.get(context).getAccounts()) {
                if (pattern.matcher(account.name).matches()) {
                    arrayList.add(account.name);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }
}
