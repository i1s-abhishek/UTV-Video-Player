package classesdef.inplayer;

import android.content.Context;
import android.content.Intent;
import android.media.MediaMetadataRetriever;
import android.net.Uri;
import android.os.Process;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Pair;

import com.abhishek.inplayer.bean.VideoPlayListBean;
import com.abhishek.xplayer.application.MyApplication;

import java.io.File;
import java.io.IOException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import java.util.Set;

import tv.danmaku.ijk.media.player.IMediaPlayer;

/* renamed from: axi */
public class axi {

    /* renamed from: a */
    private static Set<String> f6285a = new HashSet();

    static {
        f6285a.add("mp4");
        f6285a.add("mkv");
        f6285a.add("m4v");
        f6285a.add("mov");
        f6285a.add("3gp");
        f6285a.add("flv");
        f6285a.add("f4v");
        f6285a.add("webm");
    }

    /* renamed from: a */
    public static boolean m7358a(String str) {
        int lastIndexOf;
        if (str != null && (lastIndexOf = str.lastIndexOf(46)) >= 0) {
            if (f6285a.contains(str.substring(lastIndexOf + 1).toLowerCase(Locale.ENGLISH))) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0029 A[SYNTHETIC, Splitter:B:17:0x0029] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0035 A[SYNTHETIC, Splitter:B:26:0x0035] */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long m7359bb(String r6) {
        /*
            r0 = -1
            r2 = 0
            android.media.MediaMetadataRetriever r3 = new android.media.MediaMetadataRetriever     // Catch:{ Exception -> 0x0032, all -> 0x0025 }
            r3.<init>()     // Catch:{ Exception -> 0x0032, all -> 0x0025 }
            r3.setDataSource(r6)     // Catch:{ Exception -> 0x0033, all -> 0x0023 }
            r6 = 9
            java.lang.String r6 = r3.extractMetadata(r6)     // Catch:{ Exception -> 0x0033, all -> 0x0023 }
            if (r6 == 0) goto L_0x0018
            long r4 = java.lang.Long.parseLong(r6)     // Catch:{ Exception -> 0x0033, all -> 0x0023 }
            r0 = r4
        L_0x0018:
            if (r3 == 0) goto L_0x0038
            r3.release()     // Catch:{ Exception -> 0x001e }
            goto L_0x0038
        L_0x001e:
            r6 = move-exception
            r6.printStackTrace()
            goto L_0x0038
        L_0x0023:
            r6 = move-exception
            goto L_0x0027
        L_0x0025:
            r6 = move-exception
            r3 = r2
        L_0x0027:
            if (r3 == 0) goto L_0x0031
            r3.release()     // Catch:{ Exception -> 0x002d }
            goto L_0x0031
        L_0x002d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0031:
            throw r6
        L_0x0032:
            r3 = r2
        L_0x0033:
            if (r3 == 0) goto L_0x0038
            r3.release()     // Catch:{ Exception -> 0x001e }
        L_0x0038:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.axi.m7359b(java.lang.String):long");
    }
    public static long m7359b(String str) {
        MediaMetadataRetriever mediaMetadataRetriever;
        Throwable th;
        long j = -1;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(9);
                if (extractMetadata != null) {
                    j = Long.parseLong(extractMetadata);
                }
                if (mediaMetadataRetriever != null) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            } catch (Exception unused) {
                if (mediaMetadataRetriever != null) {
                    mediaMetadataRetriever.release();
                }
                return j;
            } catch (Throwable th2) {
                th = th2;
                if (mediaMetadataRetriever != null) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                throw th;
            }
        } catch (Exception unused2) {
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
            }
            return j;
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
            }
         //   throw th;
        }
        return j;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0042 A[SYNTHETIC, Splitter:B:22:0x0042] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0049 A[SYNTHETIC, Splitter:B:27:0x0049] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static String m7360cc(String r7) {
        /*
            r0 = 0
            android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            r1.<init>()     // Catch:{ Exception -> 0x003b, all -> 0x0038 }
            r1.setDataSource(r7)     // Catch:{ Exception -> 0x0036 }
            r7 = 18
            java.lang.String r7 = r1.extractMetadata(r7)     // Catch:{ Exception -> 0x0036 }
            r2 = 19
            java.lang.String r2 = r1.extractMetadata(r2)     // Catch:{ Exception -> 0x0036 }
            if (r7 == 0) goto L_0x002b
            if (r2 == 0) goto L_0x002b
            java.util.Locale r3 = java.util.Locale.ENGLISH     // Catch:{ Exception -> 0x0036 }
            java.lang.String r4 = "%s*%s"
            r5 = 2
            java.lang.Object[] r5 = new java.lang.Object[r5]     // Catch:{ Exception -> 0x0036 }
            r6 = 0
            r5[r6] = r7     // Catch:{ Exception -> 0x0036 }
            r7 = 1
            r5[r7] = r2     // Catch:{ Exception -> 0x0036 }
            java.lang.String r7 = java.lang.String.format(r3, r4, r5)     // Catch:{ Exception -> 0x0036 }
            r0 = r7
        L_0x002b:
            if (r1 == 0) goto L_0x0045
            r1.release()     // Catch:{ Exception -> 0x0031 }
            goto L_0x0045
        L_0x0031:
            r7 = move-exception
            r7.printStackTrace()
            goto L_0x0045
        L_0x0036:
            r7 = move-exception
            goto L_0x003d
        L_0x0038:
            r7 = move-exception
            r1 = r0
            goto L_0x0047
        L_0x003b:
            r7 = move-exception
            r1 = r0
        L_0x003d:
            r7.printStackTrace()     // Catch:{ all -> 0x0046 }
            if (r1 == 0) goto L_0x0045
            r1.release()     // Catch:{ Exception -> 0x0031 }
        L_0x0045:
            return r0
        L_0x0046:
            r7 = move-exception
        L_0x0047:
            if (r1 == 0) goto L_0x0051
            r1.release()     // Catch:{ Exception -> 0x004d }
            goto L_0x0051
        L_0x004d:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0051:
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.axi.m7360c(java.lang.String):java.lang.String");
    }
    public static String m7360c(String str) {
        Throwable th;
        MediaMetadataRetriever mediaMetadataRetriever;
        Exception e;
        String str2 = null;
        try {
            mediaMetadataRetriever = new MediaMetadataRetriever();
            try {
                mediaMetadataRetriever.setDataSource(str);
                String extractMetadata = mediaMetadataRetriever.extractMetadata(18);
                String extractMetadata2 = mediaMetadataRetriever.extractMetadata(19);
                if (!(extractMetadata == null || extractMetadata2 == null)) {
                    str2 = String.format(Locale.ENGLISH, "%s*%s", extractMetadata, extractMetadata2);
                }
                if (mediaMetadataRetriever != null) {
                    try {
                        mediaMetadataRetriever.release();
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
            } catch (Exception e3) {
                e = e3;
                try {
                    e.printStackTrace();
                    if (mediaMetadataRetriever != null) {
                    }
                    return str2;
                } catch (Throwable th2) {
                    th = th2;
                    if (mediaMetadataRetriever != null) {
                        try {
                            mediaMetadataRetriever.release();
                        } catch (Exception e4) {
                            e4.printStackTrace();
                        }
                    }
                    throw th;
                }
            }
        } catch (Exception e5) {
            e = e5;
            mediaMetadataRetriever = null;
            e.printStackTrace();
            if (mediaMetadataRetriever != null) {
                try {
                    mediaMetadataRetriever.release();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
            return str2;
        } catch (Throwable th3) {
            th = th3;
            mediaMetadataRetriever = null;
            if (mediaMetadataRetriever != null) {
            }
            //throw th;
        }
        return str2;
    }

    /* renamed from: d */
    public static String m7361d(String str) {
        if (str == null) {
            return "";
        }
        if ("chi".equals(str)) {
            return "Chinese (simplified)";
        }
        if ("zht".equals(str)) {
            return "Chinese (traditional)";
        }
        if ("zhe".equals(str)) {
            return "Chinese bilingual";
        }
        if ("pob".equals(str)) {
            return "Portuguese (BR)";
        }
        try {
            return new Locale(str).getDisplayLanguage();
        } catch (Exception unused) {
            return str;
        }
    }

    /* renamed from: a */
    public static String m7353a(String str, String str2, String str3, String str4) {
        String b = axc.m7304b(str);
        if (TextUtils.isEmpty(b)) {
            b = axc.m7304b(str2);
            if (TextUtils.isEmpty(b)) {
                b = axc.m7304b(str3);
                if (TextUtils.isEmpty(b)) {
                    return str4;
                }
            }
        }
        String c = axc.m7305c(b);
        return (c == null || c.equals("")) ? str4 : c;
    }

    /* renamed from: a */
    public static String m7352a(long j, long j2) {
        if (j2 <= 0 || j <= 0) {
            return "0 B/s";
        }
        float f = (((float) j) * 1000.0f) / ((float) j2);
        if (f >= 1000000.0f) {
            return String.format(Locale.US, "%.2f MB/s", new Object[]{Float.valueOf((f / 1000.0f) / 1000.0f)});
        } else if (f >= 1000.0f) {
            return String.format(Locale.US, "%.1f KB/s", new Object[]{Float.valueOf(f / 1000.0f)});
        } else {
            return String.format(Locale.US, "%d B/s", new Object[]{Long.valueOf((long) f)});
        }
    }

    /* renamed from: a */
    public static int m7350a(ArrayList<VideoPlayListBean> arrayList) {
        Integer[] numArr = new Integer[arrayList.size()];
        for (int i = 0; i < numArr.length; i++) {
            numArr[i] = Integer.valueOf(i);
        }
        Integer[] numArr2 = (Integer[]) awt.m7203a( numArr);
        Iterator<VideoPlayListBean> it = arrayList.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            int i3 = i2 + 1;
            it.next().f9820h = numArr2[i2].intValue();
            i2 = i3;
        }
        return numArr2[0].intValue();
    }

    /* renamed from: a */
    public static int m7351a(ArrayList<VideoPlayListBean> arrayList, int i, int i2) {
        if (!arrayList.isEmpty() && arrayList.get(0).f9820h == -1) {
            m7350a(arrayList);
        }
        Iterator<VideoPlayListBean> it = arrayList.iterator();
        int i3 = 0;
        while (it.hasNext() && it.next().f9820h != i) {
            i3++;
        }
        int i4 = i3 + i2;
        if (i4 >= arrayList.size()) {
            i4 = 0;
        } else if (i4 < 0) {
            i4 = arrayList.size() - 1;
        }
        int i5 = arrayList.get(i4).f9820h;
        if (i5 < 0) {
            return 0;
        }
        return i5;
    }

    /* renamed from: a */
    public static void m7357a(IMediaPlayer avg, String str, boolean z) {
        if (str != null) {
            PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putString("uvwecu2", str).apply();
            PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().putInt("uvwecu1", Process.myPid()).apply();
        }
        if (z) {
            avg.reset();
        }
        avg.release();
        PreferenceManager.getDefaultSharedPreferences(MyApplication.getApplicationContext_()).edit().remove("uvwecu2").apply();
    }

    /* renamed from: a */
    public static void m7356a(Context context, String str) {
        context.sendBroadcast(new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE", Uri.fromFile(new File(str))));
    }

    /* renamed from: e */
    public static Pair<String, HashMap<String, String>> m7362e(String str) {
        HashMap hashMap;
        if (str != null) {
            String[] split = str.split("\\|");
            if (split.length > 1) {
                String str2 = split[0];
                hashMap = new HashMap(split.length - 1);
                for (int i = 1; i < split.length; i++) {
                    String str3 = split[i];
                    if (!TextUtils.isEmpty(str3)) {
                        for (String split2 : str3.split("&")) {
                            String[] split3 = split2.split("=", 2);
                            if (split3.length == 2) {
                                hashMap.put(split3[0], URLDecoder.decode(split3[1]));
                            }
                        }
                    }
                }
                str = str2;
                return new Pair<>(str, hashMap);
            }
        }
        hashMap = null;
        return new Pair<>(str, hashMap);
    }

    /* renamed from: a */
    public static void m7355a(int i) {
        if (i != 0 && SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("switch", true) && SharedPrefrence.getSharedPrefrence(MyApplication.getApplicationContext_()).getBoolean("effect_adjusted", false)) {
            awe.m7110a(SharedPrefrence.m7395c(MyApplication.getApplicationContext_()));
            awe.m7118c(i);
            awe.m7113a(true);
            awg.m7137a(MyApplication.getApplicationContext_());
            awg.m7139b(i);
            awg.m7138a(true);
            awh.m7148a(MyApplication.getApplicationContext_());
            awh.m7150b(i);
            awh.m7149a(true);
            awd.m7100a(MyApplication.getApplicationContext_());
            awd.m7102b(i);
            awd.m7101a(true);
        }
    }

    /* renamed from: a */
    public static void m7354a() {
        if (awe.m7120d()) {
            awe.m7113a(false);
            awe.m7117c();
        }
        if (awd.m7106c()) {
            awd.m7101a(false);
            awd.m7098a();
        }
        if (awh.m7154c()) {
            awh.m7149a(false);
            awh.m7146a();
        }
        if (awg.m7143c()) {
            awg.m7138a(false);
            awg.m7135a();
        }
    }
}
