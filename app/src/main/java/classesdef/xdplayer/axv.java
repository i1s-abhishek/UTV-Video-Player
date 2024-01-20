package classesdef.xdplayer;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.snackbar.Snackbar;
import com.abhishek.xplayer.application.MyApplication;

/* renamed from: axv */
public class axv {

    /* renamed from: a */
    private static String f6317a;

    /* renamed from: b */
    private static Toast f6318b;

    /* renamed from: c */
    private static Toast f6319c;

    /* renamed from: d */
    private static long f6320d;

    /* renamed from: e */
    private static long f6321e;

    /* renamed from: a */
    public static void m7439a(String str) {
        m7435a(MyApplication.getApplicationContext_(), str);
    }

    /* renamed from: a */
    public static void m7434a(int i) {
        Resources resources;
        Context a = MyApplication.getApplicationContext_();
        if (a != null && (resources = a.getResources()) != null) {
            m7435a(a, resources.getString(i));
        }
    }

    /* renamed from: b */
    public static void m7440b(int i) {
        Resources resources;
        Context a = MyApplication.getApplicationContext_();
        if (a != null && (resources = a.getResources()) != null) {
            m7441b(MyApplication.getApplicationContext_(), resources.getString(i));
        }
    }

    /* renamed from: a */
    private static void m7435a(Context context, String str) {
        if (f6318b != null) {
            f6321e = System.currentTimeMillis();
            if (!TextUtils.equals(str, f6317a)) {
                f6317a = str;
                f6318b.setText(str);
                f6318b.show();
            } else if (f6321e - f6320d > 0) {
                f6318b.show();
            }
        } else if (context != null) {
            try {
                f6318b = Toast.makeText(context.getApplicationContext(), str, 0);
                f6318b.show();
                f6320d = System.currentTimeMillis();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        f6320d = f6321e;
    }

    /* renamed from: b */
    private static void m7441b(Context context, String str) {
        if (f6319c != null) {
            f6321e = System.currentTimeMillis();
            if (!str.equals(f6317a)) {
                f6317a = str;
                f6319c.setText(str);
                f6319c.setGravity(17, 0, 0);
                f6319c.show();
            } else if (f6321e - f6320d > 0) {
                f6319c.setGravity(17, 0, 0);
                f6319c.show();
            }
        } else if (context != null) {
            try {
                f6319c = Toast.makeText(context.getApplicationContext(), str, 0);
                f6319c.setGravity(17, 0, 0);
                f6319c.show();
                f6320d = System.currentTimeMillis();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        f6320d = f6321e;
    }

    /* renamed from: a */
    public static void m7438a(View view, String str) {
        if (view != null) {
            Snackbar.make(view, (CharSequence) str, -1).show();
        }
    }

    /* renamed from: a */
    public static void m7436a(View view, int i) {
        if (view != null) {
            Snackbar.make(view, i, -1).show();
        }
    }

    /* renamed from: a */
    public static void m7437a(View view, int i, String str, View.OnClickListener onClickListener) {
        if (view != null) {
            Snackbar.make(view, i, -1).setAction(str, onClickListener).show();
        }
    }
}
