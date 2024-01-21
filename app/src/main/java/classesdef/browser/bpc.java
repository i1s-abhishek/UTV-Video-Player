package classesdef.browser;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.webkit.MimeTypeMap;
import android.webkit.URLUtil;

import com.liulishuo.filedownloader.util.FileDownloadUtils;

import java.io.File;
import java.util.regex.Pattern;

import classesdef.browser.download.boi;
import classesdef.browser.download.bpd;
import classesdef.database.bnm;
import classesdef.inplayer.awt;
import hdplayer.xdplayer.videoplayer.R;


/* renamed from: bpc */
public class bpc {

    /* renamed from: a */
    private static String f16130a;

    /* renamed from: a */
    public static void m18496a(Context context, String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            try {
                ((ClipboardManager) context.getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText(str, str2));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: a */
    public static String m18490a(Context context) {
        if (TextUtils.isEmpty(f16130a)) {
            f16130a = context.getString(R.string.version, new Object[]{awt.m7207c(context)});
        }
        return f16130a;
    }

    /* renamed from: a */
    public static synchronized String m18491a(Context context, String str, int i, String str2, String str3, String str4) {
        String a;
        synchronized (bpc.class) {
            a = m18492a(context, str, i, str2, str3, str4, false);
        }
        return a;
    }

    /* renamed from: a */
    public static synchronized String m18492a(Context context, String str, int i, String str2, String str3, String str4, boolean z) {
        String str5;
        String str6;
        String str7;
        synchronized (bpc.class) {
            if (z) {
                try {
                    if (TextUtils.isEmpty(str4)) {
                        str7 = m18494a(str, str2, str3);
                        if (TextUtils.isEmpty(str7)) {
                            str7 = bos.m18407a(str) + bon.m18359a().mo23286a(i);
                        }
                    } else {
                        str7 = str4 + bon.m18359a().mo23286a(i);
                    }
                    str5 = m18493a(str7);
                } catch (Throwable th) {
                    throw th;
                }
            } else {
                String a = m18494a(str, str2, str3);
                if (TextUtils.isEmpty(a)) {
                    if (TextUtils.isEmpty(str4)) {
                        str6 = bos.m18407a(str);
                    } else {
                        str6 = m18493a(str4);
                    }
                    str5 = str6 + bon.m18359a().mo23286a(i);
                } else if (TextUtils.isEmpty(str4) || a.length() >= 10) {
                    str5 = m18493a(a);
                } else {
                    str5 = m18493a(str4) + "_" + a;
                }
            }
            File file = new File(boo.m18379c(context), str5);
            File file2 = new File(FileDownloadUtils.getTempPath(file.getAbsolutePath()));
            String substring = file.getName().substring(file.getName().lastIndexOf("."), file.getName().length());
            int i2 = 0;
            String substring2 = file.getName().substring(0, file.getName().lastIndexOf("."));
            while (true) {
                if (!file.exists() && !file2.exists() && !boi.m18319b().mo23275d(file.getName()) && !bnm.m18246a().mo23224b(context, file.getName())) {
                    break;
                }
                file = new File(boo.m18379c(context), substring2 + "_" + (System.currentTimeMillis() + ((long) i2)) + substring);
                file2 = new File(FileDownloadUtils.getTempPath(file.getAbsolutePath()));
                if (!file.exists() && !file2.exists() && !boi.m18319b().mo23275d(file.getName()) && !bnm.m18246a().mo23224b(context, file.getName())) {
                    str5 = file.getName();
                    break;
                }
                i2++;
            }
            if (str5.length() > 200) {
                str5 = str5.substring(str5.length() - 100, str5.length());
            }
        }
        return str5;
    }

    /* renamed from: a */
    public static String m18493a(String str) {
        return str.replace("?", "-").replace("*", "-").replace("$", "-").replace("&", "-").replace("\"", "").replace("/", "-").replace(":", "-").replace(" ", "-").replace("<", "-").replace(">", "-").replace("|", "-").replace("'", "_");
    }

    /* renamed from: a */
    public static String m18494a(String str, String str2, String str3) {
        String guessFileName = URLUtil.guessFileName(str, str3, str2);
        int lastIndexOf = guessFileName.lastIndexOf(46);
        if (str2 == null || str2.isEmpty() || lastIndexOf <= 1 || lastIndexOf >= guessFileName.length()) {
            return guessFileName;
        }
        MimeTypeMap singleton = MimeTypeMap.getSingleton();
        String substring = guessFileName.substring(0, lastIndexOf);
        String substring2 = guessFileName.substring(lastIndexOf + 1);
        if (str2.equals(singleton.getMimeTypeFromExtension(substring2))) {
            return substring + "." + substring2;
        }
        String extensionFromMimeType = singleton.getExtensionFromMimeType(str2);
        if (extensionFromMimeType == null || extensionFromMimeType.equals(substring2)) {
            return guessFileName;
        }
        return substring + "." + extensionFromMimeType;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        r0 = r2.lastIndexOf(46);
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m18497bb(String r2) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r2)
            if (r0 != 0) goto L_0x0052
            r0 = 35
            int r0 = r2.lastIndexOf(r0)
            r1 = 0
            if (r0 <= 0) goto L_0x0013
            java.lang.String r2 = r2.substring(r1, r0)
        L_0x0013:
            r0 = 63
            int r0 = r2.lastIndexOf(r0)
            if (r0 <= 0) goto L_0x001f
            java.lang.String r2 = r2.substring(r1, r0)
        L_0x001f:
            r0 = 47
            int r0 = r2.lastIndexOf(r0)
            if (r0 < 0) goto L_0x002d
            int r0 = r0 + 1
            java.lang.String r2 = r2.substring(r0)
        L_0x002d:
            boolean r0 = r2.isEmpty()
            if (r0 != 0) goto L_0x0052
            java.lang.String r0 = "[a-zA-Z_0-9\\.\\-\\(\\)\\%]+"
            boolean r0 = java.util.regex.Pattern.matches(r0, r2)
            if (r0 != 0) goto L_0x0043
            java.lang.String r0 = "."
            boolean r0 = r2.contains(r0)
            if (r0 == 0) goto L_0x0052
        L_0x0043:
            r0 = 46
            int r0 = r2.lastIndexOf(r0)
            if (r0 < 0) goto L_0x0052
            int r0 = r0 + 1
            java.lang.String r2 = r2.substring(r0)
            return r2
        L_0x0052:
            java.lang.String r2 = ""
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: bpc.m18497b(java.lang.String):java.lang.String");
    }
    public static String m18497b(String str) {
        int lastIndexOf;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        int lastIndexOf2 = str.lastIndexOf(35);
        if (lastIndexOf2 > 0) {
            str = str.substring(0, lastIndexOf2);
        }
        int lastIndexOf3 = str.lastIndexOf(63);
        if (lastIndexOf3 > 0) {
            str = str.substring(0, lastIndexOf3);
        }
        int lastIndexOf4 = str.lastIndexOf(47);
        if (lastIndexOf4 >= 0) {
            str = str.substring(lastIndexOf4 + 1);
        }
        if (!str.isEmpty()) {
            return ((Pattern.matches("[a-zA-Z_0-9\\.\\-\\(\\)\\%]+", str) || str.contains(".")) && (lastIndexOf = str.lastIndexOf(46)) >= 0) ? str.substring(lastIndexOf + 1) : "";
        }
        return "";
    }
    /* renamed from: a */
    public static void m18495a(Context context, bph bph) {
        try {
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setFlags(268435456);
            switch (bph.mo23352h()) {
                case 0:
                case 3:
                    intent.setType("image/*");
                    break;
                case 1:
                case 2:
                    intent.setType("video/*");
                    break;
                case 4:
                    intent.setType("audio/*");
                    break;
                case 5:
                    intent.setType("apk/*");
                    break;
                default:
                    intent.setType("*/*");
                    break;
            }
            intent.putExtra("android.intent.extra.STREAM", bpd.m18500a(context, bph.mo23327a(context)));
            intent.putExtra("android.intent.extra.TEXT", bph.mo23346e() + "\n\n" + bph.mo23339c());
            context.startActivity(Intent.createChooser(intent, context.getString(R.string.action_share)));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
