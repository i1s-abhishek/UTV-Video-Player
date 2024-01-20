package classesdef.xdplayer;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Point;
import android.hardware.display.DisplayManager;
import android.os.Build;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

/* renamed from: axw */
public class axw {
    /* renamed from: a */
    public static int m7444a(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    /* renamed from: a */
    public static float m7442a(Context context, float f, boolean z) {
        return f / (z ? context.getResources().getDisplayMetrics().xdpi : context.getResources().getDisplayMetrics().ydpi);
    }

    /* renamed from: a */
    public static int m7443a(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT < 13) {
            return defaultDisplay.getWidth();
        }
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.x;
    }

    /* renamed from: b */
    public static int m7450b(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        if (Build.VERSION.SDK_INT < 13) {
            return defaultDisplay.getHeight();
        }
        Point point = new Point();
        defaultDisplay.getSize(point);
        return point.y;
    }

    /* renamed from: a */
    public static int m7445a(Resources resources) {
        int identifier = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (identifier > 0) {
            return resources.getDimensionPixelSize(identifier);
        }
        return 0;
    }

    /* renamed from: c */
    public static Point displaySize(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        if (Build.VERSION.SDK_INT >= 13) {
            defaultDisplay.getSize(point);
        } else {
            point.x = defaultDisplay.getWidth();
            point.y = defaultDisplay.getHeight();
        }
        return point;
    }

    /* renamed from: a */
    public static void m7446a(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().setStatusBarColor(i);
        }
    }

    /* renamed from: b */
    public static void m7451b(Activity activity, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            activity.getWindow().setNavigationBarColor(i);
        }
    }

    /* renamed from: d */
    public static boolean m7453d(Context context) {
        if (Build.VERSION.SDK_INT < 20) {
            return ((PowerManager) context.getSystemService("power")).isScreenOn();
        }
        for (Display state : ((DisplayManager) context.getSystemService("display")).getDisplays()) {
            if (state.getState() != 1) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    public static boolean m7448a(Bitmap bitmap) {
        return (bitmap == null || bitmap.isRecycled() || bitmap.getWidth() == 0 || bitmap.getHeight() == 0) ? false : true;
    }

    /* renamed from: a */
    public static boolean m7447a(Activity activity) {
        int b = m7449b(activity);
        return b == 1 || b == 9;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003e, code lost:
        return 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0041, code lost:
        return 9;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int m7449bx(Activity r7) {
        /*
            android.view.WindowManager r0 = r7.getWindowManager()
            android.view.Display r0 = r0.getDefaultDisplay()
            int r0 = r0.getRotation()
            android.util.DisplayMetrics r1 = new android.util.DisplayMetrics
            r1.<init>()
            android.view.WindowManager r7 = r7.getWindowManager()
            android.view.Display r7 = r7.getDefaultDisplay()
            r7.getMetrics(r1)
            int r7 = r1.widthPixels
            int r1 = r1.heightPixels
            r2 = 8
            r3 = 9
            r4 = 0
            r5 = 1
            if (r0 == 0) goto L_0x002b
            r6 = 2
            if (r0 != r6) goto L_0x002d
        L_0x002b:
            if (r1 > r7) goto L_0x0039
        L_0x002d:
            if (r0 == r5) goto L_0x0032
            r6 = 3
            if (r0 != r6) goto L_0x0035
        L_0x0032:
            if (r7 <= r1) goto L_0x0035
            goto L_0x0039
        L_0x0035:
            switch(r0) {
                case 0: goto L_0x0043;
                case 1: goto L_0x003c;
                case 2: goto L_0x003e;
                case 3: goto L_0x0041;
                default: goto L_0x0038;
            }
        L_0x0038:
            goto L_0x0043
        L_0x0039:
            switch(r0) {
                case 0: goto L_0x003c;
                case 1: goto L_0x0043;
                case 2: goto L_0x0041;
                case 3: goto L_0x003e;
                default: goto L_0x003c;
            }
        L_0x003c:
            r4 = 1
            goto L_0x0043
        L_0x003e:
            r4 = 8
            goto L_0x0043
        L_0x0041:
            r4 = 9
        L_0x0043:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.axw.m7449b(android.app.Activity):int");
    }
    public static int m7449b(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (((rotation != 0 && rotation != 2) || i2 <= i) && ((rotation != 1 && rotation != 3) || i <= i2)) {
            switch (rotation) {
                case 0:
                default:
                    return 0;
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
            }
        } else {
            switch (rotation) {
                case 1:
                    return 0;
                case 2:
                    return 9;
                case 3:
                    return 8;
            }
        }
        return 1;
    }

    public static int m7449bcc(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (((rotation == 0 || rotation == 2) && i2 > i) || ((rotation == 1 || rotation == 3) && i > i2)) {
            switch (rotation) {
                case 1:
                    return 0;
                case 2:
                    break;
                case 3:
                    break;
            }
        } else {
            switch (rotation) {
                case 1:
                    break;
                case 2:
                    break;
                case 3:
                    break;
                default:
                    return 0;
            }
        }
        return 1;
    }
    public static int m7449bxx(Activity activity) {
        int rotation = activity.getWindowManager().getDefaultDisplay().getRotation();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int i = displayMetrics.widthPixels;
        int i2 = displayMetrics.heightPixels;
        if (((rotation == 0 || rotation == 2) && i2 > i) || ((rotation == 1 || rotation == 3) && i > i2)) {
            if (rotation != 0) {
                if (rotation == 1) {
                    return 0;
                }
                if (rotation != 2) {
                }
                return 9;
            }
        } else if (rotation == 0) {
            return 0;
        } else {
            if (rotation != 1) {
                if (rotation != 2) {
                    if (rotation != 3) {
                        return 0;
                    }
                    return 9;
                }
                return 8;
            }
        }
        return 1;
    }


}
