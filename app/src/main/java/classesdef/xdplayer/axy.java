package classesdef.xdplayer;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.TextView;

import com.abhishek.xplayer.ShareProvider;
import com.abhishek.xplayer.application.MyApplication;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Locale;
import java.util.TimeZone;

import classesdef.inplayer.awt;
import classesdef.inplayer.axc;

/* renamed from: axy */
public class axy {
    /* renamed from: a */
    public static String m7459a(long j) {
        int i = (int) (j / 1000);
        int i2 = i / 60;
        int i3 = i2 / 60;
        int i4 = i2 % 60;
        int i5 = i % 60;
        if (i3 == 0 && i4 == 0 && i5 == 0) {
            i5 = 0;
        }
        if (j < 3600000) {
            return String.format(Locale.ENGLISH, "%02d:%02d", new Object[]{Integer.valueOf(i4), Integer.valueOf(i5)});
        }
        return String.format(Locale.ENGLISH, "%02d:%02d:%02d", new Object[]{Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
    }

    /* renamed from: a */
    public static void m7468a(Cursor cursor) {
        if (cursor != null) {
            try {
                cursor.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static String m7460a(String str) {
        return m7461a(str, "");
    }

    /* renamed from: a */
    public static String m7461a(String str, String str2) {
        String str3;
        if (str == null) {
            return str2;
        }
        int max = Math.max(str.lastIndexOf(47), str.lastIndexOf(58));
        if (max >= 0) {
            int lastIndexOf = str.lastIndexOf(63);
            int i = max + 1;
            str3 = lastIndexOf > i ? str.substring(i, lastIndexOf) : str.substring(i);
        } else {
            str3 = null;
        }
        return TextUtils.isEmpty(str3) ? str2 : str3;
    }

    /* renamed from: a */
    public static void m7469a(TextView textView, Context context) {
        textView.setText(textView.getText().toString().toUpperCase(context.getResources().getConfiguration().locale));
    }

    /* renamed from: a */
    public static void m7464a(Activity activity, String str, String str2, String str3) {
        String c = awt.m7207c(MyApplication.getApplicationContext_());
        int a = awt.m7194a(MyApplication.getApplicationContext_());
        StringBuilder sb = new StringBuilder();
        if (str != null && !str.equals("")) {
            sb.append(str);
            sb.append("\n\n\n\n\n");
        }
        sb.append("XDPlayer ");
        sb.append(c);
        sb.append("_");
        sb.append(a);
        sb.append("\n\n");
        if (str2 != null) {
            sb.append(str2);
            sb.append(',');
        }
        sb.append("Model:");
        sb.append(Build.MODEL);
        sb.append(",OS:v");
        sb.append(Build.VERSION.RELEASE);
        sb.append(",CPU:");
        if (Build.VERSION.SDK_INT >= 21) {
            String[] strArr = Build.SUPPORTED_ABIS;
            if (strArr != null) {
                sb.append('[');
                for (String append : strArr) {
                    sb.append(append);
                    sb.append(',');
                }
                sb.append(']');
            }
        } else {
            if (Build.CPU_ABI2 != null) {
                sb.append('[');
            }
            sb.append(Build.CPU_ABI);
            if (Build.CPU_ABI2 != null) {
                sb.append(',');
                sb.append(Build.CPU_ABI2);
                sb.append(']');
            }
        }
        sb.append(",ScreenSize:");
        sb.append(activity.getResources().getDisplayMetrics().widthPixels);
        sb.append("x");
        sb.append(activity.getResources().getDisplayMetrics().heightPixels);
        sb.append(",Screen density:");
        sb.append(activity.getResources().getDisplayMetrics().densityDpi);
        sb.append(",Total Memory:");
        sb.append(axj.m7363a());
        sb.append(",Free Memory:");
        sb.append(axj.m7364b());
        sb.append("M,");
        sb.append(TimeZone.getDefault().getDisplayName(false, 0));
        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.setType("application/octet-stream");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"androdeveloper.feedback@gmail.com"});
        String str4 = str3 + " " + c;
        intent.putExtra("android.intent.extra.SUBJECT", str4);
        intent.putExtra("android.intent.extra.TEXT", sb.toString());
        if (m7470a((Context) activity)) {
            intent.setPackage("com.google.android.gm");
            intent.setFlags(268435456);
        }
        activity.startActivity(Intent.createChooser(intent, str4));
    }

    /* renamed from: a */
    public static void m7465a(Activity activity, String str, String str2, String str3, boolean z) {
        String str4;
        StringBuilder sb = new StringBuilder();
        if (z) {
            str4 = "email=" + str2;
            sb.append("Email:");
            sb.append(str2);
            sb.append(10);
        } else {
            str4 = awt.m7205b(MyApplication.getApplicationContext_());
            str3 = str2 + "#" + str3;
        }
        String a = axk.m7366a(str4, str3);
        if (a != null) {
            sb.append("User ID:");
            sb.append(a);
            sb.append(10);
        }
        Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
        intent.setType("application/octet-stream");
        intent.putExtra("android.intent.extra.EMAIL", new String[]{"androdeveloper.feedback@gmail.com"});
        intent.putExtra("android.intent.extra.SUBJECT", str);
        intent.putExtra("android.intent.extra.TEXT", sb.toString());
        if (m7470a((Context) activity)) {
            intent.setPackage("com.google.android.gm");
            intent.setFlags(268435456);
        }
        activity.startActivity(Intent.createChooser(intent, str));
    }

    /* renamed from: a */
    public static boolean m7470a(Context context) {
        return awt.m7202a(context, "com.google.android.gm");
    }

    /* renamed from: a */
    public static Locale getLocal(Context context, int i) {
        switch (i) {
            case 0:
                return Locale.ENGLISH;
            case 1:
                return Locale.GERMANY;
            case 2:
                return new Locale("es");
            case 3:
                return Locale.FRENCH;
            case 4:
                return new Locale("in");
            case 5:
                return new Locale("pt");
            case 6:
                return new Locale("ru");
            case 7:
                return new Locale("ar");
            case 8:
                return new Locale("cs");
            case 9:
                return new Locale("it");
            case 10:
                return Locale.JAPANESE;
            case 11:
                return Locale.KOREAN;
            case 12:
                return new Locale("pl");
            case 13:
                return Locale.SIMPLIFIED_CHINESE;
            case 14:
                return Locale.TRADITIONAL_CHINESE;
            case 15:
                return new Locale("el");
            case 16:
                return new Locale("fa");
            case 17:
                return new Locale("hi");
            case 18:
                return new Locale("hu");
            case 19:
                return new Locale("nl");
            case 20:
                return new Locale("th", "TH");
            case 21:
                return new Locale("tr");
            case 22:
                return new Locale("uk");
            case 23:
                return new Locale("sv");
            case 24:
                return new Locale("ms");
            case 25:
                return new Locale("vi");
            case 26:
                return new Locale("da");
            case 27:
                return new Locale("ro");
            case 28:
                return new Locale("sk");
            case 29:
                return new Locale("fi");
            case 30:
                return new Locale("fil");
            default:
                return Resources.getSystem().getConfiguration().locale;
        }
    }

    /* renamed from: b */
    public static String cacheFolderAddresh(Context context) {
        return axc.appFolder() + "/.cache";
    }

    /* renamed from: a */
    public static float m7458a(CharSequence charSequence, float f) {
        if (charSequence == null) {
            return f;
        }
        try {
            return Float.parseFloat(charSequence.toString());
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    /* renamed from: a */
    public static boolean m7471a(Closeable closeable) {
        if (closeable == null) {
            return false;
        }
        try {
            closeable.close();
            return true;
        } catch (IOException unused) {
            return false;
        }
    }

    /* renamed from: a */
    public static void m7467a(Context context, String str, String str2) {
        String str3 = "market://details?id=" + str;
        String str4 = "https://play.google.com/store/apps/details?id=" + str;
        if (str2 != null) {
            str3 = str3 + str2;
            str4 = str4 + str2;
        }
        if (awt.m7202a(context, "com.android.vending")) {
            try {
                Uri parse = Uri.parse(str3);
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setFlags(268435456);
                intent.setClassName("com.android.vending", "com.google.android.finsky.activities.MainActivity");
                intent.setData(parse);
                context.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
                try {
                    Uri parse2 = Uri.parse(str4);
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setPackage("com.android.vending");
                    intent2.setFlags(268435456);
                    intent2.setData(parse2);
                    context.startActivity(intent2);
                } catch (Exception e2) {
                    e2.printStackTrace();
                    try {
                        Uri parse3 = Uri.parse(str4);
                        Intent intent3 = new Intent("android.intent.action.VIEW");
                        intent3.setFlags(268435456);
                        intent3.setData(parse3);
                        context.startActivity(intent3);
                    } catch (Exception e3) {
                        e3.printStackTrace();
                    }
                }
            }
        } else {
            try {
                Uri parse4 = Uri.parse(str4);
                Intent intent4 = new Intent("android.intent.action.VIEW");
                intent4.setFlags(268435456);
                intent4.setData(parse4);
                context.startActivity(intent4);
            } catch (Exception e4) {
                e4.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m7463a(Activity activity, String str, String str2) {
        if (str != null && activity != null && str2 != null) {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.putExtra("android.intent.extra.STREAM", ShareProvider.m11567a(new File(str)));
            intent.setType(str2);
            intent.setFlags(4194304);
            intent.addFlags(1);
            try {
                activity.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static void m7466a(Activity activity, Collection<String> collection, String str) {
        if (collection != null && activity != null && str != null) {
            Intent intent = new Intent("android.intent.action.SEND_MULTIPLE");
            ArrayList arrayList = new ArrayList(collection.size());
            for (String file : collection) {
                arrayList.add(ShareProvider.m11567a(new File(file)));
            }
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            intent.setType(str);
            intent.setFlags(4194304);
            intent.addFlags(1);
            try {
                activity.startActivity(intent);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
