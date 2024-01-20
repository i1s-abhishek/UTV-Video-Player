package classesdef.player;

import android.os.Build;
import android.os.Environment;
import android.telephony.TelephonyManager;
import android.text.TextUtils;

import com.abhishek.xplayer.application.MyApplication;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

import classesdef.xdplayer.axe;
import classesdef.xdplayer.axy;

/* renamed from: awr */
public class awr {

    /* renamed from: a */
    public static final String f6137a = Environment.getExternalStorageDirectory().getPath();

    /* renamed from: b */
    static final boolean f6138b;

    /* renamed from: c */
    static final boolean f6139c = MyApplication.getApplicationContext_().getPackageManager().hasSystemFeature("android.hardware.touchscreen");

    /* renamed from: d */
    static final boolean f6140d = MyApplication.getApplicationContext_().getPackageManager().hasSystemFeature("android.software.leanback");

    /* renamed from: e */
    static final boolean f6141e;

    /* renamed from: f */
    static final String[] f6142f = {"huawei", "symphony teleca"};

    /* renamed from: g */
    private static final List<String> f6143g = Arrays.asList(new String[]{"vfat", "exfat", "sdcardfs", "fuse", "ntfs", "fat32", "ext3", "ext4", "esdfs"});

    /* renamed from: h */
    private static final List<String> f6144h = Arrays.asList(new String[]{"tmpfs"});

    /* renamed from: i */
    private static final String[] f6145i = {"/mnt", "/Removable", "/storage"};

    /* renamed from: j */
    private static final String[] f6146j = {"/mnt/secure", "/mnt/shell", "/mnt/asec", "/mnt/obb", "/mnt/media_rw/extSdCard", "/mnt/media_rw/sdcard", "/storage/emulated"};

    /* renamed from: k */
    private static final String[] f6147k = {"/dev/block/vold", "/dev/fuse", "/mnt/media_rw"};

    static {
        HashSet hashSet = new HashSet();
        hashSet.add("HTC One V");
        hashSet.add("HTC One S");
        hashSet.add("HTC One X");
        hashSet.add("HTC One XL");
        boolean z = false;
        f6138b = aws.m7191a() && !hashSet.contains(Build.MODEL);
        if (!TextUtils.equals(Build.BRAND, "Swisscom") && !TextUtils.equals(Build.BOARD, "sprint")) {
            z = true;
        }
        f6141e = z;
    }

    /* renamed from: a */
    public static boolean m7187a() {
        return f6138b;
    }

    /* renamed from: b */
    public static boolean m7188b() {
        return !m7189c() && Build.VERSION.SDK_INT >= 11 && Build.VERSION.SDK_INT <= 16;
    }

    /* renamed from: c */
    public static boolean m7189c() {
        return ((TelephonyManager) MyApplication.getApplicationContext_().getSystemService("phone")).getPhoneType() != 0;
    }

    /* renamed from: d */
    public static ArrayList<String> m7190d() {
        BufferedReader bufferedReader;
        ArrayList<String> arrayList = new ArrayList<>(3);
        try {
            bufferedReader = new BufferedReader(new FileReader("/proc/mounts"));
            while (true) {
                try {
                    String readLine = bufferedReader.readLine();
                    if (readLine == null) {
                        break;
                    }
                    StringTokenizer stringTokenizer = new StringTokenizer(readLine, " ");
                    String nextToken = stringTokenizer.nextToken();
                    String nextToken2 = stringTokenizer.nextToken();
                    String nextToken3 = stringTokenizer.nextToken();
                    if (!arrayList.contains(nextToken2) && !f6144h.contains(nextToken3)) {
                        if (!axs.m7418a(f6146j, nextToken2)) {
                            if (axs.m7418a(f6147k, nextToken) && (f6143g.contains(nextToken3) || axs.m7418a(f6145i, nextToken2))) {
                                int a = axs.m7417a((List<String>) arrayList, axy.m7460a(nextToken2));
                                if (a > -1) {
                                    String str = arrayList.get(a);
                                    if (str == null || !new File(str).exists() || new File(nextToken2).exists()) {
                                        arrayList.remove(a);
                                    }
                                }
                                arrayList.add(nextToken2);
                            }
                        }
                    }
                } catch (IOException unused) {
                } catch (Throwable th) {
                    th = th;
                    axe.m7316a((Closeable) bufferedReader);
                    throw th;
                }
            }
        } catch (IOException unused2) {
            bufferedReader = null;
        } catch (Throwable th) {
            th = th;
            bufferedReader = null;
            axe.m7316a((Closeable) bufferedReader);
          //  throw th;
        }
        axe.m7316a((Closeable) bufferedReader);
        return arrayList;
    }
}
